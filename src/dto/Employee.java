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
public class Employee {
    private final String empID;
    private String empName;
    private Date bDate;
    private String role;
    private boolean sex;
    private String pwd;

    public Employee(String empID) {
        this.empID = empID;
        this.empName ="";
        this.bDate = null;
        this.role = "";
        this.sex = false;
        this.pwd = "";
    }

    public Employee(String empID, String empName, Date bDate, String role, boolean sex, String pwd) {
        this.empID = empID;
        this.empName = empName;
        this.bDate = bDate;
        this.role = role;
        this.sex = sex;
        this.pwd = pwd;
    }

    public String getEmpID() {
        return empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSex() {
        return sex;
    }
    
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public String toString(){
        return String.format("%-10s | %-30s | %-10s | %-4s | %-6s | %35s", empID, empName,
                Utils.getDate(bDate), role, Utils.getSex(sex), pwd);
    }
}
