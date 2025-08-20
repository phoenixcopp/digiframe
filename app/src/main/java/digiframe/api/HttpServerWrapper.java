package digiframe.api;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class HttpServerWrapper {
    private HttpServer server;
    private final int port;

    public HttpServerWrapper(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        
        // Serve the HTML file
        server.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                String response = getHtmlContent();
                
                // Set CORS headers
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
                exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type");
                exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                
                exchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_8).length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes(StandardCharsets.UTF_8));
                os.close();
            }
        });
        
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on http://localhost:" + port);
    }

    public void stop() {
        if (server != null) {
            server.stop(0);
        }
    }

    private String getHtmlContent() {
        try (InputStream is = getClass().getResourceAsStream("/index.html")) {
            if (is != null) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Fallback HTML content
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Google Picker API</title>
            </head>
            <body>
                <h1>Error: Could not load index.html</h1>
                <p>Please ensure index.html is in the resources folder.</p>
            </body>
            </html>
            """;
    }

    public String getBaseUrl() {
        return "http://localhost:" + port;
    }
}