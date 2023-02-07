package br.edu.insper.tecprog.aps0;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PalavrasIguaisTest {
    @Test
    void retornaVerdadeiro() {
        String[] palavras = {
            "reco-reco",
            "blá-blá",
            "zum-zum",
            "tico-tico",
            "cri-cri",
            "glu-glu",
            "rom-rom",
            "esconde-esconde",
            "pega-pega",
            "corre-corre",
            "lero-lero"
        };

        for (String palavra : palavras) {
            assertTrue(PalavrasIguais.palavrasIguais(palavra));
        }
    }

    @Test
    void retornaFalso() { 
        String[] palavras = {
            "tique-taque",
            "pingue-pongue",
            "zigue-zague",
            "abobrinha",
            "guarda-chuva",
            "qualquer coisa",
            "tres-hiphens-bb",
            "-bla bla"
        };

        for (String palavra : palavras) {
            assertFalse(PalavrasIguais.palavrasIguais(palavra));
        }
    }
}
