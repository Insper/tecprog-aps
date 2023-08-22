package br.edu.insper.tecprog.aps01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContaPalavrasTest {
    @Test
    void emptyStringNoWords() {
        var m = ContaPalavras.contaPalavras("");
        assertEquals(0, m.size());

        m = ContaPalavras.contaPalavras("   ");
        assertEquals(0, m.size());
    }

    @Test
    void onlySingleWords() {
        var m = ContaPalavras.contaPalavras("igor");
        assertEquals(1, m.size());
        assertEquals(1, m.get("igor"));

        m = ContaPalavras.contaPalavras("  toshi toshi ");
        assertEquals(1, m.size());
        assertEquals(2, m.get("toshi"));
    }

    @Test
    void phrases() {
        var m = ContaPalavras.contaPalavras("The Quick Brown Fox Jumps Over the Lazy Dog");
        assertEquals(8, m.size());
        assertEquals(2, m.get("the"));
        assertEquals(1, m.get("quick"));
        assertEquals(1, m.get("brown"));
        assertEquals(1, m.get("fox"));
        assertEquals(1, m.get("jumps"));
        assertEquals(1, m.get("over"));
        assertEquals(1, m.get("lazy"));
        assertEquals(1, m.get("dog"));
    }

    @Test
    void paragraphs() {
        var m = ContaPalavras.contaPalavras(""" 
        The Quick Brown Fox Jumps Over the Lazy Dog
        The Quick Brown Fox Jumps Over the Lazy Dog
        The Quick Brown Fox Jumps Over the Lazy Dog
        ipsum lorum bla  Ipsum IPSUM
        """);

        assertEquals(11, m.size());
        assertEquals(6, m.get("the"));
        assertEquals(3, m.get("quick"));
        assertEquals(3, m.get("brown"));
        assertEquals(3, m.get("fox"));
        assertEquals(3, m.get("jumps"));
        assertEquals(3, m.get("over"));
        assertEquals(3, m.get("lazy"));
        assertEquals(3, m.get("dog"));
        assertEquals(3, m.get("ipsum"));
        assertEquals(1, m.get("lorum"));
        assertEquals(1, m.get("bla"));
        
    }

}
