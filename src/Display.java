import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
    private final State state;

    Display(State state) {
        this.state = state;
        this.setSize(400, 400);
        this.setBackground(Color.black);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        state.datablock.paint(g);
        displayCoordinates(g, state.pointDisplay);
        //centeredDot(g, state.dataPoint);
        state.datablock.line(g, state.dataPoint);
    }

    private static void centeredDot(Graphics g, Point point) {
        g.setColor(Color.blue);
        g.fillOval(point.x-5, point.y-5, 10,10);
        g.setColor(Color.red);
        g.fillOval(point.x-1, point.y-1, 3,3);
    }
    private static void displayCoordinates(Graphics g, Point point) {
        String coordinateString = String.format("%s %s", point.getX(), point.getY());
        g.drawString(coordinateString,100, 100);
    }
}
