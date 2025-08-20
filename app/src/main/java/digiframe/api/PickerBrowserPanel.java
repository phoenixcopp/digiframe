package digiframe.api;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.io.IOException;

public class PickerBrowserPanel extends JPanel {
    private JFXPanel jfxPanel;
    private HttpServerWrapper server;
    private static final int PORT = 8080;

    public PickerBrowserPanel() {
        setLayout(new BorderLayout());
        jfxPanel = new JFXPanel();
        add(jfxPanel, BorderLayout.CENTER);

        // Start HTTP server
        startHttpServer();

        Platform.runLater(() -> {
            WebView webView = new WebView();
            WebEngine webEngine = webView.getEngine();
            
            // Load from HTTP server
            if (server != null) {
                String serverUrl = server.getBaseUrl();
                String fullUrl = serverUrl + "/index.html";
                webEngine.load(fullUrl);
            }
            
            webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
                if (newState == javafx.concurrent.Worker.State.SUCCEEDED) {
                    // Set up file selection callback
                    webEngine.executeScript(
                        "window.javaCallback = function(fileData) { " +
                        "  console.log('Selected:', fileData); " +
                        "};"
                    );
                }
            });
            
            jfxPanel.setScene(new Scene(webView));
        });
    }

    private void startHttpServer() {
        try {
            server = new HttpServerWrapper(PORT);
            server.start();
        } catch (IOException e) {
            System.err.println("Failed to start HTTP server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopServer() {
        if (server != null) {
            server.stop();
        }
    }
}