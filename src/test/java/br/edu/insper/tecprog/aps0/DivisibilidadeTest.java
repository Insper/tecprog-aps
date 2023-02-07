package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DivisibilidadeTest {
    
    @Test
    void naoDivisivelPor2NemPor3() {
        int[] entrada = {1,5, 7, 13};
        for (var i : entrada) {
            assertEquals("", Divisibilidade.divisivelInsper(i));
        }
    }
    
    @Test
    void divisivelPorSomente2() {
        int[] entrada = {2, 4, 22, 14};
        for (var i : entrada) {
            assertEquals("Ins", Divisibilidade.divisivelInsper(i));
        }
    }

    @Test
    void divisivelPorSomente3() {
        int[] entrada = {3, 9, 15, 21, 33, 39};
        for (var i : entrada) {
            assertEquals("per", Divisibilidade.divisivelInsper(i));
        }
    }

    @Test
    void divisivelPor2e3() {
        int[] entrada = {6, 12, 36, 150, 330, 660};
        for (var i : entrada) {
            assertEquals("Insper", Divisibilidade.divisivelInsper(i));
        }
    }
}
