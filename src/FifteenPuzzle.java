import java.util.Random;
public class FifteenPuzzle {
    private int[][] board;
    private int emptyRow;
    private int emptyCol;

    public FifteenPuzzle() {
        initializeBoard();
        shuffleBoard();
    }

    public int[][] getBoard() {
        return board;
    }

    /**
     * Method for initialize board
     */
    private void initializeBoard() {
        board = new int[4][4];
        int value = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = value;
                value++;
            }
        }
        emptyRow = 3;
        emptyCol = 3;
        board[emptyRow][emptyCol] = 0;
    }

    /**
     * Mathod that genarates random numbers and shuffles tham on the board
     */
    private void shuffleBoard() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int direction = random.nextInt(4);
            moveTile(direction);
        }
    }

    /**
     * Method that gives you true or false deppending on if the board is sorted
     * @param key_Board
     * @return
     */
    public boolean isSorted(int[][] key_Board) {
        for (int i = 0; i < key_Board.length; i++) {
            for (int j = 1; j < key_Board[i].length; j++) {
                if (key_Board[i][j] < key_Board[i][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Method that finds index of 0 and lets you swap the square next to it
     * @param direction
     */
    public void moveTile(int direction) {
        int newRow = emptyRow;
        int newCol = emptyCol;

        switch (direction) {
            case 0:  // Up
                newRow = Math.min(emptyRow + 1, 3);
                break;
            case 1:  // Left
                newCol = Math.min(emptyCol + 1, 3);
                break;
            case 2:  // Down
                newRow = Math.max(emptyRow - 1, 0);
                break;
            case 3:  // Right
                newCol = Math.max(emptyCol - 1, 0);
                break;
        }

        if ((newRow != emptyRow || newCol != emptyCol)) {
            board[emptyRow][emptyCol] = board[newRow][newCol];
            board[newRow][newCol] = 0;
            emptyRow = newRow;
            emptyCol = newCol;
        }
    }

    /**
     * Method that checks if the space where you want to place the square is valid
     * @param input
     */
    public void swapTile(int[] input) {
        if(emptyCol + 1 == input[0] && input[1] == emptyRow){
            moveTile(1);
        }
        if(emptyCol - 1 == input[0] && input[1] == emptyRow){
            moveTile(3);
        }
        if(emptyRow + 1 == input[1] && input[0] == emptyCol){
            moveTile(0);
        }
        if(emptyRow - 1 == input[1] && input[0] == emptyCol){
            moveTile(2);
        }
    }
}

