package sjddServerUI.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


	public interface ConectarServiceAsync {

		void conectar(String host, int port, AsyncCallback<String> callback);
		
	}	

