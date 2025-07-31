package digiframe.frames;

import javax.swing.border.Border;

import digiframe.buttons.AspectRatioDropDown;
import digiframe.buttons.ChoosePathButton;
import digiframe.buttons.FrameDisplayButton;
import digiframe.buttons.FrameSizeDropDown;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Lets right a function that will resize the image to fit the frame
// We will need to do this frequently when the frame is resized or when a new image is set

public class Frame extends JFrame {
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    String frameSize;
    String aspectRatio;

    public Frame() {
        // Initialize the frame
        setTitle("Picture Frame");
        frameSize = "Medium";
        aspectRatio = "3:2";
        setSize(600, 400); // Default size
        setUndecorated(false);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
        ((JPanel) this.getContentPane()).setBorder(border);
        imageLabel = new JLabel();
        imageIcon = new ImageIcon(getClass().getResource("/default.png"));
        setImageForNewSize(imageIcon);
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
    }   

    public void setImageForNewPhoto(String path) {
        imageIcon = new ImageIcon(path);
        setImageForNewSize(imageIcon);
    }

    public void setImageForNewSize(ImageIcon icon) {
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

    public AspectRatioDropDown getAspectRatioDropDown() {
        return new AspectRatioDropDown(this);
    }

    public FrameSizeDropDown getFrameSizeDropDown() {
        return new FrameSizeDropDown(this);
    }

    public void setAspectRatio(String aspectRatio) {
        // Logic to set the aspect ratio of the frame
        // This could involve resizing the frame or changing the layout
        switch (aspectRatio) {
            case "16:9":
                aspectRatio = "16:9";
                break;
            case "4:3":
                aspectRatio = "4:3";
                break;
            case "3:2":
                aspectRatio = "3:2";
                break;
            case "9:16":
                aspectRatio = "9:16";
                break;
            case "3:4": 
                aspectRatio = "3:4";
                break;
            case "2:3":
                aspectRatio = "2:3";
                break;
            default:
                // Default size or handle other cases
                aspectRatio = "3:2";
        }
        setFrameSize(frameSize, aspectRatio, imageIcon);
    }
    
    public void setSML(String size) {
        // Logic to set the frame size based on the selected size
        switch (size) {
            case "Small":
                frameSize = "Small";
                break;
            case "Medium":
                frameSize = "Medium";
                break;
            case "Large":
                frameSize = "Large";
                break;
            default:
                // Default size or handle other cases
                frameSize = "Medium";
        }
        setFrameSize(frameSize, aspectRatio, imageIcon);
    }

    public void setFrameSize(String size, String aspectRatio, ImageIcon icon) {
        // Logic to set the frame size based on the selected size
        switch (size) {
            case "Small":
                switch (aspectRatio) {
                    case "16:9":
                        setSize(400, 225);
                        break;
                    case "4:3":
                        setSize(400, 300);
                        break;
                    case "3:2":
                        setSize(400, 267);
                        break;
                    case "9:16":
                        setSize(225, 400);
                        break;
                    case "3:4": 
                        setSize(300, 400);
                        break;
                    case "2:3":
                        setSize(267, 400);
                        break;
                    default:
                        setSize(400, 267);
                }
                break;

            case "Medium":
                switch (aspectRatio) {
                    case "16:9":
                        setSize(600, 338);
                        break;
                    case "4:3":
                        setSize(600, 450);
                        break;
                    case "3:2":
                        setSize(600, 400);
                        break;
                    case "9:16":
                        setSize(338, 600);
                        break;
                    case "3:4": 
                        setSize(450, 600);
                        break;
                    case "2:3":
                        setSize(400, 600);
                        break;
                    default:
                        setSize(600, 400);
                }
                break;

            case "Large":
                switch (aspectRatio) {
                    case "16:9":
                        setSize(800, 450);
                        break;
                    case "4:3":
                        setSize(800, 600);
                        break;
                    case "3:2":
                        setSize(800, 533);
                        break;
                    case "9:16":
                        setSize(450, 800);
                        break;
                    case "3:4": 
                        setSize(600, 800);
                        break;
                    case "2:3":
                        setSize(533, 800);
                        break;
                    default:
                        setSize(800, 533);
                }
                break;
            default:
                // Default size or handle other cases
                setSize(600, 400);
        }
        setImageForNewSize(icon);
    }
}
