package digiframe.interactions;

import digiframe.frames.Frame;
import javax.swing.JTextField;

public class BorderSizeInput extends JTextField {
    private final Frame frame;

    public BorderSizeInput(Frame frame) {
        super("3"); 
        this.frame = frame;
        setBounds(100, 180, 200, 40);
        setFocusable(true);
        
        addActionListener(e -> {
            try {
                int newThickness = Integer.parseInt(getText());
                if (newThickness >= 0 && newThickness <= 20) { 
                    frame.setBorderThickness(newThickness);
                } else {
                    setText("3"); 
                }
            } catch (NumberFormatException ex) {
                setText("3"); 
            }
        });
    }
}
