package sjddServerUI.client;

import sjddServerUI.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TabBar;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;



/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SJDDServerUI implements EntryPoint {

	  //Panel principal
	  private HorizontalPanel mainPanel = new HorizontalPanel();
	  
	  //Datos de conexión
	  private TextBox hostTextBox = new TextBox();
	  private TextBox puertoTextBox = new TextBox();
	  private Button addConnectionButton = new Button("Conectar");
	  private Label lastUpdatedLabel = new Label();

	  
	  //Datos para añadir puntos
	  private TextBox addPointName=new TextBox();
	  private TextBox addPointAdress=new TextBox();
	  private ListBox addPointType=new ListBox();
	  private ListBox addMinorType=new ListBox();
	  
	  private VerticalPanel AddPointPanel=new VerticalPanel();
	  private Button addPointButton=new Button();
	  
	  
	  private ConectarServiceAsync conectarSrv;
	@Override
	public void onModuleLoad() {
		//Creamos una tabla flexible para los datos
		
		hostTextBox.setText("172.16.23.131");
		puertoTextBox.setText("6720");
		//Pegar las cajas de texto y el botón en el panel
		mainPanel.add(hostTextBox);
		mainPanel.add(puertoTextBox);
		mainPanel.add(addConnectionButton);
		
		//Ensamblar panel principal
		mainPanel.add(lastUpdatedLabel);
		
		//Insertamos los paneles en el HTML en el div definido
		RootPanel.get("stockList").add(mainPanel);
		
		//Por defecto dejamos el cursor sobre el campo de texto
		hostTextBox.setFocus(true);
	
	 // Creamos un Listener para los eventos del ratón en el botón.
    addConnectionButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        addStock();
      }
    });
    
    // Capturamos también los eventos del teclado del campo de texto.
    hostTextBox.addKeyPressHandler(new KeyPressHandler() {
      public void onKeyPress(KeyPressEvent event) {
        if (event.getCharCode() == KeyCodes.KEY_ENTER) {
          addStock();
        }
      }
    });
    
}
// Método para añadir una fila a la tabla flexible   
   private void addStock() {
	   final String symbol=hostTextBox.getText().toUpperCase().trim();
	   hostTextBox.setFocus(true);
	   if (conectarSrv==null) {
	   conectarSrv=GWT.create(ConectarService.class);
	   }
	   
	   AsyncCallback<String> callback=new AsyncCallback<String>() {

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(String result) {
			mainPanel.remove(hostTextBox);
			mainPanel.remove(puertoTextBox);
			mainPanel.remove(addConnectionButton);
			lastUpdatedLabel.setText("Conexión realizada!!");
			mainPanel.add(lastUpdatedLabel);
			 pintaTab();

		
		}
		   
	   };
	   int puerto=Integer.parseInt(puertoTextBox.getValue());
	   conectarSrv.conectar(hostTextBox.getValue(), puerto, callback);
	}
   
   
   private void pintaTab() {
	   
	   TabPanel tp=new TabPanel();
	   addPoint p= new addPoint();
	   
	   p.pintaPuntoPanel(AddPointPanel);
	   addPointButton.setText("Nuevo pto");
	   AddPointPanel.add(addPointButton);
	   
	   tp.add(AddPointPanel, "Gestionar Puntos");
	   tp.add(new HTML("Recuperar Configuracion"), "Recuperar Configuracion");
	   tp.add(new HTML("Escribir / Leer"), "Escribir / Leer");
	   tp.selectTab(0);
	   mainPanel.remove(lastUpdatedLabel);
	   mainPanel.add(tp);
   }
   
    
}
