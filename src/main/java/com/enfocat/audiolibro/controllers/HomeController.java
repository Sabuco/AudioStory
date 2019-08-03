package com.enfocat.audiolibro.controllers;

import java.util.ArrayList;
import java.util.List;

import com.enfocat.audiolibro.models.Story;
import com.enfocat.audiolibro.repositories.StoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class HomeController {

    private final StoryRepository storyRepository;

    @Autowired
    public HomeController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;

    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Story> cosas = storyRepository.findAll();
        Random rnd = new Random();

        if ( cosas.size() <= 0 ) {
            
        } else {
            int id = rnd.nextInt(cosas.size());
            Long id2 = cosas.get(id).getId();
    
            Story story1 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
    
            id = rnd.nextInt(cosas.size());
            id2 = cosas.get(id).getId();
    
            Story story2 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
    
            id = rnd.nextInt(cosas.size());
            id2 = cosas.get(id).getId();
    
            Story story3 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
    
            model.addAttribute("story1", story1);
            model.addAttribute("story2", story2);
            model.addAttribute("story3", story3);
            model.addAttribute("size", cosas.size());
        }
        return "stories-list";
    }
 
    @GetMapping("/")
    public String root(Model model) {
        List<Story> cosas = storyRepository.findAll();
        Random rnd = new Random();

        if ( cosas.size() <= 0 ) {
                
        } else {
            int id = rnd.nextInt(cosas.size());
            Long id2 = cosas.get(id).getId();
    
            Story story1 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
            id = rnd.nextInt(cosas.size());
                id2 = cosas.get(id).getId();
        
                Story story2 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
        
                id = rnd.nextInt(cosas.size());
                id2 = cosas.get(id).getId();
        
                Story story3 = storyRepository.findById(id2).orElseThrow(() -> new IllegalArgumentException("No"));
        
                model.addAttribute("story1", story1);
                model.addAttribute("story2", story2);
                model.addAttribute("story3", story3);
                model.addAttribute("size", cosas.size());
            }
        return "stories-list";
    }
 

    @GetMapping("/addMailBox/{username}")
    public String mailbox(@PathVariable String username, Model model) {
        model.addAttribute("currentUserName", username);
        return "mailbox";
    }
  

    @GetMapping("/uploadIn/{id}")
    public String uploading(@PathVariable long id, Model model) {
        //añadimos la id que recibimos actualmente al nuevo jsp up-file
        model.addAttribute("idstory", id);
        return "up-file";
    }

    @GetMapping("/uploadAudio/{id}")
    public String uploadingAudio(@PathVariable long id, Model model) {
        //añadimos la id que recibimos actualmente al nuevo jsp up-file
        model.addAttribute("idchapter", id);
        return "up-audio";
    }
}

