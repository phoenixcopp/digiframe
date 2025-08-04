package digiframe.panels;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.interactions.BorderColorChooser;

public class ColorPreviewPanel extends JPanel  {
    private final BorderColorChooser borderColorChooser;

    public ColorPreviewPanel(BorderColorChooser borderColorChooser) {
        this.borderColorChooser = borderColorChooser;
        setOpaque(true);
        setPreferredSize(new Dimension(30, 30));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    }

    public void updateColor(Color color) {
        setBackground(color);
        if (borderColorChooser != null) {
            borderColorChooser.setColor(color);
        }   
    }

    private static boolean isDark(Color color) {
        double grayBrightness = 0.299 * 128 + 0.587 * 128 + 0.114 * 128;
        double colorBrightness = 0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue();
        return colorBrightness < grayBrightness;
    }

    public void updateBorderColor(Color color) {
        if (isDark(color)) {
            setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        } else {
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        }
    }
}
