import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static final int TILE_SIZE = 50;
    public static final int ALIGNMENTX = 150;
    public static final int ALIGNMENTY = 50;

    private FifteenPuzzle fifteenPuzzle;
    private MouseHandler mouseHandler = new MouseHandler(this);

    private int[] clickPos = new int[2];

    /**
     * Sets up the background
     * @param fifteenPuzzle
     */
    public GamePanel(FifteenPuzzle fifteenPuzzle){
        this.fifteenPuzzle = fifteenPuzzle;
        addMouseListener(mouseHandler);
        setBackground(Color.white);
        repaint();
    }

    /**
     * Method that lets you swap tiles with a click
     * @param pos
     */
    public void mouseClick(int[] pos){
        clickPos = pos;
        fifteenPuzzle.swapTile(pos);
        repaint();
    }

    /**
     * Graphics for the game(Numbers, colors, board, text)
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int[][] board = fifteenPuzzle.getBoard();

        if(fifteenPuzzle.isSorted(board)){
            g2.drawString("YOU WON!",200,20);
            System.exit(0);
        }
        else{
            g2.drawString("KEEP PLAYING",200,20);

        }
        g2.setColor(Color.GRAY);
        g2.fillRect(clickPos[0] * TILE_SIZE + ALIGNMENTX,clickPos[1] * TILE_SIZE + ALIGNMENTY,TILE_SIZE,TILE_SIZE);

        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board[x].length; y++){
                g2.setColor(Color.BLACK);
                g2.drawString((board[y][x]!=0)? String.valueOf(board[y][x]) : "",TILE_SIZE * x + ALIGNMENTX + TILE_SIZE/2,
                        TILE_SIZE * y + ALIGNMENTY + TILE_SIZE/2);
                g2.setColor(Color.GRAY);
                g2.drawRect(TILE_SIZE * x + ALIGNMENTX,TILE_SIZE * y + ALIGNMENTY,TILE_SIZE,TILE_SIZE);
            }
        }
    }
}
