package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.service.LessonPlanService;
import com.sky.utils.AudioToTextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class AudioController {

    @Autowired
    private LessonPlanService lessonPlanService;

    // 处理音频上传并转成文本
    @PostMapping("/audio-to-text")
    public Result<String> audioToText(@RequestParam("fileName") String fileName) {
        // 假设文件已经被上传到服务器的指定目录
        String filePath = "/path/to/uploaded/audio/files/" + fileName;
        File audioFile = new File(filePath);

        // todo: API 将音频转换为文本
        //try {
//            String transcript = AudioToTextUtil.transcribeAudioToText(audioFile);
//            return Result.success(transcript);
            return null;
//        } catch (IOException e) {
//            return Result.error("音频转文本失败");
//        }
    }
}
