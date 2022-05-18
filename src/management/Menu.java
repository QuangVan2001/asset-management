/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package management;

import java.util.ArrayList;
import utils.Utils;

/**
 *
 * @author QUANG VAN
 */
public class Menu extends ArrayList<String>{
    public Menu() {
        super();
    }
    
    public void addItem(String s) {
        this.add(s);
    }

    public void showMenu() {
        for (int i = 0; i < this.size(); i++)
            System.out.println((i+1)+"-"+this.get(i));
    }

    public boolean confirmYesNo(String welcome) {
        boolean result= false;
        result= Utils.confirmYesNo(welcome);
        return result;
    }

    public int getChoice() {
        int choice = Utils.getInt("Choose 1.."+this.size()+": ", 1, this.size());
        System.out.println("----------------------");
        return choice;
    }
}
