package br.edu.insper.tecprog.aps01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ParentesesTest {
    
    @Test
    void emptyStringIsBalanced() {
        assertTrue(Parenteses.parentesesBalanceados(""));
    }

    @Test
    void onlyOpenParens() {
        assertFalse(Parenteses.parentesesBalanceados("("));
        assertFalse(Parenteses.parentesesBalanceados("["));
        assertFalse(Parenteses.parentesesBalanceados("{"));
    }

    @Test 
    void openCloseParens() {
        assertTrue(Parenteses.parentesesBalanceados("()"));
        assertTrue(Parenteses.parentesesBalanceados("[]"));
        assertTrue(Parenteses.parentesesBalanceados("{}"));
        assertTrue(Parenteses.parentesesBalanceados("()[]{}"));
    }


    @Test 
    void unbalancedWrongOrder() {
        assertFalse(Parenteses.parentesesBalanceados("({}})"));
        assertFalse(Parenteses.parentesesBalanceados("[(])"));
        assertFalse(Parenteses.parentesesBalanceados("{(()})"));
        assertFalse(Parenteses.parentesesBalanceados("{}()[(])"));
    }

    @Test
    void realProgram() {
        assertTrue(Parenteses.parentesesBalanceados("""
            package br.edu.insper.tecprog.aps01;

            public interface InsperList<T> {
                public void add(int pos, T value);
                public boolean remove(T value);
                public T get(int pos);
                public void set(int pos, T value);
                public int size();
            }"""));
    }


    
}
