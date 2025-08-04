package digiframe.frames;

import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

public class Frame extends JFrame {
    private ImageIcon imageIcon;
    private JLabel imageLabel;
    private String frameSize;
    private String aspectRatio;
    private Color borderColor;
    private int borderThickness;
    private Border border;
    private int mouseX;
    private int mouseY;

    public Frame() {
        // Initialize the frame
        setTitle("Picture Frame");
        frameSize = "Medium";
        aspectRatio = "3:2";
        borderColor = Color.WHITE;
        borderThickness = 3;
        setSize(600, 400);
        setUndecorated(true);
        setNewBorder(border);
        imageLabel = new JLabel();
        imageIcon = new ImageIcon(getClass().getResource("/default.png"));
        setImageForNewSize(imageIcon);
        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);

        // Make the frame draggable
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
            mouseX = e.getXOnScreen() - getX();
            mouseY = e.getYOnScreen() - getY();
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent e) {
                setLocation(e.getXOnScreen() - mouseX, e.getYOnScreen() - mouseY);
            }
        });
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
        setVisible(true);
    }

    public void close() {
        setVisible(false);
        dispose();
    }

    public void setAspectRatio(String aspectRatio) {
        switch (aspectRatio) {
            case "16:9":
            case "4:3":
            case "3:2":
            case "9:16":
            case "3:4":
            case "2:3":
                this.aspectRatio = aspectRatio;
                break;
            default:
                // Do not change aspectRatio if input is unrecognized
                return;
        }
        setFrameSize(frameSize, this.aspectRatio, imageIcon);
    }
    
    public void setSML(String size) {
        switch (size) {
            case "Small":
            case "Medium":
            case "Large":
                this.frameSize = size;
                break;
            default:
                // Do not change frameSize if input is unrecognized
                return;
        }
        setFrameSize(this.frameSize, aspectRatio, imageIcon);
    }

    public void setFrameSize(String size, String aspectRatio, ImageIcon icon) {
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

    public void setBorderColor(Color color) {
        this.borderColor = color;
        setNewBorder(border);
    }

    public void setBorderThickness(int thickness) {
        this.borderThickness = thickness;
        setNewBorder(border);
    }

    public void setNewBorder(Border border) {
        border = BorderFactory.createLineBorder(borderColor, borderThickness);
        ((JPanel) this.getContentPane()).setBorder(border);
        revalidate();
        repaint();
    }
}
