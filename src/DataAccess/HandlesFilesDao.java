/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import common.Library;
import common.Valid;
import java.util.ArrayList;
import model.Person;

/**
 *
 * @author DELL
 */
public class  HandlesFilesDao{
    
    private static HandlesFilesDao instance = null;
    public static HandlesFilesDao Instance() {
        if(instance == null) {
            synchronized (HandlesFilesDao.class) {
                if (instance == null) {
                    instance = new HandlesFilesDao();
                }
            }
        }
        return instance;
    }
    // case 1
    public void findPersonInfo() {
        System.out.println("------- Person Info -------");
        ArrayList<Person> personList;
        
        String pathFile = Valid.checkInputPathFile();
        personList = Library.getListPerson(pathFile);

        if (personList == null) {
            return;
        }
        double money = Valid.checkInputMoney();
        Library.printListPerson(personList, money);
    }
   
    //case 2
    public void coppyNewFile() {

        System.out.println("------- Copy Text -----------");
        System.out.print("Enter Source: ");
        String pathFileInput = Valid.checkInputPathFile();
        System.out.print("Enter new file name: ");
        String pathFileOutput = Valid.checkInputPathFile();

        try {
            if (Library.copyWordOneTimes(pathFileInput, pathFileOutput)) {
                System.out.println("Copy done...");
            } else {
                System.err.println("Copy failed.");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    
    
   


}
