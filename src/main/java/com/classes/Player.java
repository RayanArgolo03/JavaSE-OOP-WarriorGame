package com.classes;

public class Player {

    private String name;
    private Warrior warrior;

    //Constructor Default
    public Player() {
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Warrior getWarrior() {
        return warrior;
    }

    public void setWarrior(Warrior warrior) {
        this.warrior = warrior;
    }

    //toCheck
    public boolean check(int aux) {
        
        if (aux == 0) {
            return false;
        }

        int[] values = (aux > 2) ? new int[]{1, 2, 3, 4} : new int[]{1, 2};

        for (int value : values) {
            if (aux == value) {
                return true;
            }
        }
        return false;
    }

}
