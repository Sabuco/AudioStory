package com.enfocat.audiolibro.controllers;

import java.util.Optional;
import java.util.Random;

import com.enfocat.audiolibro.models.Comments;
import com.enfocat.audiolibro.models.Story;
import com.enfocat.audiolibro.models.Chapter;
import com.enfocat.audiolibro.repositories.StoryRepository;
import com.enfocat.audiolibro.repositories.ChapterRepository;

import javax.validation.Valid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(path = "/story")
public class StoryController {

    private final StoryRepository storyRepository;
    private final ChapterRepository chapterRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository, ChapterRepository chapterRepository) {
        this.storyRepository = storyRepository;
        this.chapterRepository = chapterRepository;

    }

    @GetMapping("/{id}")
    public String getId(@PathVariable("id") long id, Model model) {
        if (id == -1) {
            // cosas = historias
            List<Story> cosas = storyRepository.findAll();
            Random rnd = new Random();
            int i = rnd.nextInt(cosas.size());
            id = cosas.get(i).getId();
        }

        Story story = storyRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));

        model.addAttribute("story", story);
        List<Chapter> capitulos = story.getChapters();
        model.addAttribute("capitulos", capitulos);
        return "storyById";
    }

    @GetMapping("/list")
    public String getsAll(Model model) {
        model.addAttribute("story", storyRepository.findAll());
        return "stories-list";
    }

    @GetMapping("/search")
    public String getTitleStory(@RequestParam("title") String storyname, Model model) {

        List<Story> list = storyRepository.findByTitleContaining(storyname);  
        
        model.addAttribute("stories", list);
        return "search";
    }

    @GetMapping("/addStory/{id}")
    public String addStory(@PathVariable("id") String challangeId, Model model) {
        Story story = new Story();
        Long id = Long.parseLong(challangeId);
        story.setChallengesid(id);
        model.addAttribute("storyForm", story);

        return "new-story";
    }

    @PostMapping("/addStory/{id}")
    public String addStoryPost(@ModelAttribute("storyForm") Story storyForm,
                               @PathVariable("id") long challangeId, Model model) {
        // get ImageFile name
        String cover = "CoverDefault.png";
        storyForm.setCover(cover);

        Date date = new Date();

        storyForm.setCreatedDate(date);
        storyForm.setUpdatedDate(date);

        Story miObj = storyRepository.save(storyForm);
        model.addAttribute("story", miObj);

        return "redirect:/home";
    }

    @GetMapping("/read")
    public String chapterRead(Comments comments) {
        return "readchapter";
    }

}
