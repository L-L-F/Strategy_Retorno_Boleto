/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laerton.boletos_bancarios.strategy;

import com.laerton.boletos_bancarios.entities.Boleto;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author laerton
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public List<Boleto> lerArquivo(String nomeArquivo);
}
