package br.com.igor.jogoDaVelha.model;

import br.com.igor.jogoDaVelha.utils.Simbolo;

public class Tabuleiro {
    private final Simbolo[][] casas;

    public Tabuleiro() {
        casas = new Simbolo[3][3];
        limpar();
    }

    public void limpar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                casas[i][j] = Simbolo.VAZIO;
            }
        }
    }

    public Simbolo getCasa(int i, int j) {
        return casas[i][j];
    }

    public boolean isVazia(int i, int j) {
        return casas[i][j] == Simbolo.VAZIO;
    }

    public void setSimbolo(int i, int j, Simbolo s) {
        casas[i][j] = s;
    }
}
