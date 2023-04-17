package br.edu.insper.tecprog.aps05;

import static org.junit.jupiter.api.Assertions.assertTrue;

import br.edu.insper.tecprog.aps01.InsperList;

public class CaminhoUtils {
    public static String[] corredores = {
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
    
    public static String cantos[] = {
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
    
    public static String becos[] = {
        """
        ##########
        #........#
        #..#######
        .........#
        ##########
        """
                };
        
        


    public static boolean caminhoValido(Labirinto l, InsperList<Posicao> caminho) {
        var ultimo = caminho.get(0);

        for (int i = 1; i < caminho.size(); i++) {
            var atual = caminho.get(i);
            assertTrue(l.ehLivre(atual.i, atual.j));
            int diffI = Math.abs(atual.i - ultimo.i);
            int diffJ = Math.abs(atual.j - ultimo.j);

            if (!((diffI == 1 && diffJ == 0) || (diffI == 0 && diffJ == 1))) {
                return false;
            }

            ultimo = atual;
        }
        return true;
    }    
}
