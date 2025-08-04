package digiframe.interactions;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import digiframe.frames.Frame;
import digiframe.panels.ColorPreviewPanel;

public class BorderColorChooser extends JColorChooser {
    private final Frame frame;
    ColorPreviewPanel colorPreviewPanel;

    public BorderColorChooser(Frame frame, ColorPreviewPanel colorPreviewPanel) {
        super();
        this.frame = frame;
        this.colorPreviewPanel = colorPreviewPanel;

        // Remove all chooser panels except "Swatches"
        for (var panel : getChooserPanels()) {
            if (!panel.getDisplayName().equals("Swatches")) {
                removeChooserPanel(panel);
            }
        }

        getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                Color newColor = getColor();
                frame.setBorderColor(newColor);
                if (colorPreviewPanel != null) {
                    colorPreviewPanel.updateColor(newColor);
                }
            }
        });
    }

}
