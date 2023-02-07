package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class DiffListasTest {
    @Test
    void listasIguais() {
        int[] A = {1, 2, 3};
        int[] vazio = {};

        assertArrayEquals(vazio, DiffListas.diffListas(A, A));
    }

    @Test
    void listasDiferentes() {
        int[] A = {1, 2, 3};
        int[] B = {4, 5, 6};

        assertArrayEquals(A, DiffListas.diffListas(A, B));
        assertArrayEquals(B, DiffListas.diffListas(B, A));
    }

    @Test 
    void umElementoEmAmbas() {
        int[] A = {1, 2, 3, 4};
        int[] B = {4, 5, 6};

        int[] A_B = {1, 2, 3};
        int[] B_A = {5, 6};

        assertArrayEquals(A_B, DiffListas.diffListas(A, B));
        assertArrayEquals(B_A, DiffListas.diffListas(B, A));
    }

    @Test 
    void elementosEmVariasPosicoes() {
        int[] A = {1, 2, 3, 4, 6};
        int[] B = {3, 4, 3, 5, 6};

        int[] A_B = {1, 2};
        int[] B_A = {5};

        assertArrayEquals(A_B, DiffListas.diffListas(A, B));
        assertArrayEquals(B_A, DiffListas.diffListas(B, A));
    }
}
