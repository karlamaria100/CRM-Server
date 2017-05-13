package karla.pao.mainClasses;

import karla.pao.controllers.Controller;

/**
 * Created by Karla on 10.05.2017.
 */
public class Server {

    private boolean running;

    public void start(){

        //Controller.getInstance().addClients();
        if (Controller.getInstance().acceptConnection()){
            running = true;

            while(running){
                String message = Controller.getInstance().read();
                if(Controller.getInstance().wantsClientList(message)){
                    Controller.getInstance().sendClientList();
                }
            }
        }
    }



}
