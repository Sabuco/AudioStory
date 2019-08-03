package com.enfocat.audiolibro.controllers;

import java.util.Date;
import java.util.List;

import com.enfocat.audiolibro.models.Chapter;
import com.enfocat.audiolibro.models.User;
import com.enfocat.audiolibro.repositories.ChapterRepository;
import com.enfocat.audiolibro.repositories.StoryRepository;
import com.enfocat.audiolibro.repositories.UserRepository;
import com.enfocat.audiolibro.service.SecurityService;
import com.enfocat.audiolibro.service.UserService;
import com.enfocat.audiolibro.validator.UserValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;
    private ChapterRepository chapterRepository;
   
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "/registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
          
            return "/registration";
        }

        Date date = new Date();
        userForm.setRegisteredDate(date);
        
        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }

   
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "El nombre de usuario/password no son válidos.");

        if (logout != null)
            model.addAttribute("message", "Has salido correctamente.");

        return "/login";
    }

    @GetMapping({"/welcome"})
    public String welcome(Model model) {
        return "/stories-list";
    }
    
    @GetMapping({"/readbook"})
    public String readbook(Model model) {
        return "read-book";
    }
    

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable("id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid contacto Id:" + id));
        model.addAttribute("user",user);
        List<Chapter> chapters = user.getChapters();
        model.addAttribute("chapters", chapters);
        System.out.println("capitols...");
        System.out.println(chapters.size());
        return "showUser";



        /*Story story = storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid contacto Id:" + id));
        model.addAttribute("story", story);
        List<Chapter> capitulos = chapterRepository.findByStoriesid(id);
        model.addAttribute("capitulos", capitulos);
        return "storyById";*/
    }

    @GetMapping("/user/getUserLogged")
    public String getUserLogged(Authentication authentication){
        String  usrName = authentication.getName();
        User usr = userRepository.findByUsername(usrName);
        return "redirect:/user/"+usr.getId();
    }
}