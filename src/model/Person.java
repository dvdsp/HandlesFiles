/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DELL
 */
public class Person implements Comparable<Person> {
    private String id;
    private String name;
    private String address;
    private double money;
    
    public Person() {
    }

    public Person(String id,String name, String address, double money) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.money = money;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getMoney() {
        return money;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    
    @Override
    public int compareTo(Person other) {
        return (int) (other.getMoney() - this.getMoney());
    }
 
}
