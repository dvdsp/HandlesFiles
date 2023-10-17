/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import model.Person;



/**
 *
 * @author DELL
 */
public class Library {
    
    public static ArrayList<Person> getListPerson(String pathFile) {     
        ArrayList<Person> personList = new ArrayList<>();
        File file = new File(pathFile);
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                personList.add(new Person(infoPerson[0], infoPerson[1], infoPerson[2], getSalary(infoPerson[3])));

            }
        } catch (IOException e) {
            System.err.println("Can't read file.");
        }
        return personList;
    }
    
    //display list person
    public static void printListPerson(ArrayList<Person> personList, double money) {
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID","Name", "Address", "Money");
        for (Person person : personList) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20s%-20.1f\n", person.getId(),person.getName(),
                        person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(personList);
        System.out.println("Max: " + personList.get(0).getName());
        System.out.println("Min: " + personList.get(personList.size() - 1).getName());
    }
    
    public static double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        } finally {
            return salaryResult;
        }
    }
    
    
    
    
    
    
    
    
    // case 2
     public  static String getNewContent(String pathFileInput) {
        HashSet<String> newContent = new HashSet<>();
        File file = new File(pathFileInput);
        try {
            Scanner input = new Scanner(file);
            int count = 0;
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word + " ");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can’t read file");
        }
        String content = "";
        for (String line : newContent) {
            content += line;
        }
        return content;
    }
    
    
    //write new content to file
    public static void writeNewContent(String pathFileOutput, String content) {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                //ignore
            }
        }
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(content);
            bufferWriter.close();
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                //ignore
            }
        }
    }
    
    
    
    //write new content to file
    public static boolean copyWordOneTimes(String source, String destination) {
    try {
        File sourceFile = new File(source);
        FileReader fileReader = new FileReader(sourceFile);
        BufferedWriter bufferedWriter;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            File destFile = new File(destination);
            FileWriter fileWriter = new FileWriter(destFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            HashSet<String> uniqueWords = new HashSet<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(";");
                for (String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                        bufferedWriter.write(word + " ");
                    }
                }
            }
        }
        bufferedWriter.close();

        return true;
    } catch (IOException e) {
        return false;
    }
}

    
}