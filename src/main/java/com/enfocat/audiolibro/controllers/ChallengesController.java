package com.enfocat.audiolibro.controllers;

import java.util.Optional;

import com.enfocat.audiolibro.models.Challenges;
import com.enfocat.audiolibro.repositories.ChallengesRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/challenges")
public class ChallengesController {

    private final ChallengesRepository challengesRepository;

    @Autowired
    public ChallengesController(ChallengesRepository challengesRepository) {
        this.challengesRepository = challengesRepository;
    }

    @GetMapping("/list")
    public String getAll(Model model){
        model.addAttribute("challenge", challengesRepository.findAll());
        return "challengelist";
    }
    
    @GetMapping("/addchallenge")
    public String addContacto(Challenges challenges) {
        return "addchallenge";
    }

    @PostMapping("/addchallenge")
    public String addContacto(@Valid Challenges challenges, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addchallenge";
        }

        challengesRepository.save(challenges);
        model.addAttribute("challenge", challengesRepository.findAll());
        return "challengelist";
    }

}