package com.xiaor.controller;

import com.xiaor.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

//@Slf4j
@RestController
public class UploadController {
    static private Logger log = LoggerFactory.getLogger(UploadController.class);

    /**
     * 文件上传
     * @param name
     * @param age
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result upload(String name, Integer age, @RequestParam("image") MultipartFile file) throws IOException {
        log.info("文件上传, 参数 : {}, {}, {}", name, age, file);
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 生成新的文件名,避免重复-uuid(通用统一识别码)
        int lastIndexOf = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(lastIndexOf);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名 : {}", newFileName);
        // 将文件保存到本地磁盘
        file.transferTo(new File("D:\\xiaoR\\project\\tlias-web-management\\target\\resources\\" + newFileName));
        return Result.success();
    }
}
