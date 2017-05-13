package pao;

/**
 * Created by Karla on 13.05.2017.
 */
public interface DatabaseData {

    public static final String insertCustomer = "INSERT INTO crm.persoana_fizica (`idpersoana_fizica`, `nume`, `prenume`) VALUES (?, ?, ?)";
    public static final String selectCustomers = "SELECT * FROM crm.persoana_fizica";
    public static final String insertCompany = "INSERT INTO crm.persoana_juridica (`idpersoana_juridica`, `nume`) VALUES (?, ?)";
    public static final String selectCompany = "SELECT * FROM crm.persoana_juridica";

}
