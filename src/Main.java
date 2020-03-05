import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        State state = new State();
        Display display = new Display(state);
        MouseListener allEars = new MouseListener(state, display);
        JFrame frame = setupJFrame(allEars);
        frame.getContentPane().add(display);
        frame.setVisible(true);
    }

    private static JFrame setupJFrame(MouseAdapter allEars) {
        JFrame frame = new JFrame("Datablock Test");
        frame.getContentPane().addMouseListener(allEars);
        frame.getContentPane().addMouseMotionListener(allEars);
        frame.setSize(400, 400);
        return frame;
    }
}
