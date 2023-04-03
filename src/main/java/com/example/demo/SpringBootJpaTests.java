package com.example.demo;

import com.example.demo.domain.Discuss;
import com.example.demo.repository.DiscussRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static java.lang.System.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaTests {
    @Autowired
    private DiscussRepository repository;
    @Test
    public void selectCommentByKeys() {
        List<Discuss> list = repository.findByAuthorNotNull();
        out.println(list);
    }

}
