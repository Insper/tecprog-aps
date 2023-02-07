package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculaPITest {
    @Test
    void calculaPIParaI() {
        int[] n = { 1, 2, 3, 4, 10, 100, 1000, 10000 };
        double[] ans = { 2.449489742783178, 2.7386127875258306, 2.857738033247041, 2.92261298612503, 3.04936163598207,
                3.132076531809106, 3.140638056205993, 3.1414971639472147 };

        for (int i = 0; i < n.length; i++) {
            assertEquals(ans[i], CalculaPI.calculaPI(n[i]));
        }
    }
}
