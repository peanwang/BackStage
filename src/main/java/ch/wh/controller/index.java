package ch.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class index {
    @GetMapping({"/", "index.html"})
    public String index() {
        return "index.html";
    }
}
