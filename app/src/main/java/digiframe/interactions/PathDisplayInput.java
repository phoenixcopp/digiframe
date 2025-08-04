package digiframe.interactions;


import java.awt.Font;

import javax.swing.JTextField;

public class PathDisplayInput extends JTextField {
    private final ChoosePathButton choosePathButton;

    public PathDisplayInput(ChoosePathButton choosePathButton) {
        super("No path selected");
        this.choosePathButton = choosePathButton;
        setPreferredSize(new java.awt.Dimension(250, 35)); // width, height
        setEditable(false);
        setFocusable(true);
        setHorizontalAlignment(JTextField.CENTER);
        setBackground(new java.awt.Color(194, 194, 194)); 
        setFont(getFont().deriveFont(Font.BOLD, 14f)); // Set a larger font size
    }

    public void updatePath(String path) {
        if (path != null) {
            setText(path);
        } else {
            setText("No path selected");
        }
    }
}
