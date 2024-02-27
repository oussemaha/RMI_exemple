import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Define the remote interface
interface MyRemoteInterface extends Remote {
    String sayHello() throws RemoteException;
}

// Implement the remote interface
public class RMI_server extends UnicastRemoteObject implements MyRemoteInterface {
    public RMI_server() throws RemoteException {
        // Constructor to declare that this class throws RemoteException
    }

    // Implementation of the remote method
    public String sayHello() throws RemoteException {
        return "Hello from server!";
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the server object
            RMI_server server = new RMI_server();
            // Bind the server object to the RMI registry
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("RMI_s", server);
            System.out.println("Server ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
