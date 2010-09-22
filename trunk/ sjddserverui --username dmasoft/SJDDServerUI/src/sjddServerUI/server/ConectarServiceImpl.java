package sjddServerUI.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import sjddServerUI.client.ConectarService;

public class ConectarServiceImpl extends RemoteServiceServlet implements ConectarService{

	public String conectar(String host, int Port) {
		if(host.equalsIgnoreCase("172.16.23.131")) {
			return "conectado";
		}
		return "descontectado";
	}
	
}
