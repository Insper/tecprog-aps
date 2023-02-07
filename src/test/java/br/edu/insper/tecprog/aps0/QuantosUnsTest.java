package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class QuantosUnsTest {
    @Test
    void testePreguicoso() {
        int[] entradas = {10, 0, 5, 11, 55, 6531, 1000};
        int[] saidas = {1, 0, 0, 2, 0, 1, 1};

        for (int i = 0; i < entradas.length; i++) {
            var resultado = QuantosUns.quantosUns(entradas[i]);
            assertEquals(saidas[i], resultado);
        }
    }
}
