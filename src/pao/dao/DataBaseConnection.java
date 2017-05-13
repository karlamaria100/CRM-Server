package karla.pao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Karla on 01.04.2017.
 */
public class DataBaseConnection {

    private Connection connection ;

    public DataBaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CRM?autoReconnect=true&useSSL=false","karla", "kaichou2!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // function for select
    // function for insert






}
