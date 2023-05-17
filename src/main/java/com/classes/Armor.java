package com.classes;

public class Armor {

    private String name;
    private int defense;

    //Construtor Armor
    public Armor(String name, int defense) {
        this.name = name;
        this.defense = defense;

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    //toString Weapon
    @Override
    public String toString() {
        String s = "";
        s += "Armor: " + this.name + " - Defense " + this.defense;

        return s;
    }

}
