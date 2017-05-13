package karla.pao.controllers;

import karla.pao.Model.Client;
import karla.pao.Model.Company;
import karla.pao.Model.Customer;

import java.util.ArrayList;

/**
 * Created by Karla on 10.05.2017.
 */
public class Controller {

    private DatabaseController databaseController;
    private static Controller instance;
    private ClientConnection connection;
    private MessageInterpreter messageInterpreter;

    private Controller(){
        databaseController = DatabaseController.getInstance();
        connection = new ClientConnection();
    }

    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        return instance;
    }

    public boolean acceptConnection(){
        return connection.accept();
    }

    public void write(Object object){
        if(!messageInterpreter.writeObject(object))
            System.out.println(" - Message sent failed");
        else System.out.println(" - Message sent successful ");
    }


    public void setUpMessage(){
        messageInterpreter = new MessageInterpreter(connection.getInputStream(), connection.getOutputStream());
    }
    public String read(){
        return messageInterpreter.getMessage();
    }

    public ArrayList<Client> getCustomers(){
        return databaseController.getInstance().getCustomers();
    }

    public boolean wantsClientList(String message){
        return messageInterpreter.wantsClientList(message);
    }

    public void sendClientList(){
       // write(getCustomers());
        write(new Company("Firma"));
    }

    public void addClients(){
        databaseController.exportClientList();
    }
}
