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
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        setBorder(border);
    }

    public void updateColor(Color color) {
        setBackground(color);
        if (borderColorChooser != null) {
            borderColorChooser.setColor(color);
        }
    }
}
