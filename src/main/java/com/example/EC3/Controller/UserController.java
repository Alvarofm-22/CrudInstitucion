package com.example.EC3.Controller;

import com.example.EC3.Model.User;
import com.example.EC3.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String Home(){
        return "Index";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("userModel", new User());
        return "Login/Index";
    }


    @PostMapping("/loginProcess")
    public String loginProcess(Model model,
                               @RequestParam String userName,
                               @RequestParam String password) {

        User userModel = new User(); // Inicializamos el objeto User
        model.addAttribute("userModel", userModel); // Agregamos el objeto al modelo

        User user = userService.consultar(userName);

        if (user != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(password, user.getPassword())) {
                System.out.println("Contraseña válida para el usuario: " + userName);
                return "redirect:/home"; // Redirecciona al home si la contraseña es correcta
            } else {
                System.out.println("Contraseña inválida para el usuario: " + userName);
            }
        } else {
            System.out.println("Usuario no encontrado: " + userName);
        }

        // Configuramos el mensaje de error para usuarios o contraseñas incorrectos
        model.addAttribute("error", "No tienes acceso");
        return "Login/Index";
    }


    @GetMapping("/cerrarSesion")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }




}
