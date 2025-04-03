package com.example.EC3.Controller;

import com.example.EC3.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String Index(){
        return "Index";
    }


}
