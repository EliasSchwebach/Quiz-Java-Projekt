package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Allgemeinwissen {
	public static String Fragen(String frage) {
		String URL = "https://opentdb.com/api.php?amount=50&category=9&type=multiple";
		String content = URL(URL);
		return content;
	}

	public static String URL(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		String urlContent = "";

		ResponseHandler<String> rh = new ResponseHandler<String>() {
			@Override
			public String handleResponse(HttpResponse hr) throws ClientProtocolExeption, IOException {
				HttpEntity entity = hr.getEntity();
				if (entity == null) {
					throw new ClientProtocolException("Response contains no content");
				}
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
			urlContent = httpclient.execute(httpget, rh);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urlContent;
	}
}
