package digiframe.panels;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.frames.ColorChooserFrame;
import digiframe.frames.Frame;
import digiframe.interactions.BorderSizeInput;
import digiframe.interactions.ChooseColorButton;

public class BorderSetupPanel extends JPanel {

    public BorderSetupPanel(Frame frame) {

        setLayout(new FlowLayout());
        setOpaque(false);

        ColorPreviewPanel colorPreviewPanel = new ColorPreviewPanel(null);
        ChooseColorPanel chooseColorPanel = new ChooseColorPanel(frame, colorPreviewPanel);
        ColorChooserFrame colorChooserFrame = new ColorChooserFrame(frame, chooseColorPanel);

        add(new BorderSizeInput(frame));
        add(new ChooseColorButton(frame, colorChooserFrame));
        add(colorPreviewPanel);

        Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
        setBorder(border);
    }
    
}
