package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.interactions.ChoosePathButton;

public class PathSetupPanel extends JPanel {

    public PathSetupPanel(ChoosePathButton choosePathButton) {
        setLayout(new FlowLayout());
        setOpaque(false)   ;
        add(choosePathButton);
        Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
        setBorder(border);
    }
}
