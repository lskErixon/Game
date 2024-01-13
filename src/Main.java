public class Main {

    public static void main(String[] args) {
        FifteenPuzzle fifteenPuzzle = new FifteenPuzzle();
        GamePanel gamePanel = new GamePanel(fifteenPuzzle);
        new Frame(gamePanel);
    }
}