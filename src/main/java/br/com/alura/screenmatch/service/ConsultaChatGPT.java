package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ConsultaChatGPT {
	
	public static String obterTraducao(String texto) {
		OpenAiService service = new OpenAiService("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");

		CompletionRequest requisicao = CompletionRequest.builder().model("gpt-3.5-turbo-instruct")
				.prompt("traduza para o português o texto: " + texto).maxTokens(10).temperature(0.7).build();

		var resposta = service.createCompletion(requisicao);
		return resposta.getChoices().get(0).getText();
	}
}
