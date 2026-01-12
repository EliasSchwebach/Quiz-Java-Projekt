package quiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class QuizDatenQuelle {

    // Diese Methode entscheidet anhand der Kategorie-ID, was geladen wird
    public static String getFragen(int kategorieID) {
        String url = "https://opentdb.com/api.php?amount=50&type=multiple&category=" + kategorieID;
        return getUrl(url);
    }

    public static String getUrl(String url) {
        // Erstellen des Apache HttpClients laut Aufgabenblatt
        CloseableHttpClient httpclient = HttpClients.createDefault(); // (1)
        HttpGet httpget = new HttpGet(url); // (2)
        String urlContent = "";

        // ResponseHandler zur Verarbeitung der Antwort
        ResponseHandler<String> rh = new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse hr) throws org.apache.http.ClientProtocolException, java.io.IOException {
                HttpEntity entity = hr.getEntity();
                if (entity == null) {
                    throw new org.apache.http.ClientProtocolException("Response contains no content");
                }
                
                // Einlesen des Inhalts mittels BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
                StringBuilder sb = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    sb.append(output);
                }
                return sb.toString();
            }
        };

        try {
            urlContent = httpclient.execute(httpget, rh); // (3)
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return urlContent;
    }
}