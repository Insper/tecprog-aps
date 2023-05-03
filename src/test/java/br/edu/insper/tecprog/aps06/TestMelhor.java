package br.edu.insper.tecprog.aps06;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMelhor {

    @Test
    void testAula() {
        int N = 5;
        int C = 15;
        int[] pesos = { 12, 2, 1, 1, 4 };
        int[] valores = { 4, 2, 2, 1, 10 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(8, S.peso);
        assertEquals(15, S.valor);

        var o = new boolean[N];
        o[1] = o[2] = o[3] = o[4] = true;
        assertArrayEquals(o, S.objetos);
    }

    @Test
    void testSimples1() {
        int N = 10;
        int C = 10;
        int[] pesos = { 3, 8, 6, 4, 5, 10, 1, 9, 3, 3 };
        int[] valores = { 70, 56, 17, 91, 77, 69, 98, 54, 13, 54 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(10, S.peso);
        assertEquals(266, S.valor);

        var o = new boolean[N];
        o[3] = o[4] = o[6] = true;
        assertArrayEquals(o, S.objetos);
    }

    @Test
    void testSimples2() {
        int N = 5;
        int C = 2;
        int[] pesos = { 1, 1, 2, 2, 1 };
        int[] valores = { 50, 94, 40, 39, 62 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(2, S.peso);
        assertEquals(156, S.valor);

        var o = new boolean[N];
        o[1] = o[4] = true;
        assertArrayEquals(o, S.objetos);
    }

    @Test
    void testSimples3() {
        int N = 10;
        int C = 100;
        int[] pesos = { 58, 90, 36, 53, 8, 98, 31, 37, 36, 6 };
        int[] valores = { 95, 32, 37, 54, 9, 29, 43, 59, 3, 98 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(95, S.peso);
        assertEquals(236, S.valor);

        var o = new boolean[N];
        o[0] = o[6] = o[9] = true;
        assertArrayEquals(o, S.objetos);
    }

    @Test
    void testSimples4() {
        int N = 5;
        int C = 10;
        int[] pesos = { 1, 1, 2, 1, 8 };
        int[] valores = { 5, 10, 5, 20, 25 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(10, S.peso);
        assertEquals(55, S.valor);

        var o = new boolean[N];
        o[1] = o[3] = o[4] = true;
        assertArrayEquals(o, S.objetos);
    }

    @Test
    void testSimples5() {
        int N = 100;
        int C = 70;
        int[] pesos = { 34, 43, 31, 27, 65, 34, 57, 8, 21, 60, 41, 69, 27, 23, 8, 51, 45, 2, 38, 44, 26, 53, 12, 5, 30,
                49, 22, 51, 8, 52, 39, 25, 48, 49, 58, 33, 10, 55, 59, 3, 69, 36, 28, 21, 40, 16, 5, 3, 59, 5, 57, 9,
                59, 37, 51, 10, 19, 7, 51, 18, 68, 10, 23, 52, 40, 7, 46, 4, 12, 7, 50, 18, 51, 30, 63, 43, 69, 18, 59,
                9, 41, 15, 49, 69, 8, 3, 13, 33, 64, 34, 51, 14, 34, 9, 56, 29, 21, 46, 17, 26 };
        int[] valores = { 37, 28, 69, 50, 67, 47, 78, 38, 0, 18, 78, 86, 16, 38, 17, 30, 17, 58, 35, 73, 40, 70, 60, 34,
                49, 38, 81, 64, 41, 57, 3, 19, 84, 87, 68, 75, 42, 68, 58, 80, 26, 96, 34, 46, 11, 82, 21, 59, 86, 7,
                73, 63, 53, 19, 66, 66, 58, 30, 44, 11, 24, 26, 49, 21, 24, 73, 17, 91, 6, 18, 3, 26, 83, 86, 36, 26,
                47, 65, 50, 99, 87, 88, 72, 34, 21, 58, 18, 42, 31, 80, 50, 83, 19, 49, 56, 75, 15, 33, 10, 46 };

        var b = new BackTracking();
        var S = b.resolveMochila(valores, pesos, C);

        assertEquals(70, S.peso);
        assertEquals(769, S.valor);

        var o = new boolean[N];
        o[17] = o[23] = o[39] = o[47] = o[51] = o[55] = o[65] = o[67] = o[79] = o[81] = o[85] = true;
        assertArrayEquals(o, S.objetos);
    }
}
