package br.edu.insper.tecprog.aps02;

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

public class TestBinarySearchRec {

    @Test
    void buscaListaVazia() {
        InsperList<String> l = new InsperArrayList<String>();
        assertEquals(-1, BinarySearchRec.buscaBinaria(l, "sdkj"));
    }

    @Test
    void buscaListaUmElemento() {
        var l = new InsperArrayList<String>();
        l.add("BLABLA");
        assertEquals(-1, BinarySearchRec.<String>buscaBinaria(l, "sdkj"));
        assertEquals(0, BinarySearchRec.<String>buscaBinaria(l, "BLABLA"));
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
                    BinarySearchRec.<String>buscaBinaria(l, valor));
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

        assertEquals(0, BinarySearchRec.buscaBinaria(l, 0));
        assertEquals(7, BinarySearchRec.buscaBinaria(l, 1));
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
            assertEquals(i, BinarySearchRec.<Double>buscaBinaria(l, valor));
        }
    }
}