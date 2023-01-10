package Task1;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("Введіть 1 щоб додати фракцію");
        System.out.println("Введіть 2 щоб видалити конкретну фракцію");
        System.out.println("Введіть 3 щоб вивести усі  фракції");
        System.out.println("Введіть 4 щоб очистити конкретну фракцію");
        System.out.println("Введіть 5 щоб вивести конкретну фракцію");
        System.out.println("Введіть 6 щоб додати депутата в фракцію");
        System.out.println("Введіть 7 щоб видалити депутата з фракції");
        System.out.println("Введіть 8 щоб вивести список хабарників");
        System.out.println("Введіть 9 щоб вивести найбільшого хабарника");
    }

    public static void main(String[] args) throws Exception {

        VerhovnaRada verhovnaRada = new VerhovnaRada();


        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();

            switch (number) {
                case 1 -> verhovnaRada.addFraction();
                case 2 -> verhovnaRada.removeFraction();
                case 3 -> verhovnaRada.allFraction();
                case 4 -> verhovnaRada.cleanFraction();
                case 5 -> verhovnaRada.thisFraction();
                case 6 -> verhovnaRada.addDeputyToFraction();
                case 7 -> verhovnaRada.removeDeputyFromFraction();
                case 8 -> verhovnaRada.allBribeDeputy();
                case 9 -> verhovnaRada.biggestBribeDeputy();
                default -> throw new IllegalStateException("Unexpected value: " + number);
            }
        }
    }
}