import java.rmi.Naming;

public class RMI_client {
    public static void main(String[] args) {
        try {
            // Look up the remote object from the RMI registry
            MyRemoteInterface remoteService = (MyRemoteInterface) Naming.lookup("rmi://localhost/RMI_s");
            // Call the remote method
            String message = remoteService.sayHello();
            System.out.println("Message from server: " + message);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
