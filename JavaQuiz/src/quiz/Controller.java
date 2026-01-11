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
	
	public void zeigeAllgemeinwissen() {
        // 1. Daten laden (Model)
        String json = Allgemeinwissen.getFragen();
        
        // 2. Panel erstellen (View)
        AllgemeinwissenPanel panel = new AllgemeinwissenPanel();
        
        // Hier müsstest du später die Fragen an das Panel übergeben
        // panel.setFragen(parseJson(json)); 

        // 3. View aktualisieren
        gui.switchPanel(panel);
    }
}
