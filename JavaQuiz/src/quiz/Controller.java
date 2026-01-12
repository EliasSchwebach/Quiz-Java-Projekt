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
		fragenJson = Allgemeinwissen.getFragen();
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
