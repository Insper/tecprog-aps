package br.edu.insper.tecprog.aps04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestStringUtils {

    @Test
    void testPrefixo() {
        assertTrue(StringUtils.prefixo("abc", "a"));
        assertTrue(StringUtils.prefixo("abc", ""));
        assertTrue(StringUtils.prefixo("abc saafsd", "abc "));
        assertTrue(StringUtils.prefixo("DGRT234f", "DGRT2"));

        assertFalse(StringUtils.prefixo("a", "abc"));
        assertFalse(StringUtils.prefixo("abc", "Ab"));
        assertFalse(StringUtils.prefixo("DGRT234f", "DGRT3"));
        assertFalse(StringUtils.prefixo("DGRT234f", "dGRT2"));
    }

    @Test
    void testSufixo() {
        assertTrue(StringUtils.sufixo("abbc 2", "2"));
        assertTrue(StringUtils.sufixo("abbce", "ce"));
        assertTrue(StringUtils.sufixo("abbc 234", "234"));
        assertTrue(StringUtils.sufixo("!!asf!3", "f!3"));

        assertFalse(StringUtils.sufixo("abc", "a"));
        assertTrue(StringUtils.sufixo("abbc 2", "2 "));
        assertTrue(StringUtils.sufixo("abbc 2", "bbc"));
        assertTrue(StringUtils.sufixo("bla bla\nbl", "abl"));
    }

    @Test
    void testIndexOf() {
        var str = """
                package br.edu.insper.tecprog.aps01;

                public interface InsperList<T> {
                    public void add(int pos, T value);
                    public boolean remove(T value);
                    public T get(int pos);
                    public void set(int pos, T value);
                    public int size();
                }""";
        assertEquals(str.indexOf("int"), StringUtils.indexOf(str, "int"));
        assertEquals(str.indexOf("aps01"), StringUtils.indexOf(str, "aps01"));
        assertEquals(str.indexOf("bool"), StringUtils.indexOf(str, "bool"));
        assertEquals(str.indexOf("bla"), StringUtils.indexOf(str, "bla"));
        assertEquals(str.indexOf("Remove"), StringUtils.indexOf(str, "Remove"));
        assertEquals(str.indexOf("}"), StringUtils.indexOf(str, "}"));
    }

    @Test
    void testLastIndexOf() {
        var str = """
                package br.edu.insper.tecprog.aps01;

                public interface InsperList<T> {
                    public void add(int pos, T value);
                    public boolean remove(T value);
                    public T get(int pos);
                    public void set(int pos, T value);
                    public int size();
                }""";
        assertEquals(str.lastIndexOf("int"), StringUtils.lastIndexOf(str, "int"));
        assertEquals(str.lastIndexOf("aps01"), StringUtils.lastIndexOf(str, "aps01"));
        assertEquals(str.lastIndexOf("bool"), StringUtils.lastIndexOf(str, "bool"));
        assertEquals(str.lastIndexOf("bla"), StringUtils.lastIndexOf(str, "bla"));
        assertEquals(str.lastIndexOf("Remove"), StringUtils.lastIndexOf(str, "Remove"));
        assertEquals(str.lastIndexOf("}"), StringUtils.lastIndexOf(str, "}"));
    }

    String replaceFirst(String S, String Q, String newQ) {
        var idx = S.indexOf(Q);
        if (idx >= 0) {
            return S.substring(0, idx) + newQ + S.substring(idx + Q.length());
        }
        return S;
    }

    @Test
    void testReplace() {
        var str = """
                package br.edu.insper.tecprog.aps01;

                public interface InsperList<T> {
                    public void add(int pos, T value);
                    public boolean remove(T value);
                    public T get(int pos);
                    public void set(int pos, T value);
                    public int size();
                }""";
        assertEquals(replaceFirst(str, "int", "float"), StringUtils.replace(str, "int", "float"));
        assertEquals(replaceFirst(str, "int22", "float"), StringUtils.replace(str, "int22", "float"));
        assertEquals(replaceFirst(str, "value", "pos"), StringUtils.replace(str, "value", "pos"));
        assertEquals(replaceFirst(str, "  ", " "), StringUtils.replace(str, "  ", " "));
    }

    @Test
    void testReplaceAll() {
        var str = """
                package br.edu.insper.tecprog.aps01;

                public interface InsperList<T> {
                    public void add(int pos, T value);
                    public boolean remove(T value);
                    public T get(int pos);
                    public void set(int pos, T value);
                    public int size();
                }""";
        assertEquals(str.replace("int", "float"), StringUtils.replaceAll(str, "int", "float"));
        assertEquals(str.replace("int22", "float"), StringUtils.replaceAll(str, "int22", "float"));
        assertEquals(str.replace("value", "pos"), StringUtils.replaceAll(str, "value", "pos"));
        assertEquals(str.replace("  ", " "), StringUtils.replaceAll(str, "  ", " "));
    }

    @Test
    void testSumarioMarkdown() {
        var res = StringUtils.sumario("""
# teste 1

bla bla bla

# teste 2

## esse não vale

blalksadk

* sf;dj
* sdfk

    ;l;l;;

    # Aqui não vale, pois está indentado

# Aqui vale!
                        """);

        assertEquals(3, res.size());
        assertEquals("teste 1", res.get(0));
        assertEquals("teste 2", res.get(1));
        assertEquals("Aqui vale!", res.get(2));

        res = StringUtils.sumario("""
sldkfj

sdfslkdfj

## sdlkjsdfl

### sdlf

                        """);
        assertEquals(0, res.size());
    }

    @Test
    void testTiraTags() {
        assertEquals("texto", StringUtils.tiraTags("<b>tex<i>t</i></b>o"));
        assertEquals("pode usar < e > se não for tag", StringUtils.tiraTags("<em>pode usar < e > se não for tag</em>"));
        assertEquals("e pode estar desbalanceado", "<b>e pode estar <div>desbalanceado");
        assertEquals("com \nvárias\nlinhas", "<div>com \n<b>várias<b>\nlinhas");
        assertEquals("e com atributos", "<a href=\"bla bla\">e com atributos</a>");
    }

    @Test
    void testEmails() {
        var res = StringUtils.emailsInsper("igorsm1@insper.edu.br");
        assertEquals(1, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));

        res = StringUtils.emailsInsper("igorsm1@insper.edu.br     andrew.TNK@insper.edu.br" );
        assertEquals(2, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));
        assertEquals("andrew.TNK@insper.edu.br@insper.edu.br", res.get(1));

        res = StringUtils.emailsInsper("tes qualquer coisa ;igorsm1@insper.edu.br, andrew.TNK@insper.edu.br" );
        assertEquals(2, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));
        assertEquals("andrew.TNK@insper.edu.br@insper.edu.br", res.get(1));

        res = StringUtils.emailsInsper("""
        # README do projeto 

        * email: aluno1@al.insper.edu.br
        * email: aliuno2@al.insper.edu.br
        * email: aliuno33@al.insper.edu.br
        * email: aliuno33@al.insper.edu
        """ );
        assertEquals(3, res.size());
        assertEquals("aluno1@al.insper.edu.br", res.get(0));
        assertEquals("aliuno2@al.insper.edu.br", res.get(1));
        assertEquals("aliuno33@al.insper.edu.br", res.get(2));
    }
}
