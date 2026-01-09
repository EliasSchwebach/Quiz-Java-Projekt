package quiz;

public class Controller {
	private Gui gui;

	public Controller() {
		this.gui = new Gui(this);
		loadAllgemeinwissenFragen();
	}
	
	public void loadAllgemeinwissenFragen()
	{
		String fragenJson = Allgemeinwissen.getFragen();
	}
}
