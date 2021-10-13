/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.laerton.boletos_bancarios;

import com.laerton.boletos_bancarios.strategy.LeituraRetornoBancoBradesco;
import com.laerton.boletos_bancarios.strategy.LeituraRetornoBancoBrasil;
import com.laerton.boletos_bancarios.strategy.ProcessarBoletos;

/**
 *
 * @author laerton
 */
public class Principal {
    public static void main(String[] args) {
        final  ProcessarBoletos processarBoletos = new ProcessarBoletos(new LeituraRetornoBancoBradesco());
        String nomeArquivo = Principal.class.getResource("/bradesco-1.csv").getPath();
        
        //final  ProcessarBoletos processarBoletos = new ProcessarBoletos(new LeituraRetornoBancoBrasil());
        //String nomeArquivo = Principal.class.getResource("/banco-brasil-1.csv").getPath();

        System.out.println("arquivo "+ nomeArquivo +"\n");
        processarBoletos.processar(nomeArquivo);
    }
}
