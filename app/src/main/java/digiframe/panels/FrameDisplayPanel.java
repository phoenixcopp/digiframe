package digiframe.panels;

import java.awt.FlowLayout;
import javax.swing.JPanel;

import digiframe.frames.Frame;
import digiframe.interactions.FrameDisplayButton;

public class FrameDisplayPanel extends JPanel {

    public FrameDisplayPanel(Frame frame) {
        // Initialize the panel with the frame display button
        setLayout(new FlowLayout());
        setOpaque(false);
        add(new FrameDisplayButton(frame));
    }
}
