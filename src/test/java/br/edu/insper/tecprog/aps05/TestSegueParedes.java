package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.edu.insper.tecprog.aps01.InsperArrayList;

public class TestSegueParedes {

    @Test
    void testLabirintosCorredor() {
        String[] corredores = {
"""
#####
.....
.....
#####
""", 
"""
#####
.....
.....
#####
""",
"""
#...#
#...#
#...#
#...#
#...#
#...#
#...#
""",
"""
#...#
#...#
#...#
#...#
#...#
#...#
#...#
"""
        };
        Posicao[] inicial = {
            new Posicao(1, 3),
            new Posicao(2, 1),
            new Posicao(3,2),
            new Posicao(5,3),
        };

        for (int i = 0; i < corredores.length; i++) {
            testaSolucaoValida(corredores[i], inicial[i], i);
        }
    }

    private void testaSolucaoValida(String labTexto, Posicao inicial, int i) {
        testaSolucaoValida(labTexto, inicial, i, 1);
    }

    private void testaSolucaoValida(String labTexto, Posicao inicial, int i, int tamMinimo) {
        var l = new Labirinto(labTexto);
        var caminho = new InsperArrayList<Posicao>();
        var seguirParedeInstance =  new SeguirParede();
        seguirParedeInstance.encontrarSaida(l, inicial.i, inicial.j, caminho);
        assertTrue(caminho.size() > tamMinimo);
        var posicaoFinal = caminho.get(caminho.size()-1);
        assertTrue(l.ehSaida(posicaoFinal.i, posicaoFinal.j));
        assertTrue(CaminhoUtils.caminhoValido(l, caminho));

        
    }

    @Test
    void testCantos() {
        String cantos[] = {
"""
###.#
#...#
#...#
#...#
#####
""",
"""
#####
#...#
#...#
#....
#####
""",
        };
        Posicao[] inicial = {
            new Posicao(3, 2),
            new Posicao(1, 1),
        };

        for (int i = 0; i < cantos.length; i++) {
            testaSolucaoValida(cantos[i], inicial[i], i);
        }
    }

    @Test
    void testBecos() {
        String becos[] = {
"""
##########
#........#
#..#######
.........#
##########
"""
        };
        Posicao[] inicial = {
            new Posicao(3, 1),
        };

        for (int i = 0; i < becos.length; i++) {
            testaSolucaoValida(becos[i], inicial[i], i, 3);
        }
    }
}
