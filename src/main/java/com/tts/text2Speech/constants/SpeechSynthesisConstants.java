package com.tts.text2Speech.constants;

public class SpeechSynthesisConstants {
    /**
     * To change the speech synthesis language, replace en-US-AvaMultilingualNeural with another
     * supported voic : <a href="https://learn.microsoft.com/en-us/azure/ai-services/speech-service/language-support?tabs=stt#prebuilt-neural-voices">...</a>
     */
    public static final String SPEECH_SYNTHESIS_VOICE_NAME = "en-US-AvaMultilingualNeural";

    private SpeechSynthesisConstants() {
        throw new UnsupportedOperationException("this operation is not supporeted");
    }
}
