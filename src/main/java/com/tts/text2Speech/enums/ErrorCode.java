package com.tts.text2Speech.enums;

import com.microsoft.cognitiveservices.speech.SpeechSynthesisCancellationDetails;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error occurred"),
    ERROR_SPEECH_SYNTHESIS_CONFIG(HttpStatus.INTERNAL_SERVER_ERROR, "error occurred in configuration of speech synthesizer"),
    ERROR_INTERRUPTED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Interrupted exception occurred while synthesizing text to speech"),
    ERROR_EXECUTION_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "Execution Exception occurred while synthesizing text to speech"),
    ERROR_SPEECH_SYNTHESIS_CANCELED(HttpStatus.PRECONDITION_FAILED, "Speech synthesis canceled, ");


    private final HttpStatus httpStatus;
    private final String msg;

    ErrorCode(HttpStatus httpStatus, String msg) {
        this.httpStatus = httpStatus;
        this.msg = msg;
    }
}
