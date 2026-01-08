package quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Allgemeinwissen {
	public static String getFragen() {
		try {
			URL url = URI.create("https://opentdb.com/api.php?amount=50&category=9&type=multiple").toURL();
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder content = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			return content.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}