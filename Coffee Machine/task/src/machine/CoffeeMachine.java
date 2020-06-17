package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        determineAction();
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static int waterAmountMachine = 400;
    private static int milkAmountMachine = 540;
    private static int coffeeBeansAmountMachine = 120;
    private static int disposableCupsAmountMachine = 9;
    private static int moneyAmountMachine = 550;

    private static void determineAction() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
        String action = scanner.next();
        switch (action) {
            case "buy":
                buy();
            case "fill":
                fill();
            case "take":
                take();
            case "remaining":
                printMachineContent();
            case "exit":
                System.exit(0);
        }
    }

    private static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte 3 - cappuccino, back - to main menu:");
        String buyMenu = scanner.next();
        switch (buyMenu) {
            case "1":
                if (hasEnoughResources("espresso")) {
                    prepareEspresso();
                }
                determineAction();
            case "2":
                if (hasEnoughResources("latte")) {
                    prepareLatte();
                }
                determineAction();

            case "3":
                if (hasEnoughResources("cappuccino")) {
                    prepareCappuccino();
                }
                determineAction();
            case "back":
                determineAction();
        }
    }

    private static boolean hasEnoughResources(String coffeeType) {
        if (disposableCupsAmountMachine >= 1) {
            switch (coffeeType) {
                case "espresso":
                    if (waterAmountMachine >= 250) {
                        if (coffeeBeansAmountMachine >= 16) {
                            System.out.println("I have enough resources, making you a coffee!");
                            return true;
                        } else {
                            System.out.println("Sorry, not enough coffee beans!");
                            return false;
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                        return false;
                    }

                case "latte":
                    if (waterAmountMachine >= 350) {
                        if (coffeeBeansAmountMachine >= 20) {
                            if (milkAmountMachine >= 75) {
                                System.out.println("I have enough resources, making you a coffee!");
                                return true;
                            } else {
                                System.out.println("Sorry, not enough milk!");
                                return false;
                            }
                        } else {
                            System.out.println("Sorry, not enough coffee beans!");
                            return false;
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                        return false;
                    }

                case "cappuccino":
                    if (waterAmountMachine >= 200) {
                        if (coffeeBeansAmountMachine >= 12) {
                            if (milkAmountMachine >= 100) {
                                System.out.println("I have enough resources, making you a coffee!");
                                return true;
                            } else {
                                System.out.println("Sorry, not enough milk!");
                                return false;
                            }
                        } else {
                            System.out.println("Sorry, not enough coffee beans!");
                            return false;
                        }
                    } else {
                        System.out.println("Sorry, not enough water!");
                        return false;
                    }
            }
        } else {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    private static void prepareEspresso() {
        disposableCupsAmountMachine -= 1;
        waterAmountMachine -= 250;
        coffeeBeansAmountMachine -= 16;
        moneyAmountMachine += 4;
    }

    private static void prepareLatte() {
        disposableCupsAmountMachine -= 1;
        waterAmountMachine -= 350;
        milkAmountMachine -= 75;
        coffeeBeansAmountMachine -= 20;
        moneyAmountMachine += 7;
    }

    private static void prepareCappuccino() {
        disposableCupsAmountMachine -= 1;
        waterAmountMachine -= 200;
        milkAmountMachine -= 100;
        coffeeBeansAmountMachine -= 12;
        moneyAmountMachine += 6;
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        waterAmountMachine += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milkAmountMachine += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffeeBeansAmountMachine += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        disposableCupsAmountMachine += scanner.nextInt();
        determineAction();
    }

    private static void take() {
        System.out.println("I gave you $" + moneyAmountMachine);
        moneyAmountMachine = 0;
        determineAction();
    }

    private static void printMachineContent() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(waterAmountMachine + " of water");
        System.out.println(milkAmountMachine + " of milk");
        System.out.println(coffeeBeansAmountMachine + " of coffee beans");
        System.out.println(disposableCupsAmountMachine + " of disposable cups");
        System.out.println(moneyAmountMachine + " of money");
        determineAction();
    }
}
