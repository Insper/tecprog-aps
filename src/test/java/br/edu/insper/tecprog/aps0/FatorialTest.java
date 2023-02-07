package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FatorialTest {
    @Test
    public void calculaFatorialTest() {
        int[] n = { 1, 2, 3, 4, 5, 8 };
        int[] ans = { 1, 2, 6, 24, 120, 40320 };

        for (int i = 0; i < n.length; i++) {
            assertEquals(ans[i], Fatorial.fatorial(n[i]));
        }
    }
}
