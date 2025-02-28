package com.sky.controller;

import com.sky.context.BaseContext;
import com.sky.result.Result;
import com.sky.service.AudioTranscriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/audio")
@Api(tags = "音频处理相关接口")
@CrossOrigin
@Slf4j
public class AudioController {

    @Value("${sky.audio.path}")
    private String audioPath;

    @Autowired
    private AudioTranscriptionService audioTranscriptionService;

    /**
     * 处理音频上传并转成文本
     */
    @PostMapping("/upload")
    @ApiOperation("音频转文本")
    public Result<String> audioToText(@RequestParam("file") MultipartFile file) {
        try {
            // 获取当前用户ID
            Long userId = BaseContext.getCurrentId();
            
            // 构建用户音频目录
            String userDir = audioPath + File.separator + userId;
            Path userPath = Paths.get(userDir);
            if (!Files.exists(userPath)) {
                Files.createDirectories(userPath);
            }

            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString() + extension;
            
            // 保存文件
            String filePath = userDir + File.separator + newFilename;
            file.transferTo(new File(filePath));
            
            log.info("开始处理音频转文本请求，文件名：{}", originalFilename);
            String text = audioTranscriptionService.transcribeAudio(file);
            return Result.success(text);
        } catch (IOException e) {
            log.error("音频文件保存失败：", e);
            return Result.error("音频文件保存失败：" + e.getMessage());
        } catch (Exception e) {
            log.error("音频转文本失败：", e);
            return Result.error("音频转文本失败：" + e.getMessage());
        }
    }
}
