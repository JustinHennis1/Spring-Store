package com.jhennis.store.controller;

import com.jhennis.store.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/contact")
    public String contact() {
        return("contact.html");
    }
}
