package com.sentimentAnalysis.controller;
import com.sentimentAnalysis.service.SentimentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/sentiment")
public class SentimentController {

    private final SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @PostMapping("/analyze")
    public String analyzeSentiment(@RequestBody Map<String, String> payload) {
        String text = payload.get("text");
        return sentimentService.analyzeSentiment(text);
    }
}
