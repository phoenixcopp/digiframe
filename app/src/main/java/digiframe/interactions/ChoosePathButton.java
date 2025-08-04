package digiframe.interactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.JButton;
import digiframe.frames.Frame;

public class ChoosePathButton extends JButton implements ActionListener {
    private final Frame frame;
    PathDisplayInput pathDisplayInput;    
    private java.util.List<File> fileList = null;
    private int currentIndex = 0;
    Timer slideshowTimer = null;
    int delay = 3000;

    public ChoosePathButton(Frame frame, PathDisplayInput pathDisplayInput) {
        super("Choose Path");
        this.frame = frame;
        this.pathDisplayInput = pathDisplayInput;
        setBounds(100, 160, 200, 40);
        setFocusable(false);
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPath = getPath();
        if (selectedPath != null) {
            pathDisplayInput.updatePath(selectedPath);
            File selectedFile = new File(selectedPath);
            // Single photo
            if (selectedFile.isFile()) {
                // Stop any running slideshow if one is running
                stopSlideshow();
                frame.setImageForNewPhoto(selectedPath);

            // Directory of photos    
            } else if (selectedFile.isDirectory()) {
                // Colloect all image files in the directory
                File[] files = selectedFile.listFiles((dir, name) -> {
                    String lower = name.toLowerCase();
                    return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") || lower.endsWith(".gif") || lower.endsWith(".bmp");
                });
                // Shuffle the list of files
                if (files != null && files.length > 0) {
                    fileList = java.util.Arrays.asList(files);
                    java.util.Collections.shuffle(fileList);
                    currentIndex = 0;
                    frame.setImageForNewPhoto(fileList.get(currentIndex).getAbsolutePath());
                    startSlideshow();
                } else {
                    System.out.println("No image files found in directory.");
                }
            }
        }
    }

    public String getPath() {
        String filepath = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filepath = selectedFile.getAbsolutePath();
        } else {
            System.out.println("No file selected");
        }

        return filepath;
    }

    public void startSlideshow() {
    stopSlideshow(); // Stop any existing timer
    slideshowTimer = new javax.swing.Timer(delay, evt -> showNextImage()); // delay is in milliseconds
    slideshowTimer.start();
    }

    private void stopSlideshow() {
        if (slideshowTimer != null) {
            slideshowTimer.stop();
            slideshowTimer = null;
        }
    }

    private void showNextImage() {
        if (fileList != null && !fileList.isEmpty()) {
            currentIndex = (currentIndex + 1) % fileList.size();
            frame.setImageForNewPhoto(fileList.get(currentIndex).getAbsolutePath());
        }
    }
}
