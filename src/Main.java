import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của tập A: ");
        int lengthA;
        lengthA = inputValidateNumber(scanner);
        System.out.println("Độ dài tập A là: " + lengthA);
        Random rand = new Random();
        List<Integer> arrayA = creteSetNumber(lengthA, rand);
        System.out.println();
        System.out.println("Nhập vào số phần tử của tập B: ");
        int lengthB;
        lengthB = inputValidateNumber(scanner);
        System.out.println("Độ dài tập B là: " + lengthB);
        List<Integer> arrayB = creteSetNumber(lengthB, rand);
//        arrayA.retainAll(arrayB);
        System.out.println();
        System.out.println("Mang Chung: ");
        printUnion(arrayA, arrayB);
        System.out.println();
        System.out.println("Mang A - B ");
        printAnother(arrayA, arrayB);
        System.out.println();
        System.out.println("Mang B - A ");
        printAnother(arrayB, arrayA);
    }

    private static int inputValidateNumber(Scanner scanner) {
        int input;
        do {
            System.out.println("Please enter a positive number!");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next(); // this is important!
            }
            input = scanner.nextInt();
        } while (input <= 0 || input > 100);
        return input;
    }

    private static List<Integer> creteSetNumber(int length, Random rand) {
        Set<Integer> setNumber = new HashSet<>();
        while (setNumber.size() < length) {
            int randomInt = rand.nextInt(1000)+1;
            setNumber.add(randomInt);
        }
        List<Integer> arrNumber = new ArrayList<>(setNumber);
        for (int i = 0; i < arrNumber.size(); i++) {
            System.out.print(arrNumber.get(i)+ " ");
        }
        return arrNumber;
    }

    public static void printUnion(List<Integer> arrA, List<Integer> arrB) {
        for (int i = 0; i < arrA.size(); i++) {
            for (int j = 0; j < arrB.size(); j++) {
                if (arrA.get(i) == arrB.get(j))
                    System.out.print(arrA.get(i) + " ");
            }
        }
    }
    public static void printAnother(List<Integer> arrFirst, List<Integer> arrSecond) {
        for (int i = 0; i < arrFirst.size(); i++) {
                if (!arrSecond.contains(arrFirst.get(i))) {
                    System.out.print(arrFirst.get(i) + " ");
                }
        }
    }
}