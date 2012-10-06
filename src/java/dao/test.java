/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import model.Sla;


/**
 *
 * @author Utkarsh
 */
public class test {
    public static void main(String[] args){
      
        SlaDao sdo = new SlaDao();
        List<Sla> allSlas = sdo.getAllSlas();
        System.out.print(allSlas);
    }
}
