package com.sparta.fk;

public class ATM {

    private int[] values;
    private int[] quantities;



    public ATM(int[] denominations, int[] quantities) { //constructor
        this.values = denominations;
        this.quantities = quantities;
    }

    public void withdrawValue(int amount) {

        int total = 0; // initialise ATM total

        for (int i = 0; i < values.length; i++) { // calculate ATM total
            total += values[i] * quantities[i];
        }

        if (amount > total) {
            System.out.printf("Insufficient funds available"); // don't allow withdrawal if not enough notes are available
        } else {
            System.out.println("Customer withdraws £" + amount); // prints amount withdrawn


            int[] withdrawnNotes = new int[values.length]; // initialises array for number of each note that is withdrawn

            // Iterates through note types
            for (int i = 0; i < values.length; i++) {
                int value = values[i]; // current note value

                int number = amount / values[i]; //max amount of notes of that type you can withdraw

                if (quantities[i] > 0) {

                    int numberWithdrawn = Math.min(number, quantities[i]); // finds smallest number in case there aren't enough notes
                    quantities[i] -= numberWithdrawn; //takes withdrawn notes out of ATM array
                    withdrawnNotes[i] = numberWithdrawn; //sets number of notes of that type that are withdrawn

                    amount -= numberWithdrawn * value; //sets amount of money left to withdraw


                }


            }


            for (int i = 0; i < values.length; i++) {
                if (withdrawnNotes[i] > 0) {
                    System.out.println(withdrawnNotes[i] + " x £" + values[i]); // prints notes withdrawn
                }


            }

            System.out.println(getATMBalance()); //prints notes still in ATM


        }
    }

    private String getATMBalance() {
        System.out.println("\n" +"Value quantity of units");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            result.append(values[i]).append(" ").append(quantities[i]).append("\n");


        }

        String finalString = result.toString();

        return finalString;
    }
}
