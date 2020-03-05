import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Icon {
    private final static BufferedImage IMAGE = read();
    private static BufferedImage read() {
        try {
            return ImageIO.read(ClassLoader.getSystemResource("image/eye.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private final static Map<Color, Icon> POOL = new HashMap<>();
    public static Icon makeIcon(Color color) {
        Icon icon = POOL.get(color);
        if (icon == null) {
            icon = new Icon(color);
            POOL.put(color, icon);
        }
        System.out.println(String.format("Returning %s  size of pool is %s", color, POOL.size()));
        return icon;
    }

    BufferedImage image;

    private Icon(Color color) {
        image = deepCopy(IMAGE);
        Graphics2D g2d = image.createGraphics();
        g2d.setXORMode(color);
        g2d.drawImage(image, 0, 0, null); // NOT 'tintedImage'
        g2d.dispose();
    }
    static int x = 10;
    public void paint(Graphics g, JPanel panel) {
        g.drawString("Testing", 20,20);
        g.drawImage(image, x, x, panel);
        x = x+ 5;
    }

    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
