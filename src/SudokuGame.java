import java.util.*;

public class SudokuGame {
    private int[][] board = new int[9][9];
    private int[][] fixedBoard = new int[9][9];
    private boolean started = false;

    public void iniciarJogo() {
        board = new int[9][9];
        gerarTabuleiro(board);
        copiarTabuleiro(board, fixedBoard);
        removerNumeros(board, 40);
        started = true;
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isFixed(int row, int col) {
        return fixedBoard[row][col] != 0;
    }

    public void colocarNumero(int row, int col, int num) {
        if (!isFixed(row, col)) board[row][col] = num;
    }

    public void removerNumero(int row, int col) {
        if (!isFixed(row, col)) board[row][col] = 0;
    }

    public void limparJogo() {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (!isFixed(i, j)) board[i][j] = 0;
    }

    public String verificarStatus() {
        if (!started) return "Não iniciado";
        for (int[] linha : board)
            for (int celula : linha)
                if (celula == 0) return "Incompleto";
        return "Completo";
    }

    public boolean finalizarJogo() {
        if (!started) return false;
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (board[i][j] == 0 || !isValid(i, j, board[i][j])) return false;
        return true;
    }

    private boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) return false;
            if (i != row && board[i][col] == num) return false;
        }
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if ((i != row || j != col) && board[i][j] == num) return false;
        return true;
    }

    private boolean gerarTabuleiro(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    List<Integer> numeros = new ArrayList<>();
                    for (int i = 1; i <= 9; i++) numeros.add(i);
                    Collections.shuffle(numeros);
                    for (int num : numeros) {
                        board[row][col] = num;
                        if (isValid(row, col, num) && gerarTabuleiro(board)) return true;
                        board[row][col] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private void removerNumeros(int[][] board, int quantidade) {
        Random rand = new Random();
        int removidos = 0;
        while (removidos < quantidade) {
            int row = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                removidos++;
            }
        }
    }

    private void copiarTabuleiro(int[][] origem, int[][] destino) {
        for (int i = 0; i < 9; i++)
            System.arraycopy(origem[i], 0, destino[i], 0, 9);
    }
}
