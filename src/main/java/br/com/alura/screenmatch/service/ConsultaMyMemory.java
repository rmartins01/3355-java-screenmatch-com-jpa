package br.com.alura.screenmatch.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.alura.screenmatch.model.DadosTraducao;

public class ConsultaMyMemory {
    public static String obterTraducao(String text) {
        ObjectMapper mapper = new ObjectMapper();

        ConsumoApi consumo = new ConsumoApi();

		try {
			String texto = URLEncoder.encode(text, "UTF-8");
			String langpair = URLEncoder.encode("en|pt-br", "UTF-8");
			
			String url = "https://api.mymemory.translated.net/get?q=" + texto + "&langpair=" + langpair;
			
			String json = consumo.obterDados(url);
			
			return mapper.readValue(json, DadosTraducao.class).dadosResposta().textoTraduzido();
			
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			e.printStackTrace();
		}

        return null;
    }
}