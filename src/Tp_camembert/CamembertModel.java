package Tp_camembert;

public class CamembertModel extends CamembertAdapter{
	

	@Override
	public void addItem(String intitule, String desc, double valeur) {
		Item item_to_add = new Item(intitule,desc,valeur);
		this.getItems().add(item_to_add);

	}

	@Override
	public void removeItem(String intitule) {
		for(Item item : getItems()) {
			if(item.getIntitule().equals(intitule)) {
				this.getItems().remove(item);
			}
		}
	}

	@Override
	public double getValues(int i) {
		return this.getItems().get(i).getValeur();
	}
	
	@Override
	public int size() {
		return this.getItems().size();
	}

	@Override
	public double total() {
		double total = 0.0;
		for(Item item : getItems()) {
			total += item.getValeur();
		}
		return total;
	}

	@Override
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	public String getTitle(int i) {
		return this.getItems().get(i).getIntitule();
	}

	@Override
	public String getDescription(int i) {
		return this.getItems().get(i).getDesc();
	}

	@Override
	public String getUnit() {
		return super.getUnit();
	}

}
