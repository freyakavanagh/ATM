package com.sparta.fk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ATMTests {

    @Test
    @DisplayName("Check ATMBalance Method")
    public void checkATMBalanceMethod() {
        int[] values = {50, 20, 10, 5, 2, 1};
        int[] quantities = {12, 20, 50, 100, 250, 500};

        ATM atm = new ATM(values, quantities);
        atm.withdrawValue(150);
        Assertions.assertEquals("50 9\n20 20\n10 50\n5 100\n2 250\n1 500\n", atm.getATMBalance());
    }

    @Test
    @DisplayName("Check ATMBalance Method Not Enough Money")
    public void checkATMBalanceMethodNotEnoughMoney() {
        int[] values = {50, 20, 10, 5, 2, 1};
        int[] quantities = {12, 20, 50, 100, 250, 500};
        ATM atm = new ATM(values, quantities);
        atm.withdrawValue(10000);
        Assertions.assertEquals("50 12\n20 20\n10 50\n5 100\n2 250\n1 500\n", atm.getATMBalance());
    }

    @Test
    @DisplayName("Check calculateATMTotal Method")
    public void checkATMCalculationMethodNoWithdrawal() {
        int[] values = {50, 20, 10, 5, 2, 1};
        int[] quantities = {12, 20, 50, 100, 250, 500};
        ATM atm = new ATM(values, quantities);
        atm.withdrawValue(0);
        Assertions.assertEquals(3000, atm.calculateATMTotal());

    }

    @Test
    @DisplayName("Check calculateATMTotal Method")
    public void checkATMCalculationMethod() {
        int[] values = {50, 20, 10, 5, 2, 1};
        int[] quantities = {12, 20, 50, 100, 250, 500};
        ATM atm = new ATM(values, quantities);
        atm.withdrawValue(10);
        Assertions.assertEquals(2990, atm.calculateATMTotal());

    }
}
