package br.edu.insper.tecprog.aps02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void buscaListaEncontraTodos() {
        var l = new InsperArrayList<String>();
        for (int i = 0; i < 11; i++) {
            l.add("BLABLA" + Integer.toString(i));
        }
        for (int i = 0; i < 11; i++) {
            assertEquals(i, BinarySearchIter.<String>buscaBinaria(l, "BLABLA" + Integer.toString(i)));
        }
    }

    @Test
    @Timeout(value=1, unit=TimeUnit.SECONDS)
    void buscaListaEncontraTodosGRANDE() {
        var l = new InsperArrayList<String>();
        int N = 10001;
        for (int i = 0; i < N; i++) {
            l.add("BLABLA" + Integer.toString(i));
        }
        for (int i = 0; i < N; i++) {
            assertEquals(i, BinarySearchIter.<String>buscaBinaria(l, "BLABLA" + Integer.toString(i)));
        }
    }

}
