import java.awt.*;

class Datablock {

    private final String text;
    private final int x;
    private final int y;

    Datablock(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    Datablock move(int x, int y) {
        return new Datablock(this.text, x, y);
    }

    void paint(Graphics g) {
        g.setColor(Color.red);
        g.setColor(Color.green);
        Dimension bounds = bounds(g, text);
        int halfTextWidth =  bounds.width / 2;
        int halfTextHeight = bounds.height/2;
        g.drawString(text, x-halfTextWidth, y+halfTextHeight);
        g.setColor(Color.yellow.darker());
        g.drawRect(this.x -halfTextWidth, y-halfTextHeight, bounds.width, bounds.height);
    }
    private Dimension bounds(Graphics graphics, String text) {
        // get metrics from the graphics
        Font font = graphics.getFont();
        FontMetrics metrics = graphics.getFontMetrics(font);
        // get the height of a line of text in this
        // font and render context
        int hgt = metrics.getHeight();
        // get the advance of my text in this font
        // and render context
        int adv = metrics.stringWidth(text);
        // calculate the size of a box to hold the
        // text with some padding.
        return new Dimension(adv, hgt);
    }

    public void line(Graphics g, Point otherPoint) {
        //https://stackoverflow.com/questions/1585525/how-to-find-the-intersection-point-between-a-line-and-a-rectangle
        //find the slope
        int m = (otherPoint.x-x)==0?1:(otherPoint.y-y)/(otherPoint.x-x);
        System.out.println(String.format("%s %s", m, (otherPoint.x-x)));
        Dimension bounds = bounds(g, text);
        int h = bounds.height;
        int w = bounds.width;
        Point textBoxConnectionPoint;
        if(((-1*h)/2 <= m * (w/2)) && (m * (w/2) <= h/2)) {
            if(otherPoint.x > x){
                //right edge
                textBoxConnectionPoint = new Point(x + w/2, y + m*w/2);
            } else {
                textBoxConnectionPoint = new Point(x - w/2, y + m*w/2);
            }
        } else {
            if(otherPoint.y > y) {
                //top edge
                textBoxConnectionPoint = new Point(x + h/2/m, y + h/2);
            } else {
                //bottom edge
                textBoxConnectionPoint = new Point(x + h/2/m, y - h/2);
            }
        }
        g.drawLine(textBoxConnectionPoint.x, textBoxConnectionPoint.y, otherPoint.x, otherPoint.y);
    }
}
