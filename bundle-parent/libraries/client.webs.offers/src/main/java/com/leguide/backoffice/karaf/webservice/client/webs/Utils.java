package com.leguide.backoffice.karaf.webservice.client.webs;

public class Utils {

    public static boolean isAnInteger(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }




}
