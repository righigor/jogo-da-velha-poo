package br.com.igor.jogoDaVelha;

import br.com.igor.jogoDaVelha.view.TelaPrincipal;

import javax.swing.*;

public class Main {
    static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaPrincipal();
        });
    }
}
