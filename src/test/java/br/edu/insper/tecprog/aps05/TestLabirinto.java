package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestLabirinto {
    
    @Test
    void testCriacao1() {
        var t = 
"""
###
...
###
""";
        var l = new Labirinto(t);
        assertEquals(3, l.getLargura());
        assertEquals(3, l.getAltura());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i ==0 || i == 2) assertEquals(false, l.ehLivre(i, j));
                else assertEquals(true, l.ehLivre(i, j));

                if ((i == 1 && j == 0) || (i == 1 && j == 2)) assertEquals(true, l.ehSaida(i, j));
                else assertEquals(false, l.ehSaida(i, j));
            }
        };
    }

    @Test
    void testCriacao2() {
        var t = 
"""
####
....
####
""";
        var l = new Labirinto(t);
        assertEquals(4, l.getLargura());
        assertEquals(3, l.getAltura());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i ==0 || i == 2) assertEquals(false, l.ehLivre(i, j));
                else assertEquals(true, l.ehLivre(i, j));

                if ((i == 1 && j == 0) || (i == 1 && j == 3)) assertEquals(true, l.ehSaida(i, j));
                else assertEquals(false, l.ehSaida(i, j));
            }
        };
    }
}
