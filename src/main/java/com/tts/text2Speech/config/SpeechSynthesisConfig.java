package com.tts.text2Speech.config;

import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.tts.text2Speech.constants.SpeechSynthesisConstants;
import com.tts.text2Speech.enums.ErrorCode;
import com.tts.text2Speech.exception.Text2SpeechException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Speech synthesis configuration.
 */
@Configuration
public class SpeechSynthesisConfig {

    @Value("${text2Speech.key}")
    private String speechKey;
    @Value("${text2Speech.region}")
    private String speechRegion;

    /**
     * Create speech synthesizer bean.
     * <p>
     * To change the speech synthesis language, replace en-US-AvaMultilingualNeural with another
     * supported voice : <a href="https://learn.microsoft.com/en-us/azure/ai-services/speech-service/language-support?tabs=stt#prebuilt-neural-voices">...</a>
     *
     * @return the speech synthesizer
     * @throws Text2SpeechException the text 2 speech exception
     */
    @Bean
    public SpeechSynthesizer speechSynthesizer() {
        try (SpeechConfig speechConfig = SpeechConfig.fromSubscription(speechKey, speechRegion)) {

            speechConfig.setSpeechSynthesisVoiceName(SpeechSynthesisConstants.SPEECH_SYNTHESIS_VOICE_NAME);

            return new SpeechSynthesizer(speechConfig);
        } catch (Exception ex) {
            throw new Text2SpeechException(ErrorCode.ERROR_SPEECH_SYNTHESIS_CONFIG, ex);
        }
    }

}
