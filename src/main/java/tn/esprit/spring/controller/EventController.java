package tn.esprit.spring.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tn.esprit.spring.entity.Event;
import tn.esprit.spring.service.EventServiceImpl;



@Controller
public class EventController{
@Autowired
EventServiceImpl es;
@RequestMapping("/sayHello")
public String welcome(Map<String, Object> model, @RequestParam("myName") String name) {
model.put("receivedName", name);
return"helloPage";
}
@RequestMapping(value = "/", method= RequestMethod.GET)
public String events(Event event, Model model) {
model.addAttribute("event", new Event());
model.addAttribute("events", es.retrieveAllEvents());
return"events";
}

}






