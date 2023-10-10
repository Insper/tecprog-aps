package br.edu.insper.tecprog.aps05;

import org.junit.jupiter.api.BeforeEach;

public class TestSegueParedes extends TestSaidasSimples {

    @Override
    @BeforeEach
    void setAlgorithm() {
        algo = new SeguirParede();
    }

}
