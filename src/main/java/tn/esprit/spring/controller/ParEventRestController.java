package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.config.EmailCfg;
import tn.esprit.spring.entity.ParEvent;
import tn.esprit.spring.service.ParEventService;

import javax.validation.ValidationException;

@RestController
//@RequestMapping("/parevent")
public class ParEventRestController {
	@Autowired
	ParEventService pareventService;

    private EmailCfg emailCfg;

    public ParEventRestController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping("/mail")
    public void sendFeedback(@RequestBody ParEvent parevent,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Email is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("khalilbelamine2005@gmail.com");
        mailMessage.setTo(parevent.getParmail());
        mailMessage.setSubject("Invitation to event " + parevent.getParname());
        mailMessage.setText("Vous etes invités a l'evenement"  + "Mr" + parevent.getParname());

        // Send mail
        mailSender.send(mailMessage);
    }
 // http://localhost:8081/SpringMVC/servlet/AffecterParticipantAEvent/1/1
    @PutMapping(value = "/affecterParticipantAEvent/{idparevent}/{idevent}") 
	public void affecterParticipantAEvent(@PathVariable("idparevent")int pareventId, @PathVariable("idevent")int eventId) {
		pareventService.affecterParticipantAEvent(pareventId, eventId);
		
	}
 // http://localhost:8081/SpringMVC/servlet/desaffecterParticipantDEvent/1/1
 	@PutMapping(value = "/desaffecterEmployeDEvenement/{idparevent}/{idevent}") 
 	public void desaffecterParticipantDEvenement(@PathVariable("idparevent")int pareventId, @PathVariable("idevent")int eventId)
 	{
 		pareventService.desaffecterParticipantDEvenement(pareventId, eventId);
 	}
  
 // URL : http://localhost:8081/SpringMVC/servlet/getNombreEmployeJPQL
    @GetMapping(value = "/getNombreParticipant")
    @ResponseBody
	public int getNombreParticipantJPQL() {
		
		return pareventService.getNombreParticipantJPQL();
	}
 	
 	
    
}
