package com.company;

public class ArrayList<T>
{
    private Object[] array;
    private int size;
    private int count;

    public ArrayList(int size)
    {
        this.size = size;
        array = new Object[size];
    }

    public ArrayList()
    {
        size = 100;
        array = new Object[size];
    }

    public Object[] getArray()
    {
        return array;
    }

    public int find(T element) //returns index
    {
        for(int i = 0; i < size; i++)
        {
            if(element.equals(array[i]))
            {
                return i;
            }
            if(array[i] == null)
            {
                return -1;
            }
        }
        return -1;
    }

    public void insert(T element, int index)
    {
        count++;
        if(count > size)
        {
            growSize();
        }

        array[index] = element;

    }

    public T get(int index)
    {
        return (T) array[index];
    }

    public int size()
    {
        return size;
    }

    public int next(T key)
    {
        return find(key) + 1;
    }

    public int prev(T key)
    {
        return find(key) - 1;
    }

    public boolean remove(int index)
    {
        T temp = null;
        if(array.length <= size)
        {
            growSize();
        }
        else if(array.length <= size)

        temp = (T) array[index];

        if(temp == null)
        {
            return false;
        }
        array[index] = null;
        count--;
        return true;
    }

    public void growSize()
    {
        int oldmaxsize = size;
        size *= 2;
        Object[] newArray = new Object[size];

        for(int i = 0; i < oldmaxsize; i++)
        {
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
