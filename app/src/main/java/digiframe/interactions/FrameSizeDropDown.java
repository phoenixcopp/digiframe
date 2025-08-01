package digiframe.interactions;

import javax.swing.JComboBox;
import digiframe.frames.Frame;

public class FrameSizeDropDown extends JComboBox<String> {
    private final Frame frame;

    public FrameSizeDropDown(Frame frame) {
        super(new String[]{"Small", "Medium", "Large"});
        this.frame = frame;
        setBounds(100, 200, 200, 40);
        setFocusable(false);
        setSelectedItem("Medium"); // Default selection to Medium
        
        // Add an action listener to handle size changes
        addActionListener(e -> {
            String selectedSize = (String) getSelectedItem();
            if (selectedSize != null) {
                frame.setSML(selectedSize);
            }
        });
    }
    
}
