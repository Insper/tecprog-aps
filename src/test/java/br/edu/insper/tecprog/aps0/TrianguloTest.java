package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrianguloTest {
    @Test
    void testTrianguloLadosInteiros() {
        int[] bases = {2, 3, 5, 9, 10};
        int[] alturas = {2, 5, 7, 10, 500};
        double[] respostas = {2, 7.5, 17.5, 45, 2500};

        for (int i = 0; i < bases.length; i++) {
            assertEquals(respostas[i], Triangulo.areaTriangulo(bases[i], alturas[i]));
        }
    }
    
    @Test
    void testTrianguloLadosFracionarios() {
        double[] bases = {2.5, 3, 5, 9.5, 14.6};
        double[] alturas = {2, 5.8, 3.6, 4, 2.6};
        double[] respostas = {2.5, 8.7, 9, 19, 18.98};

        for (int i = 0; i < bases.length; i++) {
            assertEquals(respostas[i], Triangulo.areaTriangulo(bases[i], alturas[i]));
        }
    }
    
}
