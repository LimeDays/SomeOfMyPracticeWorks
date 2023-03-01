package org.itstep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cycleChoose = 0;
        CoffeeMachine coffeeMachine = new CoffeeMachine(2000, 2000, 500);
	do {
		coffeeMachine.printStatus();
		System.out.println();
		System.out.println("1 - Espresso/ 2 - Americano/ 3 - Latte / 4 - Cappuchino");
		int choose = scanner.nextInt();
		if (choose == 3 || choose == 4) {
			coffeeMachine.inputMilk();
		}
		coffeeMachine.buyCoffee(choose);
		System.out.println();
		coffeeMachine.printStatus();
		System.out.println("\nStorage Of Used Beans - " + coffeeMachine.getStorageOfUsedBeans());

		System.out.println();
		System.out.println();
		System.out.println();

		System.out.println("Wanna Refill CoffeeMachine? 1 - Yes/ 2 - No");
		int refillChoose = scanner.nextInt();
		if(refillChoose == 1) {
			System.out.println("Enter Amount Of Water - ");
			int water = scanner.nextInt();
			System.out.println("Enter Amount Of Milk - ");
			int milk = scanner.nextInt();
			System.out.println("Enter Amount Of Beans - ");
			int beans = scanner.nextInt();
			coffeeMachine.fillMachine(water, milk, beans);
		}
		System.out.println("Exit - 2");
		cycleChoose = scanner.nextInt();
	} while (cycleChoose == 1);
    }
}


class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int milkInput;
    private int storageOfUsedBeans;

    public CoffeeMachine(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
    }

    public void buyCoffee(int type) {
        Scanner scanner = new Scanner(System.in);
        int waterForCoffee, milkForCoffee, beansForCoffee;
        switch (type) {
            case 1:
                System.out.println("Making Espresso...");
                waterForCoffee = 30;
                milkForCoffee = 0;
                beansForCoffee = 22;
                break;
            case 2:
                System.out.println("Making Americano...");
                waterForCoffee = 100;
                milkForCoffee = 0;
                beansForCoffee = 22;
                break;
            case 3:
                System.out.println("Making Latte...");
                waterForCoffee = 30;
                milkForCoffee = milkInput;
                beansForCoffee = 22;
                break;
            case 4:
                System.out.println("Making Cappuccino...");
                waterForCoffee = 30;
                milkForCoffee = milkInput;
                beansForCoffee = 22;
                break;
            default:
                System.out.println("Invalid coffee type.");
                return;
        }
        if (water < waterForCoffee) {
            System.out.println("Not enough water.");
        } else if (milk < milkForCoffee) {
            System.out.println("Not enough milk.");
        } else if (coffeeBeans < beansForCoffee) {
            System.out.println("Not enough coffee beans.");
        } else {
            water -= waterForCoffee;
            milk -= milkForCoffee;
            coffeeBeans -= beansForCoffee;
            storageOfUsedBeans += beansForCoffee;
            if(storageOfUsedBeans > 200){
                int choose;
                System.out.println("Please Clear Storage Of Used Beans - 1 - Yes");
                choose = scanner.nextInt();
                if(choose == 1){
                    storageOfUsedBeans = 0;
                }
                else {
                    System.out.println("Please Press 1");
                }
            }
        }
    }

    public void fillMachine(int waterToAdd, int milkToAdd, int beansToAdd) {
        water += waterToAdd;
        milk += milkToAdd;
        coffeeBeans += beansToAdd;
    }

    public void inputMilk() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount of milk for ur coffee - ");
        milkInput = scanner.nextInt();
    }

    public int getStorageOfUsedBeans() {
        return storageOfUsedBeans;
    }
}