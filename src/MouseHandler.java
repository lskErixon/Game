import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
public class MouseHandler implements MouseListener {
    private final GamePanel source;

    public MouseHandler(GamePanel source) {
        this.source = source;
    }

    /**
     * Method that allows you to click
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int[] mousepos = new int[2];
        mousepos[0] = (e.getX()/(GamePanel.TILE_SIZE) - (GamePanel.ALIGNMENTX / GamePanel.TILE_SIZE));
        mousepos[1] = (e.getY()/GamePanel.TILE_SIZE - (GamePanel.ALIGNMENTY / GamePanel.TILE_SIZE));
        source.mouseClick(mousepos);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
