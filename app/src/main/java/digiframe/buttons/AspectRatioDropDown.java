package digiframe.buttons;

import javax.swing.JComboBox;
import digiframe.frames.Frame;

public class AspectRatioDropDown extends JComboBox<String> {
    private final Frame frame;

    public AspectRatioDropDown(Frame frame) {
        super(new String[]{"16:9", "4:3", "3:2", "9:16", "3:4", "2:3"});
        this.frame = frame;
        setBounds(100, 120, 200, 40);
        setFocusable(false);
        
        // Add an action listener to handle aspect ratio changes
        addActionListener(e -> {
            String selectedRatio = (String) getSelectedItem();
            if (selectedRatio != null) {
                frame.setAspectRatio(selectedRatio);
            }
        });
    }
}
