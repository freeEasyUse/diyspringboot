package org.freeuse.spbt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    
    @RequestMapping("/websocket")
    public String websocket(){
    	return "websocket";
    }
    
    @RequestMapping("websockjs")
    public String websockjs(){
    	return "websocket_sockjs";
    }
    
}