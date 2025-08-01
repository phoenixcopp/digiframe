package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import digiframe.interactions.FrameDisplayButton;

public class FrameDisplayPanel extends JPanel {

    public FrameDisplayPanel(FrameDisplayButton frameDisplayButton) {
        // Initialize the panel with the frame display button
        setLayout(new FlowLayout());
        add(frameDisplayButton);

        Border border = BorderFactory.createLineBorder(Color.RED, 2);
        setBorder(border);
    }
}
