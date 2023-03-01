package br.edu.insper.tecprog.aps02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
            l.add(- 0.2 * i);
        }
        assertFalse(BinarySearchIter.ordenado(l));
    }

    
}
