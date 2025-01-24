package com.tts.text2Speech.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpeechSynthesisErrorResponse {
    private String code;
    private String message;
    private int status;
}
