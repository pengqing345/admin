package com.pq.upload.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Controller
public class Controller1 {

    @RequestMapping("/upload")
    public Object upload(MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
/*        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;*/
        //指定本地文件夹存储图片
        String filePath = "E:\\pqTest\\upload\\src\\main\\resources\\upload\\";
        try {
            //将图片保存到static文件夹里
            String newFilePath = filePath + fileName ;
            fileUpload.transferTo(new File(newFilePath));

            return "rigth";
        } catch (Exception e) {
            e.printStackTrace();
            return new message(-1,"fail to upload");
        }
    }

        @RequestMapping("/index")
        public String picUpload(){
            return "index";
        }

}
