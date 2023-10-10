package br.edu.insper.tecprog.aps05;

public class Posicao implements Comparable<Posicao>{
    public final int i;
    public final int j;

    public Posicao(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int compareTo(Posicao arg0) {
        boolean equal = (i == arg0.i && j == arg0.j);
        return equal ? 0 : 1;
    }

    @Override
    public boolean equals(Object o) {
        Posicao p = (Posicao) o;

        return i == p.i && j == p.j;

    }

    @Override
    public String toString() {
        return "i: " + Integer.toString(i) + "; j: " + Integer.toString(j);
    }
}
