package sjddServerUI.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void greetServer(String input, AsyncCallback<String> callback)
	throws IllegalArgumentException;
	void getConnection(String input, int port, AsyncCallback<String> callback)
	throws IllegalArgumentException;
}
