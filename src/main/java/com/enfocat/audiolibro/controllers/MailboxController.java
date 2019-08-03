package com.enfocat.audiolibro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import com.enfocat.audiolibro.models.Mailbox;
import com.enfocat.audiolibro.models.User;
import com.enfocat.audiolibro.repositories.MailboxRepository;
import com.enfocat.audiolibro.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class MailboxController {

    @Autowired
    private MailboxRepository mailboxRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public MailboxController(MailboxRepository mailboxRepository) {
        this.mailboxRepository = mailboxRepository;
    }
    
    @PostMapping("/newMail/{username}")
    public String addMail(@PathVariable String username, @ModelAttribute("mailForm") Mailbox mailForm,
                            BindingResult result, Model model) {

        //si tiene error vuelve a cargar la misma pagina
        if (result.hasErrors()) {
            return "mailbox";
        }
        //setteo el id del user logueado para la tabla mailbox
        User user = userRepository.findByUsername(username);
        mailForm.setUsersid(user.getId());

        Mailbox newMailbox = mailboxRepository.save(mailForm);
        model.addAttribute("mailbox", newMailbox);

        return "redirect:/home";
    }
}