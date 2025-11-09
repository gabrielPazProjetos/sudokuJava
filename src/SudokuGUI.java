import javax.swing.*;
import java.awt.*;

public class SudokuGUI {
    private final SudokuGame jogo;
    private final JTextField[][] cells = new JTextField[9][9];
    private final JLabel statusLabel = new JLabel("Status: Não iniciado");

    public SudokuGUI(SudokuGame jogo) {
        this.jogo = jogo;
        criarInterface();
    }

    private void criarInterface() {
        JFrame frame = new JFrame("Sudoku");
        frame.setSize(600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(9, 9));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new JTextField();
                cells[i][j].setHorizontalAlignment(JTextField.CENTER);
                cells[i][j].setFont(new Font("Arial", Font.BOLD, 20));
                cells[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                gridPanel.add(cells[i][j]);
            }
        }

        JPanel buttonPanel = new JPanel();
        JButton iniciar = new JButton("Iniciar");
        JButton limpar = new JButton("Limpar");
        JButton verificar = new JButton("Verificar");
        JButton finalizar = new JButton("Finalizar");

        iniciar.addActionListener(e -> {
            jogo.iniciarJogo();
            atualizarTabuleiro();
            statusLabel.setText("Status: Jogo iniciado");
        });

        limpar.addActionListener(e -> {
            jogo.limparJogo();
            atualizarTabuleiro();
            statusLabel.setText("Status: Jogo limpo");
        });

        verificar.addActionListener(e -> {
            lerTabuleiro();
            String status = jogo.verificarStatus();
            statusLabel.setText("Status: " + status);
        });

        finalizar.addActionListener(e -> {
            lerTabuleiro();
            boolean completo = jogo.finalizarJogo();
            statusLabel.setText(completo ? "Parabéns! Jogo completo!" : "Jogo incompleto ou inválido.");
        });

        buttonPanel.add(iniciar);
        buttonPanel.add(limpar);
        buttonPanel.add(verificar);
        buttonPanel.add(finalizar);

        frame.add(gridPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(statusLabel, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private void atualizarTabuleiro() {
        int[][] board = jogo.getBoard();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                cells[i][j].setText(num == 0 ? "" : String.valueOf(num));
                cells[i][j].setEditable(!jogo.isFixed(i, j));
                cells[i][j].setBackground(jogo.isFixed(i, j) ? Color.LIGHT_GRAY : Color.WHITE);
            }
        }
    }

    private void lerTabuleiro() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = cells[i][j].getText().trim();
                int num = text.isEmpty() ? 0 : Integer.parseInt(text);
                jogo.colocarNumero(i, j, num);
            }
        }
    }
}
