package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ValorDaNotaTest {
    @Test
    void listaVazia() {
        double[] P = {};
        int[] Q = {};
        assertEquals(0.0, ValorDaNota.valorDaNota(P, Q));
    }

    @Test
    void listaUmElemento() {
        double[] P = {1.5};
        int[] Q = {3};
        assertEquals(4.5, ValorDaNota.valorDaNota(P, Q));
    }

    @Test
    void variosElementos() {
        double[][] P = {
            {1.40,1.45,11.4},
            {16.13, 9.12, 50.2, 33.42, 18.01, 71.1, 93.34, 245.33, 67.43, 86.7},
            {1.21, 1.1, 4.5, 6.1, 100.15, 0.4, 8.67}

        };
        int[][] Q = {
            {1,63,73},
            {6, 1, 443, 42, 11, 38, 43, 61, 93, 1},
            {13, 41, 63, 6, 52, 14, 47}
        };
        double[] ans = {
            924.95,
            51984.49,
            6001.82
        };

        for (int i = 0; i < Q.length; i++) {
            assertEquals(ans[i], ValorDaNota.valorDaNota(P[i], Q[i]), 0.0001);
        }
    }
}
