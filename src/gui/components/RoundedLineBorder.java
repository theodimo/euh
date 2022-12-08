package gui.components;

import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import java.awt.*;

/** This class extends AbstractBorder and implements Border
 * and provides the ability to make rounded line borders
 * which normally java has a problem with. The link to
 * the original code is given below
 * <a href="https://stackoverflow.com/questions/52759203/rounded-lineborder-not-all-corners-are-rounded">...</a>
 *
 * @author tzikaman
 */

public class RoundedLineBorder extends AbstractBorder implements Border {
    int lineSize, cornerSize;
    Paint fill;
    Stroke stroke;
    private Object aaHint;

    public RoundedLineBorder(Paint fill, int lineSize, int cornerSize) {
        this.fill = fill;
        this.lineSize = lineSize;
        this.cornerSize = cornerSize;
        stroke = new BasicStroke(lineSize);
    }
    public RoundedLineBorder(Paint fill, int lineSize, int cornerSize, boolean antiAlias) {
        this.fill = fill;
        this.lineSize = lineSize;
        this.cornerSize = cornerSize;
        stroke = new BasicStroke(lineSize);
        aaHint = antiAlias? RenderingHints.VALUE_ANTIALIAS_ON: RenderingHints.VALUE_ANTIALIAS_OFF;
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        return new Insets(0,10,0,10);
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D)g;
        Paint oldPaint = g2d.getPaint();
        Stroke oldStroke = g2d.getStroke();
        Object oldAA = g2d.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
        try {
            g2d.setPaint(fill!=null? fill: c.getForeground());
            g2d.setStroke(stroke);
            if(aaHint != null) g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, aaHint);
            int off = lineSize >> 1;
            g2d.drawRoundRect(x+off, y+off, width-lineSize, height-lineSize, cornerSize, cornerSize);
        }
        finally {
            g2d.setPaint(oldPaint);
            g2d.setStroke(oldStroke);
            if(aaHint != null) g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, oldAA);
        }
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}