package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import digiframe.interactions.AspectRatioDropDown;
import digiframe.interactions.FrameSizeDropDown;

public class AspectRationSetupPanel extends JPanel {

    public AspectRationSetupPanel(AspectRatioDropDown aspectRatioDropDown, FrameSizeDropDown frameSizeDropDown) {
        setLayout(new FlowLayout());
        setOpaque(false);
        add(aspectRatioDropDown);
        add(frameSizeDropDown);
        Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
        setBorder(border);
    }
}    
