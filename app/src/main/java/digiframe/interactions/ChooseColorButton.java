package digiframe.interactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import digiframe.frames.ColorChooserFrame;
import digiframe.frames.Frame;

public class ChooseColorButton extends JButton implements ActionListener {
    private final Frame frame;
    private final ColorChooserFrame colorChooserFrame;

    public ChooseColorButton(Frame frame, ColorChooserFrame colorChooserFrame) {
        super("Choose Color");
        this.frame = frame;
        this.colorChooserFrame = colorChooserFrame;
        setBounds(100, 120, 200, 40);
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        colorChooserFrame.showFrame();
    }
}
