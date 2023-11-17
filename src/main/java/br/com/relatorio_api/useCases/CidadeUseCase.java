package br.com.relatorio_api.useCases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.relatorio_api.bean.EnderecoBean;
import br.com.relatorio_api.entity.CidadeEntity;
import br.com.relatorio_api.repository.CidadeRepository;

@Service
public class CidadeUseCase {

  @Autowired
  private CidadeRepository cidadeRepository;

  public EnderecoBean create(String cep) throws IOException {
    String enderecoURL = "https://viacep.com.br/ws/" + cep + "/json/";
        URL url = new URL(enderecoURL);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setDoInput(true);
        BufferedReader buff = new BufferedReader(new InputStreamReader((conexao.getInputStream()), "utf-8"));

            String convertJsonString = converteJsonEmString(buff);
            Gson gson = new Gson();
            EnderecoBean endereco = gson.fromJson(convertJsonString, EnderecoBean.class);
            CidadeEntity cidade = new CidadeEntity();
            cidade.setName(endereco.getLocalidade());
            cidade.setCreatedAt(LocalDateTime.now());
            cidade.setUpdatedAt(LocalDateTime.now());
            cidadeRepository.save(cidade);
            
            return endereco;
  }

  public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonString += resposta;
        }
        return jsonString;
    }
}
