package quiz;

public class Controller
{
	private Gui gui;
	private String fragenJson;

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
}
