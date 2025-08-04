package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import digiframe.frames.Frame;
import digiframe.interactions.AspectRatioDropDown;
import digiframe.interactions.FrameSizeDropDown;

public class AspectRationSetupPanel extends JPanel {

    public AspectRationSetupPanel(Frame frame) {
        setLayout(new FlowLayout());
        setOpaque(false);
        add(new AspectRatioDropDown(frame));
        add(new FrameSizeDropDown(frame));
        Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
        setBorder(border);
    }
}    
