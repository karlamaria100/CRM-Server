package karla.pao.controllers;

import karla.pao.Model.Company;
import karla.pao.Model.Customer;
import karla.pao.dao.DataBaseConnection;
import karla.pao.Model.Client;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Karla on 10.05.2017.
 */
public class DatabaseController {

    private static DatabaseController instance;
    DataBaseConnection dataBaseConnection;

    private DatabaseController(){
        dataBaseConnection = new DataBaseConnection();
    }

    public static DatabaseController getInstance(){
        if(instance == null)
            instance = new DatabaseController();
        return instance;
    }

    public ArrayList<Client> getCustomers(){
            ArrayList<Client> arr = null;
            try (FileInputStream fileIn = new FileInputStream("exportClients.txt");
                 ObjectInputStream in = new ObjectInputStream(fileIn)){
                arr = (ArrayList<Client>) in.readObject();
            }catch(IOException i) {
                i.printStackTrace();
            }catch(ClassNotFoundException c) {
                System.out.println("Client class not found");
                c.printStackTrace();
            }
            return arr;
    }

    public void exportClientList() {
        ArrayList<Client> listClients = new ArrayList<>();
        listClients.add(new Company("Ion"));
        try {
            FileOutputStream fileOut = new FileOutputStream("exportClients.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listClients);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in exportClients.txt");
        } catch (IOException i) {

        }
    }

}
