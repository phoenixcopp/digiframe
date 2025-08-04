package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import digiframe.frames.ColorChooserFrame;
import digiframe.frames.Frame;
import digiframe.interactions.BorderSizeInput;
import digiframe.interactions.ChooseColorButton;

public class BorderSetupPanel extends JPanel {

    public BorderSetupPanel(Frame frame) {
        // Initialize the border setup panel
        setLayout(new FlowLayout());
        setOpaque(false);
        add(new BorderSizeInput(frame));
        add(new ChooseColorButton(frame, new ColorChooserFrame(frame, new ChooseColorPanel(frame))));
        Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
        setBorder(border);
    }
    
}
