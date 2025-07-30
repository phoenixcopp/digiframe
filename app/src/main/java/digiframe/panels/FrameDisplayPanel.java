package digiframe.panels;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import digiframe.buttons.FrameDisplayButton;

public class FrameDisplayPanel extends JPanel {

    public FrameDisplayPanel(FrameDisplayButton frameDisplayButton) {
        // Initialize the panel with the frame display button
        setLayout(new FlowLayout());
        add(frameDisplayButton);
    }
}
