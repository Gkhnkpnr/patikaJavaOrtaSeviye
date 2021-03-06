package com.company;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);

    public void run () {
        while (true) {
            System.out.println();
            System.out.println("PatikaStore Product Management Panel");

            System.out.println("1 - Notebook ");
            System.out.println("2 - Mobile Phone");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");

            System.out.print("Your choice: ");
            int userChoice = input.nextInt();

            String[] brands = {"Samsung", "Lenovo", "Apple", "Huawei", "Casper", "Asus", "HP", "Xiaomi", "Monster"};

            int index = 0;
            for (String brand:brands) {
                Brand.addBrand(brand, index++);
            }

            boolean isExit = false;

            switch (userChoice) {
                case 1 :
                    System.out.println("1 is chosen");
                    Product.processMenu(1);
                    break;
                case 2 :
                    System.out.println("2 is chosen");
                    Product.processMenu(2);
                    break;
                case 3 :
                    Brand.printBrands();
                    break;
                case 0 :
                    isExit = true;
                    break;
                default :
                    System.out.println();
                    System.out.println("There is no such an option. Please enter your choice again.");
                    System.out.println();
                    break;

            }

            if (isExit) {
                System.out.println();
                System.out.println("You've left the store. See you soon.");
                return;
            }
        }
    }
}
