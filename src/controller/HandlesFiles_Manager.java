/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;



import Repository.HandlesFilesRepository;
import Repository.Interfaces_HandlesFilesRepository;
import view.Menu;

/**
 *
 * @author DELL
 */
public class HandlesFiles_Manager extends Menu<String> {
    static String[] mc = {"Find person information", 
                            "Copy text to a new File",
                            "exit"};
    protected Interfaces_HandlesFilesRepository repo;

    public HandlesFiles_Manager() {
        super("\n\tFILE PROCESSING", mc);
        repo = new HandlesFilesRepository();    
      
    }
    
    @Override
    public void execute(int n) {
        switch(n) {
            case 1-> repo.find();
            case 2-> repo.copy();
            case 3-> System.exit(0);      
        }
    }
    
    
}
