package com.example.demo.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class FileController {
    @GetMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }
}
