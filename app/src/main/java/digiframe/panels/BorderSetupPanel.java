package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.interactions.BorderSizeInput;
import digiframe.interactions.ChooseColorButton;

public class BorderSetupPanel extends JPanel {

    public BorderSetupPanel(BorderSizeInput borderSizeInput, 
                            ChooseColorButton ChooseColorButton) {
        // Initialize the border setup panel
        setLayout(new FlowLayout());
        setOpaque(false);
        add(borderSizeInput);
        add(ChooseColorButton);
        Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
        setBorder(border);
    }
    
}
