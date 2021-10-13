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
public class LeituraRetornoBancoBradesco implements LeituraRetorno{

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
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDtVencimento(LocalDate.parse(vetor[4], FORMATO_DATA));
                boleto.setDtPagamento(LocalDate.parse(vetor[5], FORMATO_DATA_HORA).atTime(23, 59, 59));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                boletos.add(boleto);
            }
            return boletos;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
}
