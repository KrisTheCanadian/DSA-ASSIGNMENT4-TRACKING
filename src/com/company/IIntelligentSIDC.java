package com.company;

public interface IIntelligentSIDC<T>
{
    ArrayList<Integer> allKeys();

    boolean add(long key, T data);

    boolean remove(long key);

    T getValues(long key);

    long nextKey(long key);

    long prevKey(long key);

    long rangeKey(long key1, long key2);

    boolean keyExists(long key);
}
