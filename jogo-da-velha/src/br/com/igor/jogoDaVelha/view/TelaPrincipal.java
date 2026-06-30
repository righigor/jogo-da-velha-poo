package br.com.igor.jogoDaVelha.view;

import br.com.igor.jogoDaVelha.model.Jogo;
import br.com.igor.jogoDaVelha.utils.Simbolo;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {
    private JButton[][] botoes;
    private final Jogo jogo;
    private JLabel jogador;
    private JButton novaPartidaBtn;

    public TelaPrincipal()  {
        this.jogo = new Jogo();
        configTela();
        atualizarTela();
    }

    private void configTela() {
        setTitle("Jogo da velha");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        jogador = new JLabel("Jogador: ", SwingConstants.CENTER);
        add(jogador, BorderLayout.NORTH);
        JPanel painel = criaTabuleiro();
        add(painel, BorderLayout.CENTER);

        novaPartidaBtn = new JButton("Nova Partida");
        novaPartidaBtn.addActionListener(e -> {
            jogo.reiniciar();
            atualizarTela();
        });

        add(novaPartidaBtn, BorderLayout.SOUTH);
        setVisible(true);
    }

    private JPanel criaTabuleiro() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3,3));
        this.botoes = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton();
                int finalI = i;
                int finalJ = j;
                btn.addActionListener(e -> {
                    if (jogo.marcar(finalI, finalJ)) {
                        atualizarTela();
                        if (jogo.isJogoFinalizado()) {
                            if (jogo.getVencedor() == Simbolo.VAZIO) {
                                JOptionPane.showMessageDialog(this, "Empate");
                            } else {
                                JOptionPane.showMessageDialog(this,
                                        "Jogador " + jogo.getVencedor() + " venceu!");
                            }
                        }
                    }
                });
                botoes[i][j] = btn;
                painel.add(btn);
            }
        }
        return painel;
    }

    private void atualizarTela() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Simbolo s = jogo.getTabuleiro().getCasa(i, j);
                if (s == Simbolo.VAZIO) {
                    botoes[i][j].setText("");
                } else {
                    botoes[i][j].setText(s.toString());
                }
            }
        }

        jogador.setText("Jogador: " + jogo.getJogadorVez());
    }
}
