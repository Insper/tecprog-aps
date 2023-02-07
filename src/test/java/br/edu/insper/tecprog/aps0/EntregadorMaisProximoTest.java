package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EntregadorMaisProximoTest {
    
// testes = [
//     (([3, 4],[[10, 20], [4, 2], [100, 74], [23, 63]]), 1),
//     (([3, 4],[[3, 4], [4, 2], [100, 74], [23, 63]]), 0),
//     (([3, 4],[[10, 20], [4, 2], [4, 4], [23, 63]]), 2),
//     (([3, 4],[[10, 20], [4, 2], [100, 74], [4, 3]]), 3),
//     (([15, 20], [[28, 4], [63, 87], [192, 643], [16, 19], [523, 32]]), 3),
//     (([123, 654], [[1244, 432]]), 0),
//     (([0, 0], [[123, 432], [42, 312], [10, 20]]), 2),
// ]

    @Test
    void maisProximoTest() {
        double[] x_restaurante = {3, 3, 3, 3, 15, 123, 0};
        double[] y_restaurante = {4, 4, 4, 4, 20, 654, 0};

        double[][] X_entregadores = {
            {10, 4, 100, 23},
            {3, 4, 100, 23},
            {10, 4, 4, 23},
            {10, 4, 100, 4},
            {28, 63, 192, 16, 523},
            {1244}, 
            {123, 42 ,10}
        };
        double[][] Y_entregadores = {
            {20, 2, 74, 63}, 
            {4, 2, 74, 63},
            {20, 2, 4, 63},
            {20, 2, 74, 3},
            {4, 87, 643, 19, 32},
            {432},
            {432, 312, 20}
        };

        int[] ans = {1, 0, 2, 3, 3, 0, 2};

        for (int i = 0; i < ans.length; i++) {
            assertEquals(ans[i], EntregadorMaisProximo.maisProximo(
                x_restaurante[i], 
                y_restaurante[i], 
                X_entregadores[i], 
                Y_entregadores[i]));
        }


    }

}
