import java.awt.*;
import java.awt.event.MouseEvent;

class State {
    Datablock datablock = new Datablock("Testing 123 Super", 200, 100);
    Point pointDisplay = new Point(0,0);
    Point dataPoint = new Point(234, 123);

    void update(MouseEvent e) {
        datablock = datablock.move(e.getX(), e.getY());
        pointDisplay = e.getPoint();
    }

    void updatePointDisplay(MouseEvent e) {
        pointDisplay = e.getPoint();
    }
}
