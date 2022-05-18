/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author QUANG VAN
 */
public class Asset implements Comparable{
    private final String assetID;
    private String assetName;
    private String color;
    private int price;
    private double weight;
    private int quantity;
    private int curQuantity;

    public Asset(String assetID) {
        this.assetID = assetID;
        this.assetName = "";
        this.color = "";
        this.price = 0;
        this.weight = 0;
        this.quantity = 0;
        this.curQuantity = 0;
    }

    public Asset(String assetID, String assetName, String color, int price, 
            double weight, int quantity, int curQuantity) {
        this.assetID = assetID;
        this.assetName = assetName;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.curQuantity = curQuantity;
    }

    public String getAssetID() {
        return assetID;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getCurQuantity() {
        return curQuantity;
    }

    public void setCurQuantity(int curQuantity) {
        this.curQuantity = curQuantity;
    }
    
    @Override
    public String toString(){
        return String.format("%-10s | %-20s | %-10s | %-10d | %-10.2f | %10d| %10d",assetID,assetName,
                color,price,weight,quantity, getCurQuantity());
    }
    
    @Override
    public int compareTo(Object o){
        Asset a = (Asset)o;
        int result = assetName.compareTo(a.getAssetName());
        if(result<0)
            return 1;
        else if(result>0)
            return -1;
        else return 0;
    }
}
