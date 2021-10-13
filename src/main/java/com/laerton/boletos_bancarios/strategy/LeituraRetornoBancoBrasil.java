/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laerton.boletos_bancarios.strategy;

import com.laerton.boletos_bancarios.entities.Boleto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laerton
 */
public class LeituraRetornoBancoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(String nomeArquivo) {
        try {
            BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(nomeArquivo));
            String linha;
            List<Boleto> boletos = new ArrayList<>();
            
            while ((linha = bufferedReader.readLine()) != null) {
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setDtVencimento(LocalDate.parse(vetor[2], FORMATO_DATA));
                boleto.setDtPagamento(LocalDate.parse(vetor[3], FORMATO_DATA).atTime(0, 0, 0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));

                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
}
