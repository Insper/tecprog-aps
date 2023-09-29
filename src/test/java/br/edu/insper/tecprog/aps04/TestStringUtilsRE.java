package br.edu.insper.tecprog.aps04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestStringUtilsRE {

    @Test
    void testSumarioMarkdown() {
        var res = StringUtilsRE.sumario("""
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

        res = StringUtilsRE.sumario("""
sldkfj

sdfslkdfj

## sdlkjsdfl

### sdlf

                        """);
        assertEquals(0, res.size());
    }

    @Test
    void testTiraTags() {
        assertEquals("texto", StringUtilsRE.tiraTags("<b>tex<i>t</i></b>o"));
        assertEquals("pode usar < e > se não for tag", StringUtilsRE.tiraTags("<em>pode usar < e > se não for tag</em>"));
        assertEquals("e pode estar desbalanceado", StringUtilsRE.tiraTags("<b>e pode estar <div>desbalanceado"));
        assertEquals("com \nvárias\nlinhas", StringUtilsRE.tiraTags("<div>com \n<b>várias<b>\nlinhas"));
        assertEquals("e com atributos", StringUtilsRE.tiraTags("<a href=\"bla bla\">e com atributos</a>"));
    }

    @Test
    void testEmails() {
        var res = StringUtilsRE.emailsInsper("igorsm1@insper.edu.br");
        assertEquals(1, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));

        res = StringUtilsRE.emailsInsper("igorsm1@insper.edu.br     andrew.TNK@insper.edu.br" );
        assertEquals(2, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));
        assertEquals("andrew.TNK@insper.edu.br", res.get(1));

        res = StringUtilsRE.emailsInsper("tes qualquer coisa ;igorsm1@insper.edu.br, andrew.TNK@insper.edu.br" );
        assertEquals(2, res.size());
        assertEquals("igorsm1@insper.edu.br", res.get(0));
        assertEquals("andrew.TNK@insper.edu.br", res.get(1));

        res = StringUtilsRE.emailsInsper("""
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
