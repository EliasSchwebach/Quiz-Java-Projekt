package quiz;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Controller
{
	private Gui gui;
	private String fragenJson;
	private String[] alleFragenRoh;
	private String aktuelleRichtigeAntwort;

	public Controller()
	{
		this.gui = new Gui(this);
	}

	public void loadAllgemeinwissenFragen()
	{
		fragenJson = QuizDatenQuelle.getFragen("allgemeinwissen");
	}

	public void loadVideoGamesFragen()
	{
		fragenJson = QuizDatenQuelle.getFragen("videogames");
	}

	public void loadMovieFragen()
	{
		fragenJson = QuizDatenQuelle.getFragen("filme");
	}

	public void zeigeAllgemeinwissen()
	{
		AllgemeinwissenPanel meinPanel = new AllgemeinwissenPanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	public void zeigeVideoGames()
	{
		VideoGamesPanel meinPanel = new VideoGamesPanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	public void zeigeMovie()
	{
		MoviePanel meinPanel = new MoviePanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	private void fuellePanelMitZufallsFrage(Object panel)
	{
		if (fragenJson == null || fragenJson.isEmpty() || !fragenJson.contains("question")) {
			System.out.println("Fehler: Keine Fragen geladen!");
			return;
		}

		// Splitten und zufallsfrage:
		alleFragenRoh = fragenJson.split("\\{\"type\":");
		if (alleFragenRoh.length < 2) {
			System.out.println("Fehler, JSON Format passt nicht oder keine Fragen vorhanden.");
			return;
		}

		int index = (int) (Math.random() * (alleFragenRoh.length - 1)) + 1;
		String roh = alleFragenRoh[index];

		// Richtige Antwort und Frage:
		String frage = extrahiere(roh, "\"question\":\"", "\"");
		aktuelleRichtigeAntwort = extrahiere(roh, "\"correct_answer\":\"", "\"");

		// Nur falsche Antworten extrahieren
		String falscheTeil = extrahiere(roh, "\"incorrect_answers\":[", "]");
		// falscheTeil: "Antwort1","Antwort2","Antwort3"

		// Nach Komma trennen
		String[] f = falscheTeil.split("\",\"");

		// Anführungszeichen am Anfang von f0 und am Ende von f2 weg machen
		String f1 = f[0].replace("\"", "");
		String f2 = f[1].replace("\"", "");
		String f3 = f[2].replace("\"", "");

		// Antworten mischen
		ArrayList<String> antworten = new ArrayList<>();
		antworten.add(aktuelleRichtigeAntwort);
		antworten.add(f1);
		antworten.add(f2);
		antworten.add(f3);
		Collections.shuffle(antworten);

		// Texte säubern
		frage = säubere(frage);

		// ins panel schreiben
		if (panel instanceof AllgemeinwissenPanel) {
			AllgemeinwissenPanel p = (AllgemeinwissenPanel) panel;
			p.textFieldFrage.setText(frage);
			p.btnAntwort1.setText(säubere(antworten.get(0)));
			p.btnAntwort2.setText(säubere(antworten.get(1)));
			p.btnAntwort3.setText(säubere(antworten.get(2)));
			p.btnAntwort4.setText(säubere(antworten.get(3)));
		} else if (panel instanceof MoviePanel) {
			MoviePanel p = (MoviePanel) panel;
			p.textFieldFrage.setText(frage);
			p.btnAntwort1.setText(säubere(antworten.get(0)));
			p.btnAntwort2.setText(säubere(antworten.get(1)));
			p.btnAntwort3.setText(säubere(antworten.get(2)));
			p.btnAntwort4.setText(säubere(antworten.get(3)));
		} else if (panel instanceof VideoGamesPanel) {
			VideoGamesPanel p = (VideoGamesPanel) panel;
			p.textFieldFrage.setText(frage);
			p.btnAntwort1.setText(säubere(antworten.get(0)));
			p.btnAntwort2.setText(säubere(antworten.get(1)));
			p.btnAntwort3.setText(säubere(antworten.get(2)));
			p.btnAntwort4.setText(säubere(antworten.get(3)));
		}
	}

	private String extrahiere(String text, String start, String ende)
	{
		try {
			int s = text.indexOf(start) + start.length();
			int e = text.indexOf(ende, s);
			return text.substring(s, e);
		} catch (Exception e) {
			return "Fehler";
		}
	}

	private String säubere(String t)
	{
		return t.replace("&quot;", "\"").replace("&#039;", "'").replace("&amp;", "&");
	}

	public Gui getGui()
	{
		return this.gui;
	}

	public void pruefeAntwort(JButton geklickterButton, String gewaehlteAntwort, Object aktuellesPanel) {
	    if (gewaehlteAntwort.equals(aktuelleRichtigeAntwort)) {
	        // Richtig!
	        geklickterButton.setBackground(new Color(46, 204, 113)); // Schönes Grün
	        geklickterButton.setBorder(new LineBorder(Color.GREEN, 4, true));
	    } else {
	        // Falsch!
	        geklickterButton.setBackground(new Color(231, 76, 60)); // Schönes Rot
	        geklickterButton.setBorder(new LineBorder(Color.RED, 4, true));
	        // Optional: Zeige dem Nutzer auch die richtige Antwort kurz an
	    }

	    // Kurze Pause (1 Sekunde), dann nächste Frage laden
	    javax.swing.Timer timer = new javax.swing.Timer(1200, e -> {
	        if (aktuellesPanel instanceof AllgemeinwissenPanel) zeigeAllgemeinwissen();
	        else if (aktuellesPanel instanceof MoviePanel) zeigeMovie();
	        else if (aktuellesPanel instanceof VideoGamesPanel) zeigeVideoGames();
	    });
	    timer.setRepeats(false);
	    timer.start();
	}
	
	public void themeWechsel()
	{
		this.gui.setBackground(Color.DARK_GRAY);
	}
}
