package com.tts.text2Speech.controllers;

import com.tts.text2Speech.constants.ControllerConstants;
import com.tts.text2Speech.dto.Text2SpeechRequest;
import com.tts.text2Speech.service.Text2SpeechService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The  Text 2 speech controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(ControllerConstants.URL_TEXT_TO_SPEECH_BASE_PATH)
public class Text2SpeechController {

    private final Text2SpeechService text2SpeechService;

    /**
     * Convert text to speech response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping(ControllerConstants.URL_CONVERT_TEXT_TO_SPEECH)
    public ResponseEntity<?> convertTextToSpeech(@RequestBody Text2SpeechRequest request) {

        return ResponseEntity.status(HttpStatus.OK).body(text2SpeechService.convertTextToSpeech(request));
    }
}
