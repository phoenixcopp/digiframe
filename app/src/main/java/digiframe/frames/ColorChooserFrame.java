package digiframe.frames;

import javax.swing.JFrame;
import digiframe.panels.ChooseColorPanel;

public class ColorChooserFrame extends JFrame {
    private final Frame frame;

    public ColorChooserFrame(Frame frame, ChooseColorPanel chooseColorPanel) {
        this.frame = frame;
        setTitle("Color Chooser");
        setSize(500, 270);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(194, 194, 194));
        add(chooseColorPanel);
    }

    public void showFrame() {
        setVisible(true);
    }
}
