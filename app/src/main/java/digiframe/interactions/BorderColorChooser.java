package digiframe.interactions;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import digiframe.frames.Frame;

public class BorderColorChooser extends JColorChooser {
    private final Frame frame;

    public BorderColorChooser(Frame frame) {
        super();
        this.frame = frame;
        getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color newColor = getColor();
                frame.setBorderColor(newColor);
            }
        });
    }

}
