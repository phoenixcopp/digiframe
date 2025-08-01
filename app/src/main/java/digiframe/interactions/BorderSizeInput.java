package digiframe.interactions;

import digiframe.frames.Frame;
import javax.swing.JTextField;

public class BorderSizeInput extends JTextField {
    private final Frame frame;

    public BorderSizeInput(Frame frame) {
        super("3"); // Default border thickness
        this.frame = frame;
        setBounds(100, 180, 200, 40);
        setFocusable(true);
        
        // Add an action listener to handle border size changes
        addActionListener(e -> {
            try {
                int newThickness = Integer.parseInt(getText());
                if (newThickness >= 0 && newThickness <= 20) { // Validate thickness
                    frame.setBorderThickness(newThickness);
                } else {
                    setText("3"); // Reset to default if invalid input
                }
            } catch (NumberFormatException ex) {
                setText("3"); // Reset to default on error
            }
        });
    }
}
