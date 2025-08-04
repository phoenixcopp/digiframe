package digiframe.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.border.Border;
import digiframe.frames.Frame;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

public class FrameSetupContainer extends JPanel {
    boolean frameExists = false;
    private Image backgroundImage;

    public FrameSetupContainer() {
        // Initialize the frame object
        Frame frame = new Frame();


        // Initialize the container for frame setup components
        setSize(475, 700);
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/setup-container-background.jpg"));
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Could not load setup-container-background.png: " + e.getMessage());
        }
        setOpaque(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3, true);
        setBorder(border);
        setLayout(new GridBagLayout());

        // Bottom panel (20%)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setOpaque(false);
        bottomPanel.setLayout(new GridBagLayout()); // Explicitly center contents
            // Add/close frame button and position
        FrameDisplayPanel frameDisplayPanel = new FrameDisplayPanel(frame);
        GridBagConstraints gbcBottom = new GridBagConstraints();
        gbcBottom.gridx = 0;
        gbcBottom.gridy = 0;
        gbcBottom.weightx = 1.0;
        gbcBottom.weighty = 1.0;
        gbcBottom.anchor = GridBagConstraints.CENTER;
        gbcBottom.fill = GridBagConstraints.NONE;
        bottomPanel.add(frameDisplayPanel, gbcBottom);

        // Top panel (80%)
        JPanel topPanel = new JPanel();
        topPanel.setOpaque(false);
        topPanel.setLayout(new GridLayout(3, 1)); // 2x2 grid for components
        topPanel.add(new PathSetupPanel(frame));
        topPanel.add(new AspectRationSetupPanel(frame));
            // Border setup
        BorderSetupPanel borderSetupPanel = new BorderSetupPanel(frame);
        topPanel.add(borderSetupPanel);
        
        // Set layout for the container
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        // Top panel (80%)
        gbc.gridy = 0;
        gbc.weighty = 0.90;
        add(topPanel, gbc);
        // Bottom panel (20%)
        gbc.gridy = 1;
        gbc.weighty = 0.1;
        add(bottomPanel, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
