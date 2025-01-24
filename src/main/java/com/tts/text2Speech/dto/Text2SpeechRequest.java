package com.tts.text2Speech.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Text2SpeechRequest {


    @NonNull
    private String inputText;
}
