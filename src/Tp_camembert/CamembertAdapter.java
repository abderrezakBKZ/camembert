package Tp_camembert;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


public class CamembertAdapter extends Observable implements ICamembertModel {

	private ArrayList<Item> items = new ArrayList<Item>();
	private String titre;
	private String unit;
	private ArrayList<CamembertView> observers = new ArrayList<CamembertView>();
	
	private TableModel tableModel;
	
	protected ArrayList<Item> getItems(){
		return items;
	}
	public CamembertAdapter() {
		this.titre="Default Title";
		this.unit="$";
		this.tableModel = new AbstractTableModel() {

			private static final long serialVersionUID = 1L;
			
			
			public int getColumnCount() {
				return 3;
			}
			public int getRowCount() {
				return items.size();
			}
			public String getColumnName(int columnIndex) {
				String [] columns = {"Intitulé","Description","Valeur"};
				return columns[columnIndex];
			}
			@Override
			public Object getValueAt(int row, int col) {
				
				switch(col) {
				case 0 : return items.get(row).intitule;
				case 1 : return items.get(row).desc;
				case 2 : return items.get(row).valeur;
				default : System.out.println("Unknown column ID");return "ERROR";
				}
			}
		};
	}
	
	public AbstractTableModel getTableModel() {
		return (AbstractTableModel) this.tableModel;
	}
	
	public String getTitle() {
		return titre;
	}
	
	public String getUnit() {
		return unit;
	}
	public void setTitle(String title) {
		this.titre=title;
	}
	
	public void setUnit(String unit) {
		this.unit=unit;
	}

	public class Item{

		String intitule ="";
		String desc = "";
		double valeur = 0.0;


		public Item(String intitule, String desc, double valeur) {
			super();
			this.intitule = intitule;
			this.desc = desc;
			
			this.valeur = Math.abs(valeur);
		}
		public String getIntitule() {
			return intitule;
		}
		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public double getValeur() {
			return valeur;
		}
		public void setValeur(int valeur) {
			this.valeur = valeur;
		}
	}

	@Override
	public void addObserver(CamembertView camembertView) {
		
		this.observers.add(camembertView);
		super.addObserver(camembertView);
		
	}
	
	@Override
	public void addItem(String intitule, String desc, double valeur) {
		Item item_to_add = new Item(intitule,desc,valeur);
		this.getItems().add(item_to_add);
		
		setChanged();
		notifyObservers();

	}

	@Override
	public void removeItem(String intitule) {
		
		boolean deletedItem=false;
		
		for(Item item : getItems()) {
			if(item.getIntitule().equals(intitule)) {
				this.getItems().remove(item);
				deletedItem=true;
			}
		}
		
		if(deletedItem) setChanged();
		notifyObservers();
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
	public String getTitle(int i) {
		return this.getItems().get(i).getIntitule();
	}

	@Override
	public String getDescription(int i) {
		return this.getItems().get(i).getDesc();
	}


}
