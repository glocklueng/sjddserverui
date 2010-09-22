package sjddServerUI.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("conectarService")
public interface ConectarService extends RemoteService {
	
	String conectar(String host, int port);
}
