package com.company;

public class ArrayList<T>
{
    private Object[] array;
    private int size;

    public ArrayList(int size)
    {
        array = new Object[size];
    }

    public ArrayList() {
        size = 100;
    }

    public int find(T element) //returns index
    {
        for(int i = 0; i < size; i++)
        {
            if(element == array[i])
            {
                return i;
            }
        }
        return -1;
    }

    public void insert(T element, int index)
    {
        if(array.length <= size)
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
        return true;
    }

    public void growSize()
    {
        int oldmaxsize = size;
        size *= 2;
        Object[] newArray = new Object[size];

        if (oldmaxsize >= 0) System.arraycopy(array, 0, newArray, 0, oldmaxsize);

        array = newArray;
    }
}
