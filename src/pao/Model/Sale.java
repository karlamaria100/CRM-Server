package pao.Model;

import java.io.Serializable;

/**
 * Created by Karla on 19.05.2017.
 */
public class Sale implements Serializable{

    double stock;
    double pret;

    public double getStock() {
        return stock;
    }

    public double getPret() {
        return pret;
    }

    public String getBuyer() {
        return buyer;
    }

    String buyer;

    public Sale(double stock, double pret, String buyer){
        this.stock = stock;
        this.pret = pret;
        this.buyer = buyer;
    }

}
