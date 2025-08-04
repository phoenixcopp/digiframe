package digiframe.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import digiframe.frames.Frame;
import digiframe.interactions.BorderColorChooser;

public class ChooseColorPanel extends JPanel {

    private final ColorPreviewPanel colorPreviewPanel;

    public ChooseColorPanel(Frame frame, ColorPreviewPanel colorPreviewPanel) {
        this.colorPreviewPanel = colorPreviewPanel;
        setLayout(new FlowLayout());
        setOpaque(false);
        BorderColorChooser borderColorChooser = new BorderColorChooser(frame, colorPreviewPanel);
        add(borderColorChooser, BorderLayout.CENTER);
    }

    public ColorPreviewPanel getColorPreviewPanel() {
        return colorPreviewPanel;
    }
}
