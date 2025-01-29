package com.tts.text2Speech.service;

import com.microsoft.cognitiveservices.speech.*;
import com.tts.text2Speech.dto.SpeechSynthesisResponse;
import com.tts.text2Speech.dto.Text2SpeechRequest;
import com.tts.text2Speech.enums.ErrorCode;
import com.tts.text2Speech.exception.Text2SpeechException;
import com.tts.text2Speech.exception.handler.SpeechSynthesisCanceled;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class Text2SpeechService {

    private final SpeechSynthesizer speechSynthesizer;

    /**
     * Convert text to speech.
     * <p>
     * // Asynchronously synthesize the received text to speech.
     * // Note: this is a blocking operation, as the result is needed before the function exits.
     * // For a non-blocking version, use SpeakTextAsync() instead.
     * // The task is complete when the audio is finished playing.
     * // The task returns a result which indicates the reason the audio playback completed.
     * // The cancellation details are available in the result.
     * // Get the speech key from properties file and set it in the SpeechConfig instance.
     *
     * @param request the request
     * @return the speech synthesis response
     */

    public SpeechSynthesisResponse convertTextToSpeech(Text2SpeechRequest request) {
        SpeechSynthesisResponse response = new SpeechSynthesisResponse();
        try {
            SpeechSynthesisResult speechSynthesisResult = speechSynthesizer.SpeakTextAsync(request.getInputText()).get();

            switch (speechSynthesisResult.getReason()) {
                case SynthesizingAudioCompleted:
                    log.info("speech synthesis successful, for text  ={}", request.getInputText());
                    response.setMessage("Speech synthesized to speaker for text [" + request.getInputText() + "]");
                    break;

                case Canceled:
                    throw new Text2SpeechException(ErrorCode.ERROR_SPEECH_SYNTHESIS_CANCELED, new SpeechSynthesisCanceled(this.getCancellationDetails(speechSynthesisResult)));
            }
        } catch (InterruptedException exception) {
            throw new Text2SpeechException(ErrorCode.ERROR_INTERRUPTED_EXCEPTION, exception);
        } catch (ExecutionException exception) {
            throw new Text2SpeechException(ErrorCode.ERROR_EXECUTION_EXCEPTION, exception);
        }
        return response;
    }

    private String getCancellationDetails(SpeechSynthesisResult speechSynthesisResult) {
        StringBuilder message = new StringBuilder();
        SpeechSynthesisCancellationDetails cancellation = SpeechSynthesisCancellationDetails.fromResult(speechSynthesisResult);
        message.append("CANCELED: Reason= ").append(cancellation.getReason());

        if (cancellation.getReason() == CancellationReason.Error) {
            message.append(" ,ErrorCode=").append(cancellation.getErrorCode());
            message.append(" ,ErrorDetails=").append(cancellation.getErrorDetails());
            message.append(" ,hint= Did you set the speech resource key and region values?");
        }
        return message.toString();
    }
}
