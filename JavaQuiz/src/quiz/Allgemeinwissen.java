package quiz;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Allgemeinwissen {

    public static String getFragen() {
        // Die URL aus deinem Beispiel
        String urlString = "https://opentdb.com/api.php?amount=50&category=9&type=multiple";

        // Erstellen des JDK HttpClient (verfügbar ab Java 11)
        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int status = response.statusCode();
            if (status >= 200 && status < 300) {
                return response.body();
            } else {
                return "Server-Fehler: Status " + status;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Fehler beim Abrufen der Fragen: " + e.getMessage();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
            return "Abbruch beim Abrufen der Fragen: " + e.getMessage();
        }
    }
}