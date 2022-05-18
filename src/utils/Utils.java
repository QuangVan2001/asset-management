/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author QUANG VAN
 */
public class Utils {
    //get String 
    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }
    
    //update string
    public static String updateString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine().trim();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }
    
    //get string with pattern
    public static String getString(String welcome, String pattern, String cPattern){
        boolean check = true;
        String result = "";
        boolean valid;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine().trim().toUpperCase();
            valid = result.matches(cPattern);
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            }else if(!valid){
                System.out.println("!!!Pattern: " + pattern);
            }else {
                check = false;
            }
        } while (check||!valid);
        return result;
    }
    
    //get int with max and min
    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
                if(number > max || number < min) System.out.println("Input number from "+min+" to "+max+"!!!");
            } catch (Exception e) {
                System.out.println("Input integer number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }
    
    public static int getInt(String welcome, int min) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
                if(number < min) System.out.println("Input number greater than or equal "+min + " !!!");
            } catch (Exception e) {
                System.out.println("Input integer number!!!");
            }
        } while (check || number < min);
        return number;
    }
    
    public static int updateInt(String welcome, int min, int oldData) {
        boolean check = true;
        int number = min-1;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.trim().isEmpty()) {
                    check = false;
                    number = oldData;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                    if(number < min) System.out.println("Input number greater than or equal "+min + " !!!");
                }
            } catch (Exception e) {
                System.out.println("Input integer number!!!");
            }
        } while (check || number < min);
        return number;
    }
    
    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Utils.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }
    
    public static boolean updateConfirm(String welcome, boolean oldData) {
        boolean result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine().trim();
        if (!tmp.isEmpty()) {
            if ("Y".equalsIgnoreCase(tmp)) {
                result = true;
            }else result = false;
        }
        return result;
    }
    
    public static double getDouble(String welcome, double min) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
                if(number < min) System.out.println("Input number greater than or equal "+min + " !!!");
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < min);
        return number;
    }
    
    public static double updateDouble(String welcome, double min, double oldData) {
        boolean check = true;
        double number = -1;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine().trim();
                if (tmp.isEmpty()) {
                    check = false;
                    number = oldData;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                    if(number < min) System.out.println("Input number greater than or equal "+min + " !!!");
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while ( check || number < min);
        return number;
    }
    
    //get string from string
    public static Date getDateTimeFromString(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(date==null||date.equals("null")) return null;
        Date d = null;
        try{
            d = sdf.parse(date);
        } catch (ParseException ex){
            System.out.println(ex.getMessage());
        }
        return d;
    }
    
    //get string from date
    public static String getDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(date==null) return null;
        return sdf.format(date);
    }
        
    public static Date getDateFromString(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(date==null||date.equals("null")) return null;
        Date d = null;
        try{
            d = sdf.parse(date);
        } catch (ParseException ex){
            System.out.println(ex.getMessage());
        }
        return d;
    }
    
    public static String getDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if(date==null) return null;
        return sdf.format(date);
    }
    
    public static boolean setSex(String sex){
        if(sex.equals("male")) return true;
        return false;
    }
    
    public static String getSex(boolean sex){
        if(sex) return "male";
        return "female";
    }
}
