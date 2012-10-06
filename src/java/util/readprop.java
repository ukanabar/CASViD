/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.io.*;
import java.util.*;

/**
 *
 * @author Utkarsh
 */
public class readprop {


        public static void main(String[] args) {
                Properties prop = new Properties();
                try {
                        prop.load(new FileInputStream("B:/Dropbox/Project/CASViDMVC/src/java/casvid/util/db.properties"));
                        String name = prop.getProperty("driver");
                        String address = prop.getProperty("url");
                        System.out.println("Name: " + name);
                        System.out.println("Address: " + address);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
}
    

