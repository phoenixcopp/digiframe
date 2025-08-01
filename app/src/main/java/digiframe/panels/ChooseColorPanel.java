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
        setLayout(new FlowLayout());
        this.borderColorChooser = new BorderColorChooser(frame);
        add(borderColorChooser, BorderLayout.CENTER);
        // Add components for color selection here
        // For example, you can add a button to open a color chooser frame
        // and a preview panel to show the selected color.
    }
    
    // Additional methods to handle color selection can be added here
    
}
