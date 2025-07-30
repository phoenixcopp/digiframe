package digiframe.panels;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import digiframe.buttons.ChoosePathButton;
import digiframe.buttons.FrameDisplayButton;

public class PathSetupPanel extends JPanel {

    public PathSetupPanel(ChoosePathButton choosePathButton) {
        setLayout(new FlowLayout());
        add(choosePathButton);
    }
    
}
