package com.classes;

import java.util.ArrayList;

import java.util.Random;

public class Warrior {

    private String name;
    private int strong;
    private int velocity;
    private int health;
    private int defense;
    private Armor armor;
    private Weapon weapon;

    //Constructor Warrior
    public Warrior(String name, int strong, int velocity, int health, int defense
    ) {
        this.name = name;
        this.strong = strong;
        this.velocity = velocity;
        this.health = health;
        this.defense = defense;

    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrong() {
        return strong;
    }

    public void setStrong(int strong) {
        this.strong = strong;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    //getRandomNumber
    private int getRandomNumber() {
        //Aumentar atributo aleatóriamente
        Random random = new Random();
        int aux = random.nextInt(4) + 1;

        return aux;
    }

    //toTrain
    public void toTrain() {
        //Get Random Number and Increment
        int aux = getRandomNumber();
        int increment = 10;

        //Verify Aux Value
        switch (aux) {
            case 1:
                this.strong += increment;
                System.out.println("Ganhou " + increment + " de Strong");
                break;

            case 2:
                this.health += increment;
                System.out.println("Ganhou " + increment + " de Health");
                break;

            case 3:
                this.velocity += increment;
                System.out.println("Ganhou " + increment + " de Velocity");
                break;

            case 4:
                this.defense += increment;
                System.out.println("Ganhou " + increment + " de Defense");
                break;
        }

    }

    //toAtack
    public void toAtack(Warrior warrior) {
        //Verify Weapon != Null
        boolean validWeapon = (this.weapon != null);

        //Health and Damager
        int atackDamage = 0;
        int aux = this.health;

        //Verify Value AtackDamage
        atackDamage = validWeapon ? (this.strong / 2) + this.weapon.getDamage() : (this.strong / 2);
        aux -= atackDamage;

        //Print Atack Information
        if (validWeapon) {
            System.out.println("Boom! " + atackDamage + " de dano com a " + this.weapon.getName());
        } else {
            System.out.println("Deu-lhe um soco de " + atackDamage + " de Strong!!");
        }

    }

    //to String Warrior
    @Override
    public String toString() {
        boolean validArmor = false;
        boolean validWeapon = false;

        String s = "";

        s += "\n Warrior: " + this.name + "\n"
                + "Atributos: " + "strong: "
                + this.strong
                + ", velocity: "
                + this.velocity
                + ", health: "
                + this.health
                + ", defense: "
                + this.defense + "\n";
        
        s += (validArmor) ? this.armor.toString() + "\n" : "Armor: Não \n";
        s += (validWeapon) ? this.weapon.toString() : "Weapon: Não \n";

        return s;
    }

}
