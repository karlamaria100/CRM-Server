package karla.pao.controllers;

import com.sun.xml.internal.ws.api.model.MEP;
import karla.pao.Model.Client;
import karla.pao.Model.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Karla on 10.05.2017.
 */
public class MessageInterpreter {


    private ObjectOutputStream output;
    private ObjectInputStream input;

    public MessageInterpreter(ObjectInputStream inputStream, ObjectOutputStream outputStream){
        output = outputStream;
        input = inputStream;
    }

    public boolean writeObject(Object message){
        try {
            output.writeObject(message);
            System.out.print(message);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public String getMessage(){
        try {
            return (String) input.readObject();
        } catch (IOException e) {
            e.printStackTrace();
            return "Reading failed";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "Reading failed";
        }
    }

    public boolean wantsClientList(String message){
        if(message.equals("REQUEST CLIENT LIST"))
            return true;
        return false;
    }



}
