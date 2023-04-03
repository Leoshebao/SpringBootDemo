package com.example.demo;

import com.example.demo.domain.Article;
import com.example.demo.domain.Discuss;
import com.example.demo.domain.Mapper.ArticleMapper;
import com.example.demo.domain.Comment;
import com.example.demo.domain.Mapper.CommentMapper;
import com.example.demo.repository.DiscussRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.lang.System.out;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMyBatis {

//使用配置文件方式整合 MyBatis，编写单元测试对接口进行测试
    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void selectComment(){
        Comment comment = commentMapper.findByid(1);
        System.out.println(comment);
    }
    @Autowired
    private ArticleMapper articleMapper;
    @Test
    public void selectArticle() {
        Article article = articleMapper.selectArticle(1);
        System.out.println(article);
    }

}
