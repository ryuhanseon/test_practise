package com.example.Article.Article;


import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/article")

@Controller
public class ArticleController {


    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/list")
    public String articleList(Model model) {
        List<Article> articleList = this.articleService.articleList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }


    @GetMapping(value = "/detail/{id}")
    public String articleDetail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }


    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {

        return "article_form";
    }


    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "article_detail";
        }
        this.articleService.create(articleForm.getSubject(), articleForm.getContent());
        return "redirect:/article/list";
    }


}
