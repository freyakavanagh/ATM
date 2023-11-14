package com.sparta.fk;

public class App {

    public static void main(String[] args) {

        int[] values = {50, 20, 10, 5, 2, 1}; //atm note values

        int[] quantities = {12, 20, 50, 100, 250, 500}; //atm note quantites

        ATM atm = new ATM(values, quantities); // instance of ATM class

        int amount = 157; // amount to withdraw

        atm.withdrawValue(amount); // withdrawing an amount



    }
}
