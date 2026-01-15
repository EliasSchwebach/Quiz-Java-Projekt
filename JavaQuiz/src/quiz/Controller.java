package quiz;

import java.util.ArrayList;

import java.util.Collections;

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

		AllgemeinwissenPanel meinPanel = new AllgemeinwissenPanel();


		this.gui.setView(meinPanel);

	}

	public void zeigeVideoGames()

	{

		VideoGamesPanel meinPanel = new VideoGamesPanel();


		this.gui.setView(meinPanel);

	}

	public void zeigeMovie()

	{

		MoviePanel meinPanel = new MoviePanel();


		this.gui.setView(meinPanel);

	}
}