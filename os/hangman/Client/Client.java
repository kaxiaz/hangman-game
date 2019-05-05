package os.hangman.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args)throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        sendObject();
    }
    private static void sendObject() throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        //get the localhost IP address, if server is running on some other IP, you need to use that
        InetAddress host = InetAddress.getLocalHost();
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        String test = "TEST";
        int port = 9876;
        socket = new Socket("127.0.0.1", port);
        oos = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Sending request to Socket Server");
        oos.writeObject(""+test);
        ois = new ObjectInputStream(socket.getInputStream());
        String message = (String) ois.readObject();
        //port = Integer.parseInt(message);
        System.out.println("Message: " + message);
        //close resources
        ois.close();
        oos.close();
        Thread.sleep(1000);
    }
}
