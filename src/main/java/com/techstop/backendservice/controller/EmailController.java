package com.techstop.backendservice.controller;
import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techstop.backendservice.model.TechResponseView;
import com.techstop.backendservice.service.ServiceBackend;


@CrossOrigin ("http://localhost:3000/")
@Controller
@RequestMapping("/api/v1/techstop/")
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	ServiceBackend backendService;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/email/{cwid}")
	public String sendPlainTextEmail(Model model, @PathVariable String cwid) {
		String from = "techstopNYP@nyp.org";
//		String to = cwid+"@nyp.org";
		String to = "msb9010@nyp.org";
		
		List<TechResponseView>  view = backendService.getRequestViewsByCwid(cwid);
		
		TechResponseView lastRequest = view.get(view.size()-1);
		
		System.out.println(lastRequest.getReqId());
		
		String body = """
		        Thanks for using the techstop reserve feature your request number is: """+lastRequest.getReqId()
		        +"\n Type of Phones: " + lastRequest.getReqTypes()
		        +"\n Amount needed: " + lastRequest.getReqAmount() 
		        +"\n Pick up Time: " + lastRequest.getReqTime()
		        +"\n Pick up Date: " + lastRequest.getReqDate()
		        +"\n Requested by: " + lastRequest.getReqCwid()
		        +"\n A tech will respond to you shortly (estimated within 15 minutes) with an update on your request.";
		

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("Your TechStop Reversation");
		message.setText(body);
		
		mailSender.send(message);
		
		model.addAttribute("message", "A plain text email has been sent");
		
		System.out.println(message);
		return "result";
	}
	
	@GetMapping("/send_html_email")
	public String sendHTMLEmail(Model model) throws MessagingException {
		String from = "maxdice86@gmail.com";
		String to = "yaadlink@yahoo.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setSubject("This is an HTML email");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText("<b>Hey guys</b>,<br><i>Welcome to my new home</i>", html);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email has been sent");
		return "result";		
	}
	
	@GetMapping("/send_email_attachment")
	public String sendHTMLEmailWithAttachment(Model model) throws MessagingException {
		
		String from = "codejava.net@gmail.com";
		String to = "hainatu@gmail.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Here's your e-book");
		helper.setFrom(from);
		helper.setTo(to);
		
		helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>", true);
		
		FileSystemResource file = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\SuccessFreelance-Preview.pdf"));
		helper.addAttachment("FreelanceSuccess.pdf", file);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email with attachment has been sent");
		return "result";		
	}
	
	@GetMapping("/send_email_inline_image")
	public String sendHTMLEmailWithInlineImage(Model model) throws MessagingException {
		
		String from = "codejava.net@gmail.com";
		String to = "hainatu@gmail.com";
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Here's your pic");
		helper.setFrom(from);
		helper.setTo(to);
		
		String content = "<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i>"
							+ "<br><img src='cid:image001'/><br><b>Best Regards</b>"; 
		helper.setText(content, true);
		
		FileSystemResource resource = new FileSystemResource(new File("g:\\MyEbooks\\Freelance for Programmers\\images\\admiration.png"));
		helper.addInline("image001", resource);

		mailSender.send(message);
		
		model.addAttribute("message", "An HTML email with inline image has been sent");
		return "result";		
	}	
}
