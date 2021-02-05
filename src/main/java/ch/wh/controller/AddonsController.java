package ch.wh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddonsController {
    @GetMapping("/charts")
    public String charts() {
        return "charts.html";
    }


    @GetMapping("/tables")
    public String tables() {
        return "tables.html";
    }
}
