package com.example.demo.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
//    @GetMapping("/toUpload")
//    public String toUpload() {
//        return "upload";
//    }
//    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
//    public String uploadFile(@RequestParam("filename") MultipartFile file) {
//        String filename = file.getOriginalFilename();
//        String dirPath = "C:/environment/TestFile";
//        File filePath = new File(dirPath);
//        if (!filePath.exists()) {
//            filePath.mkdir();
//        }
//        try {
//            file.transferTo(new File(dirPath + filename));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return filename;
//    }

    // 向文件上传页面跳转
    @GetMapping("/toUpload")
    public String toUpload(){
        return "upload";
    }
    // 文件上传管理
    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model model) {
        // 默认文件上传成功，并返回状态信息
        model.addAttribute("uploadStatus", "上传成功！");
        for (MultipartFile file : fileUpload) {
            // 获取文件名以及后缀名
            String fileName = file.getOriginalFilename();
            // 重新生成文件名（根据具体情况生成对应文件名）
            fileName = UUID.randomUUID()+"_"+fileName;
            // 指定上传文件本地存储目录，不存在需要提前创建
            String dirPath = "C:/environment/TestFile";
            File filePath = new File(dirPath);
            if(!filePath.exists()){
                filePath.mkdirs();
            }
            try {
                //new File(file,filename)
                file.transferTo(new File(dirPath,fileName));
            } catch (Exception e) {
                e.printStackTrace();
                // 上传失败，返回失败信息
                model.addAttribute("uploadStatus","上传失败： "+e.getMessage());
            }
        }
        // 携带上传状态信息回调到文件上传页面
        return "upload";
    }
}