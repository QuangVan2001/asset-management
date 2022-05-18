package main;


import java.util.Scanner;
import management.Menu;
import management.requestList;
import utils.Utils;

public class AssetManagement {
    public static void main(String[] args) {
        String fAName = "asset.txt";
        String fEName = "employee.txt";
        String fMngName = "assetMng.txt";
        Menu menu = new Menu();
        menu.add("Login"); // emp 
        menu.add("Search asset by name"); //emp
        menu.add("Create new asset"); //mng
        menu.add("Updating asset's information"); //mng
        menu.add("Approve the request of employee"); //mng
        menu.add("Show list of borrow asset"); //mng
        menu.add("Request to borrow"); //emp
        menu.add("Return asset"); //emp
        menu.add("Delete asset."); //mng
        menu.add("Others-Quit");
                
        int choice;
        boolean cont = false;
        requestList rList = new requestList();
        rList.loadFromFile(fAName);
        rList.loadFromFile(fEName);
        rList.loadFromFile(fMngName);
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    rList.loginAccount();
                    break;
                case 2:
                    rList.searchAssetBySubName(Utils.getString("Input name: "));
                    break;
                case 3:
                    rList.addAsset();
                    cont = true;
                    break;
                case 4:
                    rList.updateAsset();
                    cont = true;
                    break;
                case 5:
                    rList.approveRequest();
                    cont = true;
                    break;
                case 6:    
                    rList.listBorrow();
                    break;
                case 7:
                    rList.sendRequest();
                    cont = true;
                    break;
                case 8:
                    rList.returnAsset();
                    cont = true;
                    break;
                case 9:
                    rList.deleteAsset();
                    cont = true;
                    break;
                case 10:
                    if(cont){
                        if(menu.confirmYesNo("Save changes Y/N? ")){
                            rList.saveToFile(fAName);
                            rList.saveToFile(fEName);
                            rList.saveToFile(fMngName);
                        }
                        else System.out.println("Not saved.");
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid");
                    break;
            }
        } while ( true);
    }
}
