package com.sky.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AudioToTextUtil {

    // 使用Google Cloud Speech-to-Text API将音频文件转为文本
    public static String transcribeAudioToText(File audioFile) throws IOException {
        // 设置 Speech-to-Text API 的客户端
        try (SpeechClient speechClient = SpeechClient.create()) {
            // 加载音频文件并转化为 ByteString
            ByteString audioBytes = ByteString.readFrom(new FileInputStream(audioFile));

            // 设置音频文件的配置
            RecognitionConfig config = RecognitionConfig.newBuilder()
                    .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                    .setSampleRateHertz(16000)
                    .setLanguageCode("en-US")
                    .build();
            RecognitionAudio audio = RecognitionAudio.newBuilder()
                    .setContent(audioBytes)
                    .build();

            // 请求 Google Speech API 进行识别
            RecognizeRequest request = RecognizeRequest.newBuilder()
                    .setConfig(config)
                    .setAudio(audio)
                    .build();

            RecognizeResponse response = speechClient.recognize(request);

            // 返回转录的文本
            StringBuilder transcript = new StringBuilder();
            response.getResultsList().forEach(result -> {
                transcript.append(result.getAlternativesList().get(0).getTranscript());
            });
            return transcript.toString();
        }
    }
}
