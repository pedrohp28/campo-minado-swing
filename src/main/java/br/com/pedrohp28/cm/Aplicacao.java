package br.com.pedrohp28.cm;

import br.com.pedrohp28.cm.modelo.Tabuleiro;
import br.com.pedrohp28.cm.visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);

        new TabuleiroConsole(tabuleiro);
    }
}
