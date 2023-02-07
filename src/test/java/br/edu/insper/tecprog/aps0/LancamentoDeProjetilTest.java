package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LancamentoDeProjetilTest {
    @Test
    void testePreguicoso() {
        double[] arg1 = {Math.sqrt(9.8), 20, 30 };
        double[] arg2 = {Math.PI / 6, Math.PI / 4, Math.PI / 3 };
        double[] arg3 = {1, 1, 1};
        double[] resp = {1.7320508075688772, 41.792958199885284, 80.10616414615706};

        for (int i = 0; i < arg1.length; i++) {
            assertEquals(resp[i], LancamentoDeProjetil.distanciaLancamento(arg1[i], arg2[i], arg3[i]));
        }
    }
}
