package Tp_camembert;
import java.awt.Component;

public interface IController {

	void setSelected(boolean b);

	int getSelectedPie();

	void setSelectedPie(int i);

	boolean isSelected();

	void deSelect();

	void selectPie(int i);

	void nextPie();

	void previousPie();

	Component getView();

	void setSelected(int i);
	
	void setView(CamembertView view);

}
