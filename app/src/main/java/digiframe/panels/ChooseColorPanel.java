package digiframe.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import digiframe.frames.Frame;

import javax.swing.JPanel;

import digiframe.interactions.BorderColorChooser;

public class ChooseColorPanel extends JPanel {

    private final Frame frame;
    private final BorderColorChooser borderColorChooser;

    public ChooseColorPanel(Frame frame) {
        // Initialize the color chooser panel
        this.frame = frame;
        this.borderColorChooser = new BorderColorChooser(frame);
        setLayout(new FlowLayout());
        setOpaque(false);
        add(borderColorChooser, BorderLayout.CENTER);
    }
}
