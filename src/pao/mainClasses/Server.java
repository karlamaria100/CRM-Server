package pao.mainClasses;

import pao.ConnectionData;
import pao.Model.Company;
import pao.Model.Customer;
import pao.Model.Factura;
import pao.Model.Product;
import pao.controllers.Controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Karla on 10.05.2017.
 */
public class Server {

    ServerSocket serverSocket;

    public void start(){
        try {
            serverSocket = new ServerSocket(ConnectionData.port);
            while (true){
                Socket socket = Controller.acceptConnection(serverSocket);
                ClientThread clientThread = new ClientThread(socket);
                clientThread.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
