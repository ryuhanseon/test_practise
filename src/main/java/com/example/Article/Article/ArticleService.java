package com.example.Article.Article;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<Article> articleList(){
       return this.articleRepository.findAll();
    }
    public Article getArticle(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if (article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundException("article not found");
        }
    }
    public void create(String subject, String content){
        Article a = new Article();
        a.setSubject(subject);
        a.setContent(content);
        a.setCreateDate(LocalDateTime.now());
        this.articleRepository.save(a);
    }



}
