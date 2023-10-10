package br.edu.insper.tecprog.aps05;

import br.edu.insper.tecprog.aps01.InsperList;

public interface EncontrarSaida {
    boolean encontrarSaida(Labirinto l, int i, int j, InsperList<Posicao> caminho);
}
