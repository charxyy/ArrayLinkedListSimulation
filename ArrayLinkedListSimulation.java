// NAME: Jillian Charles Villanueva
// SECTION: BSIT-2A
// DATE: Sep 1, 2025

import java.util.Scanner;

public class ArrayLinkedListSimulation {
    private int[] simplicity = new int[0];
    private int size;
    private final Scanner scan = new Scanner(System.in);

    /**
     * Prompts the user to specify the desired array size.
     * Ensures the input is a positive integer.
     * Accepts integer values to populate the array.
     * If invalid input is provided, prompts the user to enter a valid number.
     */
    public void addArr() {
        System.out.print("Enter array size: ");

        if (scan.hasNextInt()) {
            size = scan.nextInt();

            if (size <= 0) {
                System.out.println("Array size must be greater than 0.\n");
                return;
            }
            simplicity = new int[size];
            System.out.println("Array size is: " + size);

            // Populate the array with user-provided integers
            for (int i = 0; i < size; ) {
                System.out.print("Enter number " + (i + 1) + ": ");
                if (scan.hasNextInt()) {
                    simplicity[i] = scan.nextInt();
                    i++;
                } else {
                    System.out.println("Please enter a valid integer.");
                    scan.next();
                }
            }

            // Display the final array contents
            System.out.print("\nFinal array: ");
            for (int i = 0; i < simplicity.length; i++) {
                System.out.print(simplicity[i]);
                if (i < simplicity.length - 1) System.out.print(", ");
            }
            System.out.println();

        } else {
            System.out.println("Please enter a valid integer.");
            scan.next();
        }
    }

    /**
     * Removes and returns the first element of the array.
     * Shifts all subsequent elements to the left.
     * If the array is empty, notifies the user.
     * @return the removed element, or -1 if the array is empty
     */
    public int pollArr() {
        if (size == 0) {
            System.out.println("Array is empty.\n");
            return -1;
        }
        int firstElement = simplicity[0];
        for (int i = 1; i < size; i++) {
            simplicity[i - 1] = simplicity[i];
        }
        size--;
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = simplicity[i];
        }
        simplicity = newArr;

        // Display the updated array
        System.out.print("New Array: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]);
            if (i < newArr.length - 1) System.out.print(", ");
        }
        System.out.println();

        return firstElement;
    }

    /**
     * Displays all elements in the array.
     * Returns the first element without removing it.
     * If the array is empty, notifies the user.
     * @return the first element, or -1 if the array is empty
     */
    public int peekArr() {
        if (size == 0) {
            System.out.println("\nArray is empty.");
            return -1;
        } else {
            System.out.print("Array Listed: ");
            for (int i = 0; i < size; i++) {
                System.out.print(simplicity[i]);
                if (i < size - 1) System.out.print(", ");
            }
            System.out.println();
            return simplicity[0];
        }
    }

    /**
     * Removes and returns the last element of the array.
     * Reduces the array size by one.
     * If the array is empty, notifies the user.
     * @return the removed last element, or -1 if the array is empty
     */
    public int popArr() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return -1;
        }
        int lastElement = simplicity[size - 1];
        size--;
        int[] newArr = new int[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = simplicity[i];
        }
        simplicity = newArr;

        // Display the updated array
        System.out.print("New Array: ");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]);
            if (i < newArr.length - 1) System.out.print(", ");
        }
        System.out.println();

        return lastElement;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayLinkedListSimulation arr = new ArrayLinkedListSimulation();
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            // Present the menu options to the user
            System.out.println("\n\n1. Add");
            System.out.println("2. Poll");
            System.out.println("3. Peek");
            System.out.println("4. Pop");
            System.out.println("5. Exit");
            System.out.print("\nChoice: ");

            if (scan.hasNextInt()) {
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        arr.addArr();
                        break;
                    case 2:
                        arr.pollArr();
                        break;
                    case 3:
                        arr.peekArr();
                        break;
                    case 4:
                        arr.popArr();
                        break;
                    case 5:
                        System.out.println("Exiting.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nPlease select a number between 1 and 5.\n");
                }
            } else {
                System.out.println("\nPlease enter a valid integer.\n");
                scan.next();
            }
        }
        scan.close();
    }
}


