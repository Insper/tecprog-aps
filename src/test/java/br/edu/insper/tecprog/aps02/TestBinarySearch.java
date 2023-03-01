package br.edu.insper.tecprog.aps02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import br.edu.insper.tecprog.aps01.InsperArrayList;
import br.edu.insper.tecprog.aps01.InsperList;

public class TestBinarySearch {
    @Test
    void ordenadoListaVazia() {
        InsperList<Double> l = new InsperArrayList<Double>();
        assertTrue(BinarySearchIter.ordenado(l));
    }

    @Test
    void ordenadoListaUmElemento() {
        InsperList<Double> l = new InsperArrayList<Double>();
        l.add(0.2);
        assertTrue(BinarySearchIter.ordenado(l));
    }

    @Test
    void ordenadoListaEmOrdem() {
        InsperList<Double> l = new InsperArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            l.add(0.2 * i);
        }
        assertTrue(BinarySearchIter.ordenado(l));
    }

    @Test
    void ordenadoListaEmOrdemInversa() {
        InsperList<Double> l = new InsperArrayList<Double>();
        for (int i = 0; i < 10; i++) {
            l.add(-0.2 * i);
        }
        assertFalse(BinarySearchIter.ordenado(l));
    }

    @Test
    void ordenadoListaBaguncada() {
        InsperList<Double> l = new InsperArrayList<Double>();
        l.add(5.7);
        l.add(5.71232);
        l.add(5.7664);
        l.add(5.732);
        l.add(5.70987);
        l.add(5.72243);
        l.add(5.77765);
        assertFalse(BinarySearchIter.ordenado(l));
    }

    @Test
    void buscaListaVazia() {
        InsperList<String> l = new InsperArrayList<String>();
        assertEquals(-1, BinarySearchIter.buscaBinaria(l, "sdkj"));
    }

    @Test
    void buscaListaUmElemento() {
        var l = new InsperArrayList<String>();
        l.add("BLABLA");
        assertEquals(-1, BinarySearchIter.<String>buscaBinaria(l, "sdkj"));
        assertEquals(0, BinarySearchIter.<String>buscaBinaria(l, "BLABLA"));
    }

    public Object[] peekObjectArray(InsperList l) throws Exception {
        var atr = l.getClass().getDeclaredField("data");
        atr.setAccessible(true);
        var actual_data = (Object[]) atr.get(l);
        return actual_data;
    }

    @Test
    void buscaListaEncontraTodos() throws Exception {
        var l = new InsperArrayList<String>();
        for (int i = 0; i < 11; i++) {
            l.add("BLABLA" + Integer.toString(i));
        }
        var data = peekObjectArray(l);
        Arrays.sort(data, 0, l.size());
        for (int i = 0; i < 11; i++) {
            var valor = "BLABLA" + Integer.toString(i);
            assertEquals(Arrays.binarySearch(data, 0, l.size(), valor),
                    BinarySearchIter.<String>buscaBinaria(l, valor));
        }
    }

    @Test
    void buscaListaEncontraRepetidos() throws Exception {
        var l = new InsperArrayList<Integer>();
        for (int i = 0; i < 7; i++) {
            l.add(0);
        }
        for (int i = 0; i < 3; i++) {
            l.add(1);
        }
        
        assertEquals(0, BinarySearchIter.buscaBinaria(l, 0));
        assertEquals(7, BinarySearchIter.buscaBinaria(l, 1));
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void buscaListaEncontraTodosGRANDE() throws Exception {
        var l = new InsperArrayList<Double>();
        int N = 100001;
        for (int i = 0; i < N; i++) {
            l.add(0.1 * i);
        }
        for (int i = 0; i < N; i++) {
            var valor = 0.1 * i;
            assertEquals(i, BinarySearchIter.<Double>buscaBinaria(l, valor));
        }
    }

}
