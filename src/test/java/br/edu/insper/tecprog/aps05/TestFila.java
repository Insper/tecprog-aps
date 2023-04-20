package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestFila {
    @Test
    void testaTudo()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Fila<Integer>();
        assertTrue(p.empty());

        p.addLast(5);
        p.addLast(6);
        p.addLast(10);
        assertFalse(p.empty());

        assertEquals(5, p.removeFirst());
        assertEquals(6, p.removeFirst());
        assertEquals(10, p.removeFirst());
        assertTrue(p.empty());

        assertNull(p.removeFirst());
    }
}
