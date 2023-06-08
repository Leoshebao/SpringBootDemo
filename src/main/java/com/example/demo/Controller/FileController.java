package com.example.demo.Controller;

import org.apache.commons.io.FileUtils;
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
            String dirPath = "E:/Project/unpload_file";
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
//    文件下载
    @GetMapping("/toDownload")
    public String toDownload(){
        return "download";
    }
//    处理下载业务
    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(String filename){
//        设定了文件下载的存储路径(提供下载的文件服务器存放路径)
//        文件名要尽可能是英文，不然容出现http消息头无效（导致无法拉起浏览器的下载弹窗）
        String dirPath = "E:/Project/download_file";
        File file = new File(dirPath + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {return new ResponseEntity<>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.OK);}
        catch (Exception e) {e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(),
                    HttpStatus.EXPECTATION_FAILED);}
    }
}