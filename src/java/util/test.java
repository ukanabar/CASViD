/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;



/**
 *
 * @author Utkarsh
 */
public class test {
    public static void main(String[] args){
      DbUtil du = new DbUtil();
        Connection connection = du.getConnection();
        System.out.print(connection);
    }
}
