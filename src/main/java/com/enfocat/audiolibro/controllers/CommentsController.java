package com.enfocat.audiolibro.controllers;

import java.util.Optional;

import com.enfocat.audiolibro.models.Comments;
import com.enfocat.audiolibro.models.User;
import com.enfocat.audiolibro.models.Story;
import com.enfocat.audiolibro.models.Chapter;
import com.enfocat.audiolibro.repositories.CommentsRepository;
import com.enfocat.audiolibro.repositories.StoryRepository;
import com.enfocat.audiolibro.repositories.UserRepository;
import com.enfocat.audiolibro.repositories.ChapterRepository;

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
import java.util.List;

@Controller
@RequestMapping(path = "/comments")
public class CommentsController {

    private final CommentsRepository commentsRepository;
    private final ChapterRepository chapterRepository;
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentsController(CommentsRepository commentsRepository,ChapterRepository chapterRepository, StoryRepository storyRepository,UserRepository userRepository) {
        this.commentsRepository = commentsRepository;
        this.chapterRepository = chapterRepository;
        this.storyRepository = storyRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("comment", commentsRepository.findAll());
        return "commentlist";
    }

    @GetMapping("/addcomment/{chapterid}")
    public String addComment(@PathVariable("chapterid") long chapterid, Comments comments, Model model) {
        model.addAttribute("chapterid", chapterid);
        return "addcomment";
    }

    @PostMapping("/addcomment")
    public String addComment(@Valid Comments comments, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addcomment";
        }
        
        commentsRepository.save(comments);
        Chapter chapter = new Chapter();
        chapter = chapterRepository.findById(comments.getChaptersid()).orElseThrow(() -> new IllegalArgumentException("No"));
        List<Comments> comments2 = commentsRepository.findByChaptersid(comments.getChaptersid());
        model.addAttribute("comments", comments2);
        model.addAttribute("chapter", chapter);
        return "readchapter";
    } 

}