package quiz;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Controller {
	private Gui gui;
	private String fragenJson;
	private String[] alleFragenRoh;
	private String aktuelleRichtigeAntwort;
	

	public Controller() {
		this.gui = new Gui(this);
	}

	public void loadAllgemeinwissenFragen() {
		fragenJson = QuizDatenQuelle.getFragen("allgemeinwissen");
	}

	public void loadVideoGamesFragen() {
		fragenJson = QuizDatenQuelle.getFragen("videogames");
	}

	public void loadMovieFragen() {
		fragenJson = QuizDatenQuelle.getFragen("filme");
	}
	
	public void zeigeAnmelden()
	{
		AnmeldePanel meinPanel = new AnmeldePanel(this);
		this.gui.setView(meinPanel);
	}

	public void zeigeAllgemeinwissen() {
		AllgemeinwissenPanel meinPanel = new AllgemeinwissenPanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	public void zeigeVideoGames() {
		VideoGamesPanel meinPanel = new VideoGamesPanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	public void zeigeMovie() {
		MoviePanel meinPanel = new MoviePanel(this);
		fuellePanelMitZufallsFrage(meinPanel);
		this.gui.setView(meinPanel);
	}

	private void fuellePanelMitZufallsFrage(Object panel) {
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

	private String extrahiere(String text, String start, String ende) {
		try {
			int s = text.indexOf(start) + start.length();
			int e = text.indexOf(ende, s);
			return text.substring(s, e);
		} catch (Exception e) {
			return "Fehler";
		}
	}

	private String säubere(String t) {
		return t.replace("&quot;", "\"").replace("&#039;", "'").replace("&amp;", "&");
	}

	public Gui getGui() {
		return this.gui;
	}

	public void pruefeAntwort(JButton geklickterButton, String gewaehlteAntwort, Object aktuellesPanel) {
		if (gewaehlteAntwort.equals(aktuelleRichtigeAntwort)) {
			// Richtig
			geklickterButton.setBackground(new Color(46, 204, 113));
			geklickterButton.setBorder(new LineBorder(new Color(39, 174, 96), 4, true));
		} else {
			// Falsch
			geklickterButton.setBackground(new Color(231, 76, 60));
			geklickterButton.setBorder(new LineBorder(new Color(192, 57, 43), 4, true));

			markiereRichtigenButton(aktuellesPanel);
		}

		// Timer starten
		javax.swing.Timer timer = new javax.swing.Timer(1650, e -> {
			if (aktuellesPanel instanceof AllgemeinwissenPanel)
				zeigeAllgemeinwissen();
			else if (aktuellesPanel instanceof MoviePanel)
				zeigeMovie();
			else if (aktuellesPanel instanceof VideoGamesPanel)
				zeigeVideoGames();
		});
		timer.setRepeats(false);
		timer.start();
	}

	private void markiereRichtigenButton(Object panel) {
		JButton[] buttons = new JButton[4];

		if (panel instanceof AllgemeinwissenPanel) {
			AllgemeinwissenPanel p = (AllgemeinwissenPanel) panel;
			buttons[0] = p.btnAntwort1;
			buttons[1] = p.btnAntwort2;
			buttons[2] = p.btnAntwort3;
			buttons[3] = p.btnAntwort4;
		} else if (panel instanceof MoviePanel) {
			MoviePanel p = (MoviePanel) panel;
			buttons[0] = p.btnAntwort1;
			buttons[1] = p.btnAntwort2;
			buttons[2] = p.btnAntwort3;
			buttons[3] = p.btnAntwort4;
		} else if (panel instanceof VideoGamesPanel) {
			VideoGamesPanel p = (VideoGamesPanel) panel;
			buttons[0] = p.btnAntwort1;
			buttons[1] = p.btnAntwort2;
			buttons[2] = p.btnAntwort3;
			buttons[3] = p.btnAntwort4;
		}

		// prüft welcher Button die richtige Antwort hat
		for (JButton b : buttons) {
			if (b != null && b.getText().equals(säubere(aktuelleRichtigeAntwort))) {
				b.setBackground(new Color(200, 240, 200));
				b.setBorder(new LineBorder(new Color(46, 204, 113), 3, true));
			}
		}
	}
}
