package com.classes;

public class Weapon {

    private String name;
    private int damage;

    //Inherit Equipament
    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    //toString Weapon 
    @Override
    public String toString() {
        String s = "";
        s += "Weapon: " + this.name + " - Damage" + this.damage + "\n";
        return s;
    }

}
