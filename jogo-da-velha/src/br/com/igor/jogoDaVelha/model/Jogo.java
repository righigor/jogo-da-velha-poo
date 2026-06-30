package br.com.igor.jogoDaVelha.model;

import br.com.igor.jogoDaVelha.utils.Simbolo;

public class Jogo {
    private final Tabuleiro tabuleiro;
    private Simbolo jogadorVez;
    private boolean jogoFinalizado;
    private Simbolo vencedor;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        this.jogadorVez = Simbolo.X;
        this.jogoFinalizado = false;
        this.vencedor = Simbolo.VAZIO;
    }

    public Simbolo getVencedor() {
        return vencedor;
    }

    public void setVencedor(Simbolo vencedor) {
        this.vencedor = vencedor;
    }

    public Simbolo getJogadorVez() {
        return jogadorVez;
    }

    public boolean isJogoFinalizado() {
        return jogoFinalizado;
    }

    public void setJogoFinalizado(boolean jogoFinalizado) {
        this.jogoFinalizado = jogoFinalizado;
    }

    private void trocaJogador() {
        if (jogadorVez == Simbolo.X) {
            jogadorVez = Simbolo.O;
        } else {
            jogadorVez = Simbolo.X;
        }
    }

    public boolean marcar(int i, int j) {
        if (jogoFinalizado) return false;

        if (!tabuleiro.isVazia(i, j)) return false;

        tabuleiro.setSimbolo(i, j, jogadorVez);

        if (verificaVencedor(jogadorVez)) {
            vencedor = jogadorVez;
            jogoFinalizado = true;
            return true;
        }

        if (verificaEmpate()) {
            jogoFinalizado = true;
            return true;
        }
        trocaJogador();
        return true;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    private boolean verificaVencedor(Simbolo s) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCasa(i, 0) == s &&
                tabuleiro.getCasa(i, 1) == s && tabuleiro.getCasa(i, 2) == s
            ) return  true;
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro.getCasa(0, i) == s &&
                    tabuleiro.getCasa(1, i) == s && tabuleiro.getCasa(2, i) == s
            ) return  true;
        }

        if (tabuleiro.getCasa(0, 0) == s &&
                tabuleiro.getCasa(1, 1) == s && tabuleiro.getCasa(2, 2) == s
        ) return  true;

        if (tabuleiro.getCasa(0, 2) == s &&
                tabuleiro.getCasa(1, 1) == s && tabuleiro.getCasa(2, 0) == s
        ) return  true;

        return false;
    }

    private boolean verificaEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro.isVazia(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void reiniciar() {
        tabuleiro.limpar();
        jogadorVez = Simbolo.X;
        vencedor = Simbolo.VAZIO;
        jogoFinalizado = false;
    }
}
