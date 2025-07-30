package digiframe.frames;

import javax.swing.border.Border;
import digiframe.buttons.ChoosePathButton;
import digiframe.buttons.FrameDisplayButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private ImageIcon originalIcon;
    private JLabel imageLabel;

    public Frame() {
        // Initialize the frame
        setTitle("Picture Frame");
        setSize(990,540);
        setUndecorated(false);
        Border border = BorderFactory.createLineBorder(Color.RED, 3);
        ((JPanel) this.getContentPane()).setBorder(border);
        originalIcon = new ImageIcon(getClass().getResource("/default.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(
            getWidth(), getHeight(), Image.SCALE_SMOOTH
        );
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel = new JLabel(scaledIcon);
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
    }   

    public void setImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image scaledImage = icon.getImage().getScaledInstance(
        getWidth(), getHeight(), Image.SCALE_SMOOTH
        );
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledIcon);
        revalidate();
        repaint();
    }

    public void display() {
        // Logic to display the frame
        setVisible(true);
    }

    public void close() {
        // Logic to close the frame
        setVisible(false);
        dispose();
    }

    public FrameDisplayButton getFrameDisplayButton() {
        return new FrameDisplayButton(this);
    }

    public ChoosePathButton getChoosePathButton() {
        return new ChoosePathButton(this);
    }
}
