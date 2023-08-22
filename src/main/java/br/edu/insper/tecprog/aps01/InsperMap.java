package br.edu.insper.tecprog.aps01;

public interface InsperMap<T extends Comparable<T>, T2 extends Comparable<T2>> {
    public T2 get(T key);
    public void set(T key, T2 value);
    public T2 remove(T key);
    public int size();
}
