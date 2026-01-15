package quiz;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class QuizDatenQuelle
{

	public static String getFragen(String thema)
	{

		String urlString = "";

		// auswählen
		if (thema.equals("videogames")) {
			urlString = "https://opentdb.com/api.php?amount=50&category=15&type=multiple";
		} else if (thema.equals("filme")) {
			urlString = "https://opentdb.com/api.php?amount=50&category=11&type=multiple";
		} else if (thema.equals("allgemeinwissen")) {
			urlString = "https://opentdb.com/api.php?amount=50&category=9&type=multiple";
		}

		// Client erstellen
		HttpClient client = HttpClient.newHttpClient();

		// Anfrage machen
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlString)).build();

		try {
			// Daten holen
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();

		} catch (Exception e) {
			System.out.println("Fehler beim Laden von " + thema + ": " + e.getMessage());
			return null;
		}
	}
}
