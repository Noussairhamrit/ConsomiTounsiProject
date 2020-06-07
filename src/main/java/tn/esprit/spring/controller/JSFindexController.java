package tn.esprit.spring.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(value = "session")
@Controller(value = "IndexController" )
@ELBeanName(value = "IndexController")
@Join(path = "/index", to = "template/index.jsf")
public class JSFindexController {

}
