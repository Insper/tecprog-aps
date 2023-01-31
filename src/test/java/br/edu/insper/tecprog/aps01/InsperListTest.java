package br.edu.insper.tecprog.aps01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

public class InsperListTest {
    /*
     * Testes que verificam se NOVA_LISTA() foi implementado corretamente
     */
    @Test
    @Tag("basico")
    public void hasFieldDataAsArray() throws Exception {
        var l = new InsperArrayList<Integer>();
        var atr = l.getClass().getDeclaredField("data");
        atr.setAccessible(true);
        assertTrue(atr.getType().getSimpleName().equals("Object[]"));
        var actual_data = (Object[]) atr.get(l);
        assertNotNull(actual_data);
        assertEquals(actual_data.length, 8);
    }

    /*
     * Testes que verificam se TAMANHO(L) foi implementado corretamente
     */
    @Test
    @Tag("basico")
    public void listShouldStartEmpty() {
        var l = new InsperArrayList<Integer>();
        assertEquals(0, l.size());
    }

    @Test
    @Tag("basico")
    public void addShouldIncrementListSize() {
        var l = new InsperArrayList<Integer>();
        l.add(0, 10);
        assertEquals(1, l.size());
        l.add(0, 10);
        assertEquals(2, l.size());
    }

    @Test
    @Tag("basico")
    public void removeShouldDecrementListSize() {
        var l = new InsperArrayList<Integer>();
        l.add(0, 11);
        l.add(0, 12);
        l.add(0, 13);
        assertEquals(3, l.size());
        l.remove(11);
        assertEquals(2, l.size());
    }

    /*
     * Testes que verificam se INSERE foi implementado corretamente
     */

    public Object[] peekObjectArray(InsperList l) throws Exception {
        var atr = l.getClass().getDeclaredField("data");
        atr.setAccessible(true);
        var actual_data = (Object[]) atr.get(l);
        return actual_data;
    }


    @Test
    @Tag("basico")
    public void addWorksAtTheStartOfTheList() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        assertEquals(10, data[0]);
        l.add(0, 11);
        assertEquals(11, data[0]);
        assertEquals(10, data[1]);
        assertEquals(2, l.size());
    }

    @Test
    @Tag("basico")
    public void addWorksAtTheEndOfTheList() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);
    }

    @Test
    @Tag("basico")
    public void addWorksAtTheMiddleOfTheList() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);
        l.add(1, 15);
        assertEquals(10, data[0]);
        assertEquals(15, data[1]);
        assertEquals(11, data[2]);
        assertEquals(12, data[3]);
        assertEquals(13, data[4]);
    }


    /*
     * Testes que verificam se REMOVE foi implementado corretamente
     */
    @Test
    @Tag("basico")
    public void removeWorksAtTheStartOfTheList() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);
        assertEquals(l.size(), 4);

        assertTrue(l.remove(10));
        assertEquals(11, data[0]);
        assertEquals(12, data[1]);
        assertEquals(13, data[2]);
        assertEquals(l.size(), 3);

        assertTrue(l.remove(11));
        assertEquals(12, data[0]);
        assertEquals(13, data[1]);
        assertEquals(l.size(), 2);
    }
    
    @Test
    @Tag("basico")
    public void removeWorksAtTheEndtOfTheList() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);

        assertTrue(l.remove(13));
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(l.size(), 3);

        assertTrue(l.remove(12));
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(l.size(), 2);
    }

    @Test
    @Tag("basico")
    public void removeWithNoOccurrenceReturnsFalse() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);
        assertEquals(l.size(), 4);

        assertFalse(l.remove(130));
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(13, data[3]);
        
        assertEquals(l.size(), 4);
    }

    @Test
    @Tag("basico")
    public void removeOnlyRemovesFirstOccurrence() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 11);
        assertEquals(10, data[0]);
        assertEquals(11, data[1]);
        assertEquals(12, data[2]);
        assertEquals(11, data[3]);
        assertEquals(l.size(), 4);

        assertTrue(l.remove(11));
        assertEquals(10, data[0]);
        assertEquals(12, data[1]);
        assertEquals(11, data[2]);
        assertEquals(l.size(), 3);
    }


    /*
     * Testes que verificam se GET e SET foram implementados corretamente
     */
    @Test
    @Tag("basico")
    public void get() throws Exception {
        var l = new InsperArrayList<Integer>();
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, l.get(0));
        assertEquals(11, l.get(1));
        assertEquals(12, l.get(2));
        assertEquals(13, l.get(3));
        l.add(1, 15);
        assertEquals(10, l.get(0));
        assertEquals(15, l.get(1));
        assertEquals(11, l.get(2));
        assertEquals(12, l.get(3));
        assertEquals(13, l.get(4));
    }

    @Test
    @Tag("basico")
    public void set() throws Exception {
        var l = new InsperArrayList<Integer>();
        l.add(0, 10);
        l.add(1, 11);
        l.add(2, 12);
        l.add(3, 13);
        assertEquals(10, l.get(0));
        assertEquals(11, l.get(1));
        assertEquals(12, l.get(2));
        assertEquals(13, l.get(3));
        l.add(1, 15);

        l.set(2, 25);
        assertEquals(10, l.get(0));
        assertEquals(15, l.get(1));
        assertEquals(25, l.get(2));
        assertEquals(12, l.get(3));
        assertEquals(13, l.get(4));
    }

    /*
     * Testes para redimensionamento do array de dados.
     */
    @Test
    @Tag("avancado")
    void dataArrayResizesAfter8Insertions() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        assertEquals(8, data.length);

        for (int i = 0; i < 9; i++) {
            l.add(0, i);
        }

        var data2 = peekObjectArray(l);
        assertNotEquals(data, data2);
        assertEquals(16, data2.length);
        assertEquals(9, l.size());
        for (int i = 0; i < 9; i++) {
            assertEquals(9 - i - 1, data2[i]);
            assertEquals(9 - i - 1, l.get(i));
        }
    }

    @Test
    @Tag("avancado")
    void dataArrayResizesAfter12Removes() throws Exception {
        var l = new InsperArrayList<Integer>();
        var data = peekObjectArray(l);
        assertEquals(8, data.length);

        for (int i = 0; i < 16; i++) {
            l.add(0, i);
        }

        for (int i = 0; i < 12; i++) {
            l.remove(i);
        }

        var data2 = peekObjectArray(l);
        assertNotEquals(data, data2);
        assertEquals(8, data.length);
        for (int i = 0; i < 4; i++) {
            assertEquals(16 - i - 1, data2[i]);
            assertEquals(16 - i - 1, l.get(i));
        }
    }
}
