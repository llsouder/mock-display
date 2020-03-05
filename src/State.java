
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


class State {
    Datablock datablock = new Datablock("Testing 123 Super", 200, 100);
    Point pointDisplay = new Point(0, 0);
    Point dataPoint = new Point(234, 123);
    List<Icon> icons = Arrays.asList(
            Icon.makeIcon(Color.blue),
            Icon.makeIcon(Color.red),
            Icon.makeIcon(Color.green),
            Icon.makeIcon(Color.blue),
            Icon.makeIcon(Color.red),
            Icon.makeIcon(Color.green),
            Icon.makeIcon(Color.yellow),
            Icon.makeIcon(Color.black),
            Icon.makeIcon(Color.yellow),
            Icon.makeIcon(Color.blue),
            Icon.makeIcon(Color.red),
            Icon.makeIcon(Color.green),
            Icon.makeIcon(Color.blue),
            Icon.makeIcon(Color.red),
            Icon.makeIcon(Color.green),
            Icon.makeIcon(Color.yellow),
            Icon.makeIcon(Color.black),
            Icon.makeIcon(Color.yellow),
            Icon.makeIcon(Color.pink),
            Icon.makeIcon(Color.red),
            Icon.makeIcon(Color.green),
            Icon.makeIcon(Color.blue));

    State() throws IOException {
    }

    void update(MouseEvent e) {
        datablock = datablock.move(e.getX(), e.getY());
        pointDisplay = e.getPoint();
    }

    void updatePointDisplay(MouseEvent e) {
        pointDisplay = e.getPoint();
    }
}
