/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import dto.Asset;
import dto.Employee;
import dto.Request;
import encode.Encrypt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.StringTokenizer;
import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class requestList extends ArrayList<Request>{
     protected ArrayList<Employee> empList;
    protected ArrayList<Asset> assetList;
    private Date currentDate = new Date();
    private Employee account;
    
    public requestList() {
        super();
        this.empList = new ArrayList<>();
        this.assetList = new ArrayList<>();
    }
    
    private void tagList(String nameList){
        if(nameList.equals("requestR")){
            System.out.println("___________________________________________________________________"
                    + "____________________________________________________________"
                    + "_________________");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %20s | %20s | %20s\n",
                    "ID","assetID","employeeID","MaxQuan","ReqQuan","CurQuan","requestDateTime",
                    "borrowDateTime","returnDateTime");
            System.out.println("-------------------------------------------------------------------"
                    + "-----------------------------------------------------------------------------");
        }
        else if(nameList.equals("requestB")){
            System.out.println("___________________________________________________________________"
                    + "_____________________________________________________________________________");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %20s | %20s | %20s\n",
                    "ID","assetID","employeeID","MaxQuan","BorrowQuan","CurQuan","requestDateTime",
                    "borrowDateTime","returnDateTime");
            System.out.println("-------------------------------------------------------------------"
                    + "-----------------------------------------------------------------------------");
        }
        else if(nameList.equals("asset")){
            System.out.println("________________________________________________________________"
                    + "_________________________________");
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %10s| %10s\n",
                    "assetID","name","color","price","weight","quantity","curQuan");
            System.out.println("----------------------------------------------------------------"
                    + "---------------------------------");
        }
        else if(nameList.equals("employee")){
            System.out.println("__________________________________________________________________"
                    + "_____________________________________________");
            System.out.printf("%-10s | %-30s | %-10s | %-4s | %-6s | %35s\n",
                    "employID","name","birthday","role","sex","password");
            System.out.println("----------------------------------------------------------------"
                    + "-----------------------------------------------");
        }
    }

    private void writeAsset(String fileName){
        assetList.add(new Asset("A011", "Laptop", "Black", 1500, 1.7, 6,6));
        assetList.add(new Asset("A012", "Mouse", "Silver", 200, 0.05, 12,12));
        assetList.add(new Asset("A013", "Chair", "White", 100, 2, 50,50));
        assetList.add(new Asset("A014", "Book", "Blue", 50, 0.03, 20,14));
        assetList.add(new Asset("A015", "Soundbar", "Black", 750, 1.5, 14,12));
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("________________________________________________________________"
                    + "_________________________________");
            pw.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %10s| %10s\n",
                    "assetID","name","color","price","weight","quantity","curQuan");
            pw.println("----------------------------------------------------------------"
                    + "---------------------------------");
            for (Asset a : assetList) {
                pw.println(a);
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Write file unsuccessfully");
        }
    }
    
    private void writeEmployee(String fileName){
        empList.add(new Employee("E001", "Pham Quang Van", Utils.getDateFromString("02/02/2001"),
                "MA", true, Encrypt.getHexaDigest("MD5", "ngan123")));
        empList.add(new Employee("E002", "Nguyen Tung", Utils.getDateFromString("06/12/2002"),
                "EM", true, Encrypt.getHexaDigest("MD5", "123ngan")));
        empList.add(new Employee("E003", "Tran Van A", Utils.getDateFromString("13/06/1947"),
                "MA", true, Encrypt.getHexaDigest("MD5", "12345678")));
        empList.add(new Employee("E004", "Bui Van Ba", Utils.getDateFromString("04/04/1973"),
                "EM", false, Encrypt.getHexaDigest("MD5", "000000")));
        empList.add(new Employee("E005", "Nguyen Chi Lam", Utils.getDateFromString("11/04/2002"),
                "EM", true, Encrypt.getHexaDigest("MD5", "Ngan0000")));
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("__________________________________________________________________"
                    + "_____________________________________________");
            pw.printf("%-10s | %-30s | %-10s | %-4s | %-6s | %35s\n",
                    "employID","name","birthday","role","sex","password");
            pw.println("----------------------------------------------------------------"
                    + "-----------------------------------------------");
            for (Employee e : empList) {
                pw.println(e);
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Write file unsuccessfully");
        }
    }
    
    private void writeRequest(String fileName){
        this.add(new Request("R001", searchEmployeeByID("E001"), searchAssetByID("A011"),3,
                Utils.getDateTimeFromString("17-10-2021 13:17:56"), null, null));
        this.add(new Request("R003", searchEmployeeByID("E004"), searchAssetByID("A013"),5,
                Utils.getDateTimeFromString("27-03-2021 15:37:22"), null, null));
        this.add(new Request("B002", searchEmployeeByID("E003"), searchAssetByID("A015"),2,
                Utils.getDateTimeFromString("04-05-2021 23:00:35"),Utils.getDateTimeFromString("12-05-2021 08:08:08"), null));
        this.add(new Request("B005", searchEmployeeByID("E002"), searchAssetByID("A014"),6,
                Utils.getDateTimeFromString("23-12-2021 12:18:56"),Utils.getDateTimeFromString("24-12-2021 07:23:18"), null));
        this.add(new Request("R004", searchEmployeeByID("E005"), searchAssetByID("A012"),3,
                Utils.getDateTimeFromString("17-10-2021 07:34:12"), null, null));
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println( "___________________________________________________________________"
                    + "_____________________________________________________________________________");
            pw.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %20s | %20s | %20s\n",
                    "ID","assetID","employeeID","MaxQuan","Req/BorQuan","CurQuan","requestDateTime",
                    "borrowDateTime","returnDateTime");
            pw.println("-------------------------------------------------------------------"
                    + "-----------------------------------------------------------------------------");
            for (Request r : this) {
                pw.println(r);
            }
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("Write file unsuccessfully");
        }
    }   
    
    private void writeEmptyFile(String fName){
        if(fName.equals("asset.txt")){
                writeAsset(fName);
        }
        else if(fName.equals("employee.txt")){
                writeEmployee(fName);
        }
        else if(fName.equals("assetMng.txt")){
            System.out.println("");
                writeRequest(fName);
        }
    }
    
    public void loadFromFile(String fName){
        try {
            File f = new File(fName);
            if(!f.exists()) return;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String details;
            if(br.readLine()==null) {
                writeEmptyFile(fName);
                for(int i=0; i<3;i++) details = br.readLine();
            } else {
                for(int i=0; i<2;i++) details = br.readLine();
                while ((details = br.readLine())!=null) {
                    StringTokenizer stk = new StringTokenizer(details,"|");
                    if(fName.equals("asset.txt")){
                        String aID = stk.nextToken().trim();
                        String aName = stk.nextToken().trim();
                        String aColor = stk.nextToken().trim();
                        int price = Integer.parseInt(stk.nextToken().trim());
                        double weight = Double.parseDouble(stk.nextToken().trim().replace(",", "."));
                        int quantity = Integer.parseInt(stk.nextToken().trim());
                        int curQuan = Integer.parseInt(stk.nextToken().trim());
                        Asset a = new Asset(aID, aName, aColor, price, weight, quantity, curQuan);
                        assetList.add(a);
                    }else if(fName.equals("employee.txt")){
                        String empID = stk.nextToken().trim();
                        String empName = stk.nextToken().trim();
                        Date bDate = Utils.getDateFromString(stk.nextToken().trim());
                        String role = stk.nextToken().trim();
                        boolean sex = Utils.setSex(stk.nextToken().trim());
                        String pwd = stk.nextToken().trim();
                        Employee e = new Employee(empID, empName, bDate, role, sex, pwd);
                        empList.add(e);
                    }else if(fName.equals("assetMng.txt")){
                        String rbID = stk.nextToken().trim();
                        String aID = stk.nextToken().trim();
                        String eID = stk.nextToken().trim();
                        int maxQty = Integer.parseInt(stk.nextToken().trim());
                        int rQty = Integer.parseInt(stk.nextToken().trim());
                        int curQty = Integer.parseInt(stk.nextToken().trim());
                        Date rDate = Utils.getDateTimeFromString(stk.nextToken().trim());
                        Date bDate = Utils.getDateTimeFromString(stk.nextToken().trim());
                        Date returnDate = Utils.getDateTimeFromString(stk.nextToken().trim());
                        Request r = new Request(rbID, searchEmployeeByID(eID), searchAssetByID(aID)
                                , rQty, rDate, bDate, returnDate);
                        this.add(r);
                    }
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveToFile(String fName){
        if(this.isEmpty()){
            System.out.println("Empty list.");
            return;
        }
        try {   
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            if(fName.equals("asset.txt")){
                pw.println("________________________________________________________________"
                    + "_________________________________");
                pw.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %10s| %10s\n",
                    "assetID","name","color","price","weight","quantity","curQuan");
                pw.println("----------------------------------------------------------------"
                    + "---------------------------------");
                for (Asset v : assetList)
                    pw.println(v);
            }
            if(fName.equals("employee.txt")){
                pw.println("__________________________________________________________________"
                    + "_____________________________________________");
                pw.printf("%-10s | %-30s | %-10s | %-4s | %-6s | %35s\n",
                    "employID","name","birthday","role","sex","password");
                pw.println("----------------------------------------------------------------"
                    + "-----------------------------------------------");
                for (Employee e : empList)
                    pw.println(e);
            }
            if(fName.equals("assetMng.txt")){
                pw.println( "___________________________________________________________________"
                    + "_____________________________________________________________________________");
                pw.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %20s | %20s | %20s\n",
                    "ID","assetID","employeeID","MaxQuan","Req/BorQuan","CurQuan","requestDateTime",
                    "borrowDateTime","returnDateTime");
                pw.println("-------------------------------------------------------------------"
                    + "-----------------------------------------------------------------------------");
                for (Request r : this) 
                    pw.println(r);
            }
            pw.close();
            fw.close();
        } catch (Exception e){
            System.out.println(e);
        }
        System.out.println();
    }
    
    //***login <thêm chức năng đăng nhập lại>
    private void login(){
        String reEID = Utils.getString("Input employeeID: ");
        String rePw = Utils.getString("Password: ");
        account = searchEmployeeByID(reEID);
        if(account!=null){
            if (account.getPwd().equals(Encrypt.getHexaDigest("MD5", rePw))){   
                System.out.println("***Successfully.***");
            } else {
                System.out.println("!!! Incorrect id or password !!!");
                account=null;
            }
        } else {
            System.out.println("!!! Incorrect id or password !!!");
        }
    }
    
    public void loginAccount(){
        if(account==null) login();
        else{
            System.out.println("You logined account " + account.getEmpID());
            if(Utils.confirmYesNo("Do you want to login other account? "))
                login();
            else System.out.println("Your account: " + account.getEmpID());
        }
        System.out.println("___________________\n");
    }
    
    //search by id to return employee
    public Employee searchEmployeeByID(String sID){
        for (Employee emp : empList) 
            if(emp.getEmpID().equalsIgnoreCase(sID))
                return emp;
        return null;
    }
    
    //***search asset by name
    public void searchAssetBySubName(String subName){
        if(assetList.isEmpty()){
            System.out.println("!!! Empty list.");
            System.out.println("___________________\n");
            return;
        }
        ArrayList<Asset> aList = new ArrayList<>();
        for (Asset a : assetList){
            if(a.getAssetName().toLowerCase().indexOf(subName.toLowerCase())>=0){
                aList.add(a);
            }
        }
        if(aList.isEmpty()) {
            System.out.println("!!! No results.");
            System.out.println("___________________\n");
        }
        else{
            Collections.sort(aList);
            tagList("asset");
            for (Asset a : aList)
                System.out.println(a);
            System.out.println("\n****Result with \" " + subName +" \" has been showed****");
            System.out.println("___________________\n");
        }
    }
    
    
    private Asset searchAssetByID(String sID){
        for (Asset a : assetList) 
            if(a.getAssetID().equalsIgnoreCase(sID))
                return a; 
        return null;
    }
    
    
    public Request searchRequestByID(String sID){
        for (Request r : this) {
            if(r.getrbID().equalsIgnoreCase(sID))
                return r;
        }
        return null;
    }
    
    //create a asset
    private void addAAsset(){
        String aID;
        String aName;
        String aColor;
        int price;
        double weight;
        int quantity;
        do{
            aID = Utils.getString("Input ID: ").toUpperCase();
            if(searchAssetByID(aID)!=null)
                System.out.println("!!! ID Asset is duplicated !!!");
        }while(searchAssetByID(aID)!=null);
        aName = Utils.getString("Input name: ");
        aColor = Utils.getString("Input color: ");
        price = Utils.getInt("Input price: ", 0);
        weight = Utils.getDouble("Input weight: ", 0);
        quantity = Utils.getInt("Input quantity: ", 0);
        Asset a = new Asset(aID, aName, aColor, price, weight, quantity, quantity);
        assetList.add(a);
    }
    
    //Create new asset
    public void addAsset(){
        if(account==null||!account.getRole().equals("MA")){
            System.out.println("!!! You need to LOGIN MANAGER to do this function!!!");
            System.out.println("___________________\n");
            return;
        }
        do{
                addAAsset();
            }while(Utils.confirmYesNo("??? Do you want to continue adding? (Y/N): "));
            saveToFile("asset.txt");
            System.out.println();
    }
    
    
    public void updateAsset(){
        String uID;
        String uName;
        String uColor;
        int price;
        double weight;
        int oldQuan;
        int quantity;
        if(account==null||!account.getRole().equals("MA")){
            System.out.println("You need to LOGIN MANAGER to do this function!!!");
            System.out.println("___________________\n");
            return;
        }
        uID = Utils.getString("Input ID: ", "A000", "^A\\d{3}$");
        Asset a = searchAssetByID(uID);
        if(a==null) System.out.println("Asset does not exist.\n");
        else{
            System.out.print("Old name: " + a.getAssetName() +" .  ");
            uName = Utils.updateString("Enter new name: ", a.getAssetName());
            a.setAssetName(uName);
            System.out.print("Old color: " + a.getColor() + " .  ");
            uColor = Utils.updateString("Enter new color: ", a.getColor());
            a.setColor(uColor);
            System.out.print("Old price: " + a.getPrice() + " .  ");
            price = Utils.updateInt("Enter new price: ", 0, a.getPrice());
            a.setPrice(price);
            System.out.print("Old weight: " + a.getWeight() + " .  ");
            weight = Utils.updateDouble("Enter new weight: ",0, a.getWeight());
            a.setWeight(weight);
            oldQuan = a.getQuantity();
            System.out.print("Old quantity: " + oldQuan + " .  ");
            quantity = Utils.updateInt("Enter new quantity: ", 0, oldQuan);
            a.setQuantity(quantity);
            a.setCurQuantity(a.getCurQuantity()+a.getQuantity()-oldQuan);
            System.out.println("***Updated: " + a.getAssetID()+", "+a.getAssetName()+", "+
                    a.getColor()+", "+a.getPrice()+", "+a.getWeight()+", "+a.getQuantity()+", "+a.getCurQuantity());
            System.out.println("***Update successfully***");
            System.out.println("___________________\n");
        }
    }
    
   
    public void listBorrow(){
        if(account==null||!account.getRole().equals("MA")){
            System.out.println("You need to LOGIN MANAGER to do this function!!!");
            System.out.println("___________________\n");
            return;
        }
        tagList("requestB");
        for (Request r : this) {
            if (r.getrbID().contains("B")) {
                System.out.println(r);
            }
        }
        System.out.println("___________________\n");
        System.out.println("");
    }
    
    //show list request to support approve function
    private void listRequest(){
        tagList("requestR");
        for (Request r : this) {
            if (r.getrbID().matches("^R\\d{3}$"))
                System.out.println(r);
        }
        System.out.println("___________________\n");
    }
    
    private void listAsset(){
        tagList("asset");
        for (Asset a : assetList) {
            System.out.println(a);
        }
    }
    
    
    public void approveRequest(){
        if(account==null||!account.getRole().equals("MA")){
            System.out.println("You need to LOGIN MANAGER to do this function!!!\n");
            return;
        }
        listRequest();
        String rID = Utils.getString("Input request ID to approve: ", "R000", "^R\\d{3}$");
        Request rb = searchRequestByID(rID);
        if(rb==null){
            System.out.println("Request does NOT exist!!!");
            System.out.println("___________________\n");
            return;
        }
        Asset ab = searchAssetByID(rb.getAsset().getAssetID());
        if(ab==null){
            System.out.println("Asset does NOT exist!!!");
            System.out.println("___________________\n");
            return;
        }
        if(!checkStock(rb.getrQuantity(), ab.getCurQuantity())){
            System.out.println("ERROR!!! Quantity does not enough to approve.");
            System.out.println("___________________\n");
            return;
        } 
        rb.setrbID("B"+rb.getrbID().substring(1));
        rb.setbDate(currentDate);
        ab.setCurQuantity(ab.getCurQuantity()-rb.getrQuantity());
        System.out.println("Request is approved.");
        System.out.println("___________________\n");
    }
    
    private boolean checkStock(int reqQuan, int curQuan){
        if(reqQuan>curQuan) return false;
        return true;
    }
    
    public void sendRequest(){
        String rbID;
        Employee emp;
        Asset asset;
        int rQuantity;
        Date rDate;
        Date bDate;
        Date returnDate;
        boolean duplicate, valid;
        if(account==null){
            System.out.println("You need to LOGIN to do this function!!!");
            System.out.println("___________________\n");
            return;
        }
        do{
            rbID = Utils.getString("Input request ID: ", "R000", "^R\\d{3}$");
            if(searchRequestByID(rbID)!=null) {
                duplicate = true;
                System.out.println("!!! Your request ID existed");
            }
            else duplicate = false;
        }while (duplicate);
        emp = account;
        do {
            listAsset();
            asset = searchAssetByID(Utils.getString("Input asset ID: ", "A000", "^A\\d{3}$"));
            if(asset==null) {
                duplicate = false;
                System.out.println("!!! This asset does not exist.");
            }else duplicate = true;
        } while (!duplicate);
        do{
            rQuantity = Utils.getInt("Input quantity to request: ", 0);
            if(rQuantity>asset.getCurQuantity()){
                System.out.println("!!! Not enought. Remain: " + asset.getCurQuantity());
                valid = false;
            } else valid = true;
        }while(!valid);
        rDate = currentDate;
        bDate = null;
        returnDate = null;
        this.add(new Request(rbID, emp, asset, rQuantity, rDate, bDate, returnDate));
        System.out.println("*** Sent request successfully ***");
        System.out.println("___________________\n");
    }
    
    public void returnAsset(){
        if(account==null){
            System.out.println("You need to LOGIN to do this function!!!");
            System.out.println("___________________\n");
            return;
        }
        System.out.println("List your borrow: ");
        for (Request r : this) {
            if(r.getEmp().getEmpID().equals(account.getEmpID())&&r.getEmp().getEmpID().matches("^B\\d{3}$"))
                System.out.println(r);
        }
        String bID = Utils.getString("Input borrowed ID: ", "B000", "^B\\d{3}$");
        Request b = searchRequestByID(bID);
        if(b==null) {
            System.out.println("Your borrowed ID does not exist.");
            System.out.println("___________________\n");
            return;
        }
        if(b.getEmp()!=account){
            System.out.println("You are not employee to do this action.");
            System.out.println("___________________\n");
            return;
        }
        Asset a = b.getAsset();
        a.setCurQuantity(a.getCurQuantity()+b.getrQuantity());
        b.setReturnDate(currentDate);
        b.setrbID(bID+"(Done)");
        System.out.println("Returned.");
        System.out.println("___________________\n");
    }
    
    public void deleteAsset(){
        if(account==null||!account.getRole().equals("MA")){
            System.out.println("You need to LOGIN MANAGER to do this function!!!\n");
            return;
        }
        String reAID = Utils.getString("Input asset ID to remove: ");
        Asset a = searchAssetByID(reAID);
        if(a==null) System.out.println("Asset does not exist");
        else {
            assetList.remove(a);
        }
        System.out.println("___________________\n");
    }
}
