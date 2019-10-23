import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private final State state;
    private final Display display;

    public MouseListener(State state, Display display) {
        this.state = state;
        this.display = display;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        state.update(e);
        display.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        state.update(e);
        display.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
        state.updatePointDisplay(e);
        display.repaint();
    }
}
