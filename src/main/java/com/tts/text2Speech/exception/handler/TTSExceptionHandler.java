package com.tts.text2Speech.exception.handler;

import com.tts.text2Speech.dto.SpeechSynthesisErrorResponse;
import com.tts.text2Speech.exception.Text2SpeechException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * Exception handler for Text to Speech application.
 */
@ControllerAdvice
@Slf4j
public class TTSExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Custom exception handler response entity.
     *
     * @param ex      the ex {@link Text2SpeechException}
     * @param request the request {@link WebRequest}
     * @return the response entity {@link ResponseEntity}
     */
    @ExceptionHandler(value = {Text2SpeechException.class})
    public ResponseEntity<?> customExceptionHandler(Text2SpeechException ex, WebRequest request) {

        log.error("error occurred while processing, errorCode = {}, errorMsg= {}", ex.getErrorCode().name(), ex.getErrorCode().getMsg() + (ex.getThrowable() != null ? ex.getThrowable().getLocalizedMessage() : ""));
        SpeechSynthesisErrorResponse errorResponse = new SpeechSynthesisErrorResponse();
        errorResponse.setCode(ex.getErrorCode().name());
        errorResponse.setMessage(ex.getErrorCode().getMsg());
        errorResponse.setStatus(ex.getErrorCode().getHttpStatus().value());

        return new ResponseEntity<>(errorResponse, ex.getErrorCode().getHttpStatus());

    }
}
