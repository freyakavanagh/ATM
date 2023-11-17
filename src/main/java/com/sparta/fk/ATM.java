package com.sparta.fk;



    public class ATM {

        private static int[] values;
        private static int[] quantities;


        public ATM(int[] denominations, int[] quantities) { //constructor
            this.values = denominations;
            this.quantities = quantities;
        }

        public static void withdrawValue(int amount) {
            int atmTotal = calculateATMTotal();

            if (amount > atmTotal) {
                System.out.println("Insufficient funds available");
                return;
            }

            System.out.println("Customer withdraws £ " + amount);

            int[] withdrawnNotes = new int[values.length];

            for (int i = 0; i < values.length; i++) {
                int value = values[i];
                int maxNotesToWithdraw = amount / value;
                int notesToWithdraw = Math.min(maxNotesToWithdraw, quantities[i]);

                if (notesToWithdraw > 0) {
                    quantities[i] -= notesToWithdraw;
                    withdrawnNotes[i] = notesToWithdraw;
                    amount -= notesToWithdraw * value;
                }
            }

            printWithdrawnNotes(withdrawnNotes);
            System.out.println(getATMBalance());
        }

        static int calculateATMTotal() { // method to calculate the amount in the ATM
            int atmTotal = 0;
            for (int i = 0; i < values.length; i++) {
                atmTotal += values[i] * quantities[i];
            }
            return atmTotal;
        }

        private static void printWithdrawnNotes(int[] withdrawnNotes) { // a method to print the notes that have been withdrawn
            for (int i = 0; i < values.length; i++) {
                if (withdrawnNotes[i] > 0) {
                    System.out.println(withdrawnNotes[i] + " x £" + values[i]);
                }
            }
        }

        static String getATMBalance() { // a method to return a string of the amount of each money type left in the ATM
            System.out.println("\nValue quantity of units");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                result.append(values[i]).append(" ").append(quantities[i]).append("\n");
            }
            return result.toString();
        }

    }



