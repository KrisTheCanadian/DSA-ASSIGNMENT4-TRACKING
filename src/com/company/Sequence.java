package com.company;

public class Sequence<T> implements IIntelligentSIDC<T>
{
    ArrayList<T> arrayList;
    Sequence()
    {

    }

    @Override
    public ArrayList<Integer> allKeys() {
        return null;
    }

    @Override
    public boolean add(long key, T data) {
        return false;
    }

    @Override
    public boolean remove(long key) {
        return false;
    }

    @Override
    public T getValues(long key) {
        return null;
    }

    @Override
    public long nextKey(long key) {
        return 0;
    }

    @Override
    public long prevKey(long key) {
        return 0;
    }

    @Override
    public long rangeKey(long key1, long key2) {
        return 0;
    }

    @Override
    public boolean keyExists(long key) {
        return false;
    }
}
