package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JacaWarsTest {
     

    @Test
    void muitoPerto() {
        double[] v = {30, 30, 40};
        double[] theta = {45, 40, 15};

        for (int i = 0; i < v.length; i++) {
            assertEquals("Muito perto", JacaWars.acertouJaca(v[i], Math.toRadians(theta[i])));
        }
    }

    @Test
    void muitoLonge() {
        double[] v = {60, 40, 40};
        double[] theta = {45, 40, 20};

        for (int i = 0; i < v.length; i++) {
            assertEquals("Muito longe", JacaWars.acertouJaca(v[i], Math.toRadians(theta[i])));
        }
    }

    @Test
    void acertou() {
        double[] v = {31.5, 31.5, 40};
        double[] theta = {45, 40, 18.5};

        for (int i = 0; i < v.length; i++) {
            assertEquals("Acertou!", JacaWars.acertouJaca(v[i], Math.toRadians(theta[i])));
        }
    }
}
