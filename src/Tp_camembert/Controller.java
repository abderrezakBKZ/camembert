package Tp_camembert;
import java.awt.Component;

public class Controller implements IController{
	
	CamembertView view;
	ICamembertModel model;
	boolean isSelected=false;
	int selectedIndex=0;
	
	public Controller(ICamembertModel model) {

		this.model=model;
		
		
	}
	
	public Controller(CamembertView view,ICamembertModel model) {
		
		this.view=view;
		this.model=model;
		
		
	}
	
	
	@Override
	public void setSelected(boolean b) {
		isSelected = b;
		view.repaint();
		
	}

	@Override
	public int getSelectedPie() {
		return selectedIndex;
	}

	@Override
	public void setSelectedPie(int i) {
		this.selectedIndex=i;
		setSelected(true);
		view.repaint();
		
	}

	@Override
	public boolean isSelected() {
		return isSelected;
	}

	@Override
	public void deSelect() {
		setSelected(false);
	}

	@Override
	public void selectPie(int i) {
		selectedIndex=i;
		setSelected(true);
		view.repaint();
	}

	@Override
	public void nextPie() {
		this.selectedIndex = (this.selectedIndex+1)%model.size();
		view.repaint();
	}

	@Override
	public void previousPie() {
		this.selectedIndex = (this.selectedIndex-1);
		if(this.selectedIndex == -1) {
			this.selectedIndex = model.size()-1;
		}
		view.repaint();
	}
	
	@Override
	public Component getView() {
		return view;
	}
	@Override
	public void setSelected(int i) {
		this.selectedIndex=i;
		setSelected(true);
		view.repaint();
	}

	@Override
	public void setView(CamembertView view) {
		this.view=view;
		
	}

}
