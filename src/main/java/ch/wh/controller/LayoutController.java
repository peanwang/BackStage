package ch.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LayoutController {

    @GetMapping("/layout-static")
    public String layoutStatic(){
        return "layout-static.html";
    }

    @GetMapping("/layout-sidenav-light")
    public String layoutSidenavLight(){
        return "layout-sidenav-light.html";
    }
}
