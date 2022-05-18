/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class Request {
    private String rbID;
    private Employee emp;
    private Asset asset;
    private int rQuantity;
    private Date rDate;
    private Date bDate;
    private Date returnDate;

    public Request() {
        this.rbID = "";
        this.emp = null;
        this.asset = null;
        this.rQuantity = 0;
        this.rDate = null;
        this.bDate = null;
        this.returnDate = null;
    }
    
    public Request(String rbID, Employee emp, Asset asset, int rQuantity, 
            Date rDate, Date bDate, Date returnDate) {
        this.rbID = rbID;
        this.emp = emp;
        this.asset = asset;
        this.rQuantity = rQuantity;
        this.rDate = rDate;
        this.bDate = bDate;
        this.returnDate = returnDate;
    }

    public String getrbID() {
        return rbID;
    }

    public void setrbID(String rID) {
        this.rbID = rID;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getrQuantity() {
        return rQuantity;
    }

    public void setrQuantity(int rQuantity) {
        this.rQuantity = rQuantity;
    }
    
    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
    
    @Override
    public String toString(){
        return String.format("%-10s | %-10s | %-10s | %-10d | %-10d | %-10d | %20s | %20s | %20s", rbID, 
                asset.getAssetID(), emp.getEmpID(), asset.getQuantity(), rQuantity, 
                asset.getCurQuantity(),Utils.getDateTime(rDate), Utils.getDateTime(bDate), Utils.getDateTime(returnDate));
    }
}
