package sjddServerUI.client;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


public class addPoint {

	  private TextBox addPointName=new TextBox();
	  private TextBox addPointAdress=new TextBox();
	  private ListBox addPointType=new ListBox();
	  private ListBox addMinorType=new ListBox();
	  private Label   adressLabel=new Label();
	  private Label   nameLabel=new Label();
	  private Label   tipoLabel=new Label();
	  private Label   minorLabel=new Label();

	  public addPoint () {
		  nameLabel.setText("Nombre del pto: ");
		  adressLabel.setText("Direccion del pto: ");
		  tipoLabel.setText("Tipo:");
		  minorLabel.setText("Minor:");
		  
		  addMinorType.addItem("DSP STEP");
		  addMinorType.addItem("DSP SCALE");
		  addPointType.addItem("DST BOOLEAN");
		  addPointType.addItem("DST 8-BIT");
		  
		  
		addPointType.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				if (addPointType.getSelectedIndex()==0) {
					addMinorType.setSelectedIndex(0);
				}
				else if (addPointType.getSelectedIndex()==1) {
					addMinorType.setSelectedIndex(1);
				}
				
			}
			
		});
		  
	  }
	  
	  public void pintaPuntoPanel(HorizontalPanel panel) {
		  panel.add(nameLabel);
		  panel.add(addPointName);
		  panel.add(adressLabel);
		  panel.add(addPointAdress);
		  panel.add(tipoLabel);
		  panel.add(addPointType);
		  panel.add(minorLabel);
		  panel.add(addMinorType);
	  }
	  public void pintaPuntoPanel(VerticalPanel panel) {
		  panel.add(nameLabel);
		  panel.add(addPointName);
		  panel.add(adressLabel);
		  panel.add(addPointAdress);
		  panel.add(tipoLabel);
		  panel.add(addPointType);
		  panel.add(minorLabel);
		  panel.add(addMinorType);
	  }
	
}
