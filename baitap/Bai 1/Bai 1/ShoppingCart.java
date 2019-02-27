package model;

import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
import java.lang.Float;
import java.util.Hashtable;
import java.util.Enumeration;

public class ShoppingCart implements Serializable{

    protected Hashtable items = new Hashtable();   

    public void addItem(String id, String name, double price, int amount, String image) {
    String[] item = {id, name, Double.toString(price), Integer.toString(amount), image};

    if (items.containsKey(id)) {

      String[] tmpId = (String[])items.get(id);
      int tmpQuant = Integer.parseInt(tmpId[3]);
      amount += tmpQuant;
      tmpId[3] = Integer.toString(amount);
      tmpId[4] = image;
    }
    else {

      items.put(id, item);
    }
  }
  public void addItem(String itemId, String desc, float price, int quantity) {
        String[] item = {itemId, desc, Float.toString(price),
            Integer.toString(quantity)};

        if (items.containsKey(itemId)) {

            String[] tmpItem = (String[]) items.get(itemId);
            int tmpQuant = Integer.parseInt(tmpItem[3]);
            quantity += tmpQuant;
            tmpItem[3] = Integer.toString(quantity);
        } else {

            items.put(itemId, item);
        }
    }    

    public void removeItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
        }
    }

    public void updateQuantity(String itemId, int quantity) {
        if (items.containsKey(itemId)) {
            String[] tmpItem = (String[]) items.get(itemId);
            tmpItem[3] = Integer.toString(quantity);
        }
    }

    public Enumeration getEnumeration() {
        return items.elements();
    }

    public float getCost() {

        Enumeration e = items.elements();
        String[] tmpItem;
        float totalCost = 0.00f;

        while (e.hasMoreElements()) {

            tmpItem = (String[]) e.nextElement();
            totalCost += (Integer.parseInt(tmpItem[3])
                    * Float.parseFloat(tmpItem[2]));
        }
        return totalCost;
    }

    public int getNumOfItems() {

        Enumeration e = items.elements();
        String[] tmpItem;
        int numOfItems = 0;

        while (e.hasMoreElements()) {

            tmpItem = (String[]) e.nextElement();
            numOfItems += Integer.parseInt(tmpItem[3]);
        }

        return numOfItems;
    }
    public double getSumOfPrice() {

        Enumeration e = items.elements();
        String[] tmpItem;
        
        double sumofPrice = 0;
        while (e.hasMoreElements()) {

            tmpItem = (String[]) e.nextElement();
            
            sumofPrice += Integer.parseInt(tmpItem[3]) * Double.parseDouble(tmpItem[2]);
        }

        return sumofPrice;
    }
}
