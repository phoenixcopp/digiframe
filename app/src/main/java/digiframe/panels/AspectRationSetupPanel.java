package digiframe.panels;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import digiframe.buttons.AspectRatioDropDown;
import digiframe.buttons.FrameSizeDropDown;

public class AspectRationSetupPanel extends JPanel {

    public AspectRationSetupPanel(AspectRatioDropDown aspectRatioDropDown, 
        FrameSizeDropDown frameSizeDropDown) {


        // Initialize the aspect ratio setup panel
        setLayout(new FlowLayout());
        add(aspectRatioDropDown);
        add(frameSizeDropDown);
        // Add components for aspect ratio setup here
        // For example, you can add JComboBox for selecting aspect ratios
        // JComboBox<String> aspectRatioComboBox = new JComboBox<>(new String[]{"16:9", "4:3", "1:1"});
        // add(aspectRatioComboBox);
    }
    
}
