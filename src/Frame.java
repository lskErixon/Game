import javax.swing.*;
public class Frame extends JFrame {
    /**
     * Sets up a frame
     * @param gamePanel
     */
    public Frame(GamePanel gamePanel){
        setVisible(true);
        add(gamePanel);
        setSize(500,500);
        setResizable(false);
    }
}
