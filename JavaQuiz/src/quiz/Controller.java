package quiz;

public class Controller {
	private Gui gui;
	private String fragenJson;

	public Controller() {
		this.gui = new Gui(this);
		loadAllgemeinwissenFragen();
	}
	
	public void loadAllgemeinwissenFragen()
	{
		String fragenJson = Allgemeinwissen.getFragen();
	}
	
	public void zeigeAllgemeinwissen() {
	    AllgemeinwissenPanel meinPanel = new AllgemeinwissenPanel();
	    
	    this.gui.setView(meinPanel);
	}
}
