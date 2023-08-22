package br.edu.insper.tecprog.aps01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class InsperMapTest {

    @Test
    void mapStartsEmpty() {
        var m = new TwoListMap<String, String>();
        assertEquals(0, m.size());
    }

    @Test
    void mapGetNotFoundReturnsNull() {
        var m = new TwoListMap<String, String>();
        assertNull(m.get("QQ coisa"));
    }

    @Test
    void mapSetGet() {
        var m = new TwoListMap<String, String>();
        m.set("Bla bla", "res1");
        assertEquals("res1", m.get("Bla bla"));
    }

    @Test
    void mapSetTwoTimes() {
        var m = new TwoListMap<String, String>();
        m.set("Bla bla", "res1");
        assertEquals("res1", m.get("Bla bla"));
        m.set("Bla bla", "res2");
        assertEquals("res2", m.get("Bla bla"));
        assertEquals(1, m.size());

        m.set("outra chave", "res2");
        assertEquals("res2", m.get("outra chave"));
        assertEquals(2, m.size());
    }

    @Test
    void mapRemoveExistingKey() {
        var m = new TwoListMap<String, String>();
        m.set("Bla bla", "res1");
        m.set("Bla bla2", "res2");
        m.set("Bla bla3", "res3");

        assertNotNull(m.remove("Bla bla2"));
        assertNull(m.get("Bla bla2"));
        assertEquals(2, m.size());
        assertEquals("res1", m.get("Bla bla"));
        assertEquals("res3", m.get("Bla bla3"));
    }

    @Test
    void mapRemoveNotFound() {
        var m = new TwoListMap<String, String>();
        m.set("Bla bla", "res1");
        m.set("Bla bla2", "res2");
        m.set("Bla bla3", "res3");

        assertNull(m.remove("Bla bla4"));
        assertEquals(3, m.size());
        assertEquals("res1", m.get("Bla bla"));
        assertEquals("res2", m.get("Bla bla2"));
        assertEquals("res3", m.get("Bla bla3"));
    }
}
