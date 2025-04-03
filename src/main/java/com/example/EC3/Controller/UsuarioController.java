package com.example.EC3.Controller;

import com.example.EC3.Model.Profesor;
import com.example.EC3.Model.User;
import com.example.EC3.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UserService userService;

    @GetMapping("Usuarios")
    public String Index(Model model){
        List<User> users = userService.getAll();
        model.addAttribute("usuarios", users);
        return "User/Index";
    }

    @GetMapping("Usuarios/Create")
    public String Create(Model model){
        model.addAttribute("usuarios", new User());
        return "User/Create";
    }

    @PostMapping("Usuarios/Create")
    public String Create(@RequestParam String userName,
                         @RequestParam String password,
                         @RequestParam String role,
                         @RequestParam Boolean isEnabled){
        User user = new User();

        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(role);
        user.setEnabled(isEnabled);

        userService.registrar(user);

        return "redirect:/Usuarios";
    }


}
