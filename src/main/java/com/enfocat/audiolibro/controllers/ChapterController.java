package com.enfocat.audiolibro.controllers;

import java.util.Optional;

import com.enfocat.audiolibro.models.Comments;
import com.enfocat.audiolibro.models.User;
import com.enfocat.audiolibro.models.Story;
import com.enfocat.audiolibro.models.Chapter;
import com.enfocat.audiolibro.repositories.CommentsRepository;
import com.enfocat.audiolibro.repositories.StoryRepository;
import com.enfocat.audiolibro.repositories.ChapterRepository;
import com.enfocat.audiolibro.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scripting.support.ScriptFactoryPostProcessor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(path = "/chapter")
public class ChapterController {

    private final ChapterRepository chapterRepository;
    private final StoryRepository storyRepository;
    private final CommentsRepository commentsRepository;
    private final UserRepository userRepository;

    @Autowired
    public ChapterController(ChapterRepository chapterRepository, StoryRepository storyRepository,CommentsRepository commentsRepository,UserRepository userRepository ) {
        
        this.chapterRepository = chapterRepository;
        this.storyRepository = storyRepository;
        this.commentsRepository = commentsRepository;
        this.userRepository = userRepository;

    }

    @GetMapping("/{id}")
    public String getAll(@PathVariable("id") long id, Model model) {
        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contacto Id:" + id));
        model.addAttribute("chapter", chapter);
        List<Comments> comments = commentsRepository.findByChaptersid(id);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comments());
        return "readchapter";
    }

    @GetMapping("/search")
    public String getContentChapter(@RequestParam("content") String chaptername, Model model) {

        List<Chapter> list = chapterRepository.findByContentContaining(chaptername);
        model.addAttribute("chapters", list);
        return "search";
    }

    @GetMapping("/addchapter/{storyid}")
    public String addChapter(@PathVariable("storyid") long storyid, Chapter chapter, Model model) {
        model.addAttribute("storyid", storyid);
        return "addchapter";
    }

    @PostMapping("/addchapter/{storyid}/{name}")
    public String addChapter(@PathVariable("storyid") long storyid, @PathVariable("name") String name, @Valid Chapter chapter, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "stories-list";
        }

        User user = userRepository.findByUsername(name);
        Story story = storyRepository.findById(storyid).orElseThrow(() -> new IllegalArgumentException("No"));
        chapter.setStory(story);
        chapter.setUser(user);

        List<Chapter> cosas = chapterRepository.findAll();
        long chapnum = 0;
        for ( Chapter capitulo : cosas ) {
            if ( capitulo.getStory().getId() == storyid ) {
                chapnum++;
            }
        }

        chapter.setChapternum(chapnum);
        chapterRepository.save(chapter);
        model.addAttribute("story", story);
        List<Chapter> capitulos = story.getChapters();
        model.addAttribute("capitulos", capitulos);
        return "storyById";
    }
/*
    @GetMapping("/remove/{id}")
    public String removeChapter(@PathVariable("id") long id, Model model) {
        Chapter chapter = chapterRepository.findById(id);
        chapterRepository.delete(chapter);

        return "redirect:/home";

    }*/
}