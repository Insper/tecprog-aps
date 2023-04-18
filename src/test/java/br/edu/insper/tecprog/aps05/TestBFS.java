package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.edu.insper.tecprog.aps01.InsperArrayList;

public class TestBFS {
    void testBSFComCaminho(Labirinto labirinto, Posicao fonte, Posicao destino) {
        var inst = new BFS();
        var caminhoEncontrado = new InsperArrayList<Posicao>();
        assertTrue(inst.bfs(labirinto, fonte, destino, caminhoEncontrado));
        assertTrue(caminhoEncontrado.size() >= 2);
        assertEquals(caminhoEncontrado.get(0), fonte);
        assertEquals(caminhoEncontrado.get(caminhoEncontrado.size() - 1), destino);
        CaminhoUtils.caminhoValido(labirinto, caminhoEncontrado);
    }

    void testBSFSemCaminho(Labirinto labirinto, Posicao fonte, Posicao destino) {
        var inst = new BFS();
        var caminhoEncontrado = new InsperArrayList<Posicao>();
        assertFalse(inst.bfs(labirinto, fonte, destino, caminhoEncontrado));
    }

    @Test
    void testCaminhoDireto() {
        String[] corredores = {
            """
            #####
            .....
            .....
            #####
            """, 
        };
        var labirinto = new Labirinto(corredores[0]);
        var fonte = new Posicao(1, 0);
        var destino = new Posicao(2, 3);
        testBSFComCaminho(labirinto, fonte, destino);
    }

    @Test
    void caminhoComCurva() {
        String labirintoStr =
"""
##########
#........#
#..#######
.........#
##########
""";
    
        var labirinto = new Labirinto(labirintoStr);
        var fonte = new Posicao(1, 9);
        var destino = new Posicao(3, 8);
        testBSFComCaminho(labirinto, fonte, destino);
    }


    @Test
    void destinoForaDeParede() {
        String labirintoStr =
"""
###.#
#...#
#...#
#...#
#####
""";
        var labirinto = new Labirinto(labirintoStr);
        var fonte = new Posicao(0, 3);
        var destino = new Posicao(2, 2);
        testBSFComCaminho(labirinto, fonte, destino);
    }

    @Test
    void testeComplicadoComCaminho() {
        String labirintoStr = 
"""
#########################
#....##.......####......#
#....#.......##.........#
#....#.......#..........#
#....#.......#..........#
#.####.......#..........#
#...#........#..........#
#...#........#..........#
#..##........#..........#
#..##........#.####.##..#
#...#........#.#.......##
#...##########.##########
#..............#........#
##############.#.######.#
#..............#.#..#...#
#....###.......#.#..#...#
###.##.#......##.#......#
#......########..#..#...#
#......#.....##..#.######
#......#.....###.#......#
#..........#.....#......#
#......#..##.....#......#
#......#..#......#......#
#......#..#......#......#
#########################
""";
        var labirinto = new Labirinto(labirintoStr);
        var fonte = new Posicao(2, 2);
        var destino = new Posicao(21, 21);
        testBSFComCaminho(labirinto, fonte, destino);
    }

    @Test
    void testeComplicadoSemCaminho() {
        String labirintoStr = 
"""
#########################
#....##.......####......#
#....#.......##.........#
#....#.......#..........#
#....#.......#..........#
#.####.......#..........#
#...#........#..........#
#...#........#..........#
#..##........#..........#
#..##........#.####.##..#
#...#........#.#.......##
#...##########.##########
#..............#........#
##############.#.######.#
#..............#.#..#...#
#....###.......#.#..#...#
###.##.#......##.#......#
#......########..#..#...#
#......#.....##..#.######
#......#.....###.#......#
#..........#.....#......#
#......#..##.....#......#
#......#..#......#......#
#......#..#......#......#
#########################
""";
        var labirinto = new Labirinto(labirintoStr);
        var fonte = new Posicao(2, 2);
        var destino = new Posicao(2, 10);
        testBSFSemCaminho(labirinto, fonte, destino);
    }

}
