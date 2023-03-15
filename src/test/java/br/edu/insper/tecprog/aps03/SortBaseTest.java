package br.edu.insper.tecprog.aps03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public abstract class SortBaseTest {
    SortAlgorithm<Integer> alg;

    @BeforeAll
    abstract void setSortAlgorithm();

    boolean isOrdered(Comparable A[]) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i].compareTo(A[i+1]) > 0) return false;
        }
        return true;
    }
    
    @Test
    void onlyOneElement() {
        Integer a[] = {1};
        alg.sort(a);
        assertTrue(isOrdered(a));
    }

    @Test
    void alreadyOrdered() {
        Integer a[] = {1, 3, 6, 88, 99, 100, 10202, 12312234};
        alg.sort(a);
        assertTrue(isOrdered(a));
    }

    @Test
    void reversed() {
        Integer a[] = {1, 3, 6, 88, 99, 100, 10202, 12312234};
        Collections.reverse(Arrays.asList(a));
        assertFalse(isOrdered(a));
        alg.sort(a);
        assertTrue(isOrdered(a));
    }

    @Test
    void largeRandom() {
        int N = 100000;
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
