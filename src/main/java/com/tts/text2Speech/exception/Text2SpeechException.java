package com.tts.text2Speech.exception;

import com.tts.text2Speech.enums.ErrorCode;
import lombok.Getter;

/**
 * The type Text 2 speech exception.
 */
@Getter
public class Text2SpeechException extends RuntimeException {

    private final ErrorCode errorCode;
    private final Throwable throwable;

    /**
     * Instantiates a new Text 2 speech exception.
     *
     * @param errorCode the error code
     * @param throwable the throwable
     */
    public Text2SpeechException(ErrorCode errorCode, Throwable throwable) {
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    /**
     * Instantiates a new Text 2 speech exception.
     *
     * @param errorCode the error code
     */
    public Text2SpeechException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.throwable = null;
    }

    /**
     * Instantiates a new Text 2 speech exception.
     *
     * @param throwable the throwable
     */
    public Text2SpeechException(Throwable throwable) {
        this.errorCode = null;
        this.throwable = throwable;
    }
}
