package ch.wh.controller;

import ch.wh.pojo.User;
import ch.wh.service.EmployeeService;
import ch.wh.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UserController {

    private String KEY_USER = "USER";

    private String Employee_KEY = "Employee";
    @Autowired
    UserService userService;

    @Autowired
    EmployeeService employeeService;

    final Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password) {
        try {
            User user = userService.register(firstName, lastName, email, password);
            logger.info("user registered: {}", user.getEmail());
        } catch (Exception e) {
            return new ModelAndView("register.html");
        }
        return new ModelAndView("redirect:/login");
        /*
            return new ModelAndView("register.html", Map.of("email", email, "error", "Register failed"));
         */
    }

    @GetMapping("/login")
    public ModelAndView login(HttpSession session) {
        User user = (User) session.getAttribute(KEY_USER);
        if(user != null){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("login.html");
    }

    @PostMapping("/login")
    public ModelAndView dologin(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                          HttpSession session) {
        try {
            User user = userService.signin(email, password);
            session.setAttribute(KEY_USER, user);

            if(session.getAttribute(Employee_KEY) == null){
                session.setAttribute(Employee_KEY, employeeService.queryAll());
            }
        } catch (RuntimeException e) {
            return new ModelAndView("login.html", Map.of("email", email, "error", "Signin failed"));
        }
        return new ModelAndView("redirect:/");
    }



    @GetMapping("/reset")
    public String reset() {
        return "password.html";
    }

    @PostMapping("/reset")
    public ModelAndView doreset(@RequestParam("email") String email,
                          @RequestParam("password") String password,
                                HttpSession session) {
        try {
            Integer ret = userService.changePassword(email, password);
        } catch (RuntimeException e) {
            return new ModelAndView("password.html", Map.of("email", email, "error", "Signin failed"));
        }
        System.out.println(email + "  " + password);
        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/logout")
    public String signout(HttpSession session) {
        session.removeAttribute(KEY_USER);
        return "redirect:/login";
    }
}
