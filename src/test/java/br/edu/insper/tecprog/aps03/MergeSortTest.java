package br.edu.insper.tecprog.aps03;

import org.junit.jupiter.api.BeforeEach;

public class MergeSortTest extends SortBaseTest{
    @Override
    @BeforeEach
    void setSortAlgorithm() {
        alg = new MergeSort<Integer>();
    }    
}
