package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestPilha {
    @Test
    void criaPilhaComCapacidade10()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);
        final var atr = p.getClass().getDeclaredField("data");
        atr.setAccessible(true);
        assertTrue(atr.getType().getSimpleName().equals("Object[]"));
        var actual_data = (Object[]) atr.get(p);
        assertNotNull(actual_data);
        assertEquals(actual_data.length, 10);
    }

    @Test
    void criaPilhaComCapacidade100()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(100);
        final var atr = p.getClass().getDeclaredField("data");
        atr.setAccessible(true);
        assertTrue(atr.getType().getSimpleName().equals("Object[]"));
        var actual_data = (Object[]) atr.get(p);
        assertNotNull(actual_data);
        assertEquals(actual_data.length, 100);
    }

    @Test
    void empilha5Valores()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);
        final var atr = p.getClass().getDeclaredField("data");
        atr.setAccessible(true);

        var actual_data = (Object[]) atr.get(p);

        for (int i = 0; i < 5; i++) {
            assertTrue(p.push(i * 4));
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(i * 4, actual_data[i]);
        }
    }

    @Test
    void empilha10Valores()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);
        final var atr = p.getClass().getDeclaredField("data");
        atr.setAccessible(true);

        var actual_data = (Object[]) atr.get(p);

        for (int i = 0; i < 10; i++) {
            assertTrue(p.push(i * 2));
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i * 2, actual_data[i]);
        }
    }

    @Test
    void empilha15ValoresPilhaCheia()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);
        final var atr = p.getClass().getDeclaredField("data");
        atr.setAccessible(true);

        var actual_data = (Object[]) atr.get(p);

        for (int i = 0; i < 10; i++) {
            assertTrue(p.push(i * 2));
        }

        for (int i = 0; i < 5; i++) {
            assertFalse(p.push(i * 2));
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(i * 2, actual_data[i]);
        }
    }

    @Test
    void desempilha5Valores()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);

        for (int i = 0; i < 5; i++) {
            assertTrue(p.push(i * 4));
        }

        for (int i = 4; i >= 0; i--) {
            assertEquals(i * 4, p.pop());
        }
    }

    @Test
    void desempilha10Valores()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);

        for (int i = 0; i < 10; i++) {
            assertTrue(p.push(i * 2));
        }

        for (int i = 9; i >= 0; i--) {
            assertEquals(i * 2, p.pop());
        }
    }

    @Test
    void desempilha15ValoresPilhaVazia()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);

        for (int i = 0; i < 10; i++) {
            assertTrue(p.push(i * 2));
        }

        for (int i = 9; i >= 0; i--) {
            assertEquals(i * 2, p.pop());
        }

        for (int i = 0; i < 5; i++) {
            assertNull(p.pop());
        }
    }

    @Test
    void pilhaVaziaCheia()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        var p = new Pilha<Integer>(10);

        assertFalse(p.full());
        assertTrue(p.empty());

        for (int i = 0; i < 9; i++) {
            assertTrue(p.push(i * 2));
            assertFalse(p.empty());
            assertFalse(p.full());
        }

        assertTrue(p.push(18));
        assertFalse(p.empty());
        assertTrue(p.full());

        for (int i = 9; i >= 1; i--) {
            assertEquals(i * 2, p.pop());
            assertFalse(p.empty());
            assertFalse(p.full());
        }

        assertNotNull(p.pop());
        assertTrue(p.empty());
        assertFalse(p.full());
    }

}
