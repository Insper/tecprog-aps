package br.edu.insper.tecprog.aps01;

public interface InsperList<T> {
    public void add(T value);
    public void add(int pos, T value);
    public boolean remove(T value);
    public T remove(int index);
    public T get(int pos);
    public void set(int pos, T value);
    public int size();
}
