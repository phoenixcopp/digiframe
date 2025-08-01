package digiframe.frames;

import javax.swing.JFrame;

import digiframe.panels.ChooseColorPanel;

public class ColorChooserFrame extends JFrame {
    private final Frame frame;

    public ColorChooserFrame(Frame frame, ChooseColorPanel chooseColorPanel) {
        this.frame = frame;
        setTitle("Color Chooser");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(chooseColorPanel);
    }

    public void showFrame() {
        setVisible(true);
    }
    
}
