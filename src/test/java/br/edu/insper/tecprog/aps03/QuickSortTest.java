package br.edu.insper.tecprog.aps03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuickSortTest extends SortBaseTest{
    @Override
    @BeforeEach
    void setSortAlgorithm() {
        alg = new QuickSort<Integer>();
    }    

    @Test
    void actuallyLargeRandom() {
        int N = 10000;
        Integer a[] = new Integer[N];
        var r = new Random(10);
        for (int i = 0; i < N; i++) {
            a[i] = r.nextInt(2 * N);
        }

        assertFalse(isOrdered(a));
        alg.sort(a);
        assertTrue(isOrdered(a));
    }
}
