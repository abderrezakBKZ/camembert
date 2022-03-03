package Tp_camembert;

public interface ICamembertModel {
	
	

	public void addItem(String intitule,String desc, double valeur);
	public void removeItem(String intutle);
	
	public double getValues(int i);
	public double total();
	public int size();
	public String getUnit();
	public String getTitle();
	public String getTitle(int i);
	public String getDescription(int i);
	public void addObserver(CamembertView camembertView);

}
