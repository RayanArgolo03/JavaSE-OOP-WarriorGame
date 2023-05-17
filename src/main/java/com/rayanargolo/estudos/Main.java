package com.rayanargolo.estudos;

import com.classes.Armor;
import com.classes.Player;
import com.classes.Warrior;
import com.classes.Weapon;
import java.util.ArrayList;
import java.util.Scanner;
import com.classes.Constants;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println(" ------- By Rayan Barbosa ------- \n");

        //Create Lists 
        ArrayList<Weapon> weapons = new ArrayList<>();
        Main.createWeapons(weapons);

        ArrayList<Armor> armors = new ArrayList<>();
        Main.createArmors(armors);

        //New Players and Warriors
        System.out.println("Digite o nome do jogador 1");
        String name = sc.next();

        Player playerOne = new Player();
        playerOne.setName(name);

        Warrior warriorOne = new Warrior("Levan", 10, 12, 20, 10);

        playerOne.setWarrior(warriorOne);

        System.out.println("Digite o nome do jogador 2");
        name = sc.next();

        Player playerTwo = new Player();
        playerTwo.setName(name);

        Warrior warriorTwo = new Warrior("Bolantsky", 30, 8, 35, 27);

        playerTwo.setWarrior(warriorTwo);

        //Verify Null Pointer Exception, If False Play the Game
        if (playerOne.getWarrior() != null && playerTwo.getWarrior() != null) {

            System.out.println("\n * Let's play the game!! *");
            System.out.println("--------- ---- ---- ----------");

            boolean isWin = false;
            int move = 1;

            while (!isWin) {

                //Current Player, Current Warrior and your Oponnent
                Player currentPlayer = (move % 2 != 0) ? playerOne : playerTwo;
                Warrior currentWarrior = currentPlayer.getWarrior();
                Warrior oponentWarrior = (currentPlayer == playerOne) ? playerTwo.getWarrior() : playerOne.getWarrior();

                System.out.println("\n Player " + currentPlayer.getName() + ": \n" + currentWarrior.toString());

                String printMenu = Main.printMenu();
                System.out.println(printMenu);

                System.out.print("Your move: ");
                int aux = sc.nextInt();

                //Verify valid Play
                while (!currentPlayer.check(aux)) {
                    System.out.println("Jogada inválida, jogue novamente: ");
                    aux = sc.nextInt();
                }

                //Case True: Options (Constants)
                switch (aux) {
                    case Constants.OPTION_TRAIN -> {
                        //Training - +10 Value in aletory atributte
                        currentWarrior.toTrain();
                    }

                    case Constants.OPTION_EQUIPARMOR -> {
                        // Print Armor
                        for (Armor armor : armors) {
                            System.out.println(armor.toString());
                        }

                        //Select Armor
                        System.out.println("\n Escolha sua opção de armadura: ");
                        int temp = sc.nextInt();

                        if (currentPlayer.check(temp)) {
                            currentWarrior.setArmor(armors.get(temp - 1));
                            System.out.println(currentWarrior.toString());
                        } else {
                            System.out.println("Digite valor de armadura válido!!!");
                        }
                    }
                    case Constants.OPTION_EQUIPWEAPON -> {
                        //Print Weapons
                        for (Weapon weapon : weapons) {
                            System.out.println(weapon.toString());
                        }

                        //Select Weapons
                        System.out.println("Qual arma deseja escolher? ");
                        int temp = sc.nextInt();

                        if (currentPlayer.check(temp)) {
                            currentWarrior.setWeapon(weapons.get(temp - 1));
                            System.out.println(currentWarrior.toString());
                        } else {
                            System.out.println("Digite valor de arma válido!!");
                        }
                    }

                    //Atack Oponent
                    case Constants.OPTION_ATACK -> {
                        currentWarrior.toAtack(oponentWarrior);

                    }
                }

                //Increment Move 
                move++;

                //Verify Winner
                if (oponentWarrior.getHealth() <= 0) {
                    System.out.println(oponentWarrior.getName() + " está sem vida," + currentPlayer.getName() + " venceu o jogo!!");
                }

            }
            //Null Pointer Exception
        } else {
            System.out.println("Jogador sem guerreiro!");
        }
    }

    //Static Print Menu
    public final static String printMenu() {
        return "\n 1 - Training your Warrior!! \n 2 - Equip Armor  \n 3 - Equip Weapon \n 4 - Atack!! \n";
    }

    //Static Create Weapons
    public final static ArrayList createWeapons(ArrayList<Weapon> weapons) {
        //Weapons - Metodo Equip Weapon
        Weapon weapon1 = new Weapon("Balarte", 40);
        Weapon weapon2 = new Weapon("Laking", 50);

        //List of Weapon´s
        weapons.add(weapon1);
        weapons.add(weapon2);

        return weapons;
    }

    //Static Create Armors
    public final static ArrayList createArmors(ArrayList<Armor> armors) {

        //Armors - Metodo Equip Armors
        Armor armor1 = new Armor("Saphire", 20);
        Armor armor2 = new Armor("Gullit", 20);

        //List of Armor´s
        armors.add(armor1);
        armors.add(armor2);

        return armors;

    }

}
