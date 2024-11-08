package com.aluracursos.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
    public static String obtenerTraduccion(String texto) {
        OpenAiService service = new OpenAiService("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");

        CompletionRequest requisicion = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("traduce a español el siguiente texto: " + texto)
                .maxTokens(1000)
                .temperature(0.7)
                .build();

        var respuesta = service.createCompletion(requisicion);
        return respuesta.getChoices().get(0).getText();
    }
}