package com.tts.text2Speech.exception.handler;

/**
 * The type Speech synthesis canceled exception
 */
public class SpeechSynthesisCanceled extends RuntimeException {

    /**
     * Instantiates a new Speech synthesis canceled exception
     *
     * @param msg the msg
     */
    public SpeechSynthesisCanceled(String msg) {
        super(msg);
    }
}
