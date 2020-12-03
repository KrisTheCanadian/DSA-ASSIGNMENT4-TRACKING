package com.company;


import java.util.Random;

public class IntelligentSIDC
{

    IIntelligentSIDC<Student> dataStructure;

    IntelligentSIDC(int size)
    {
        SetSIDCThreshold(size);
    }

    void SetSIDCThreshold(int size)
    {
        if(size > 1000)
        {
            dataStructure = new AVLBinaryTree<>();
        }
        else
        {
            dataStructure = new Sequence<>();
        }
    }

    private int generate()
    {
        Random rand = new Random();
        int key;
        do {
            key = rand.nextInt(100000000); //will produce 8 digit number since from 0 - 99,999,999


        }while(dataStructure.keyExists(key));

        return key;
    }

    public ArrayList<Integer> allKeys()
    {
        return dataStructure.allKeys();
    }

    public long add(String value)
    {
        int key = generate();
        Student student = new Student(value, key);
        dataStructure.add(key, student);
        return key;
    }

    public boolean remove(long key)
    {
        return dataStructure.remove(key);
    }

    public Student getValues(long key)
    {
        return dataStructure.getValues(key);
    }

    public long nextKey(long key)
    {
        return dataStructure.nextKey(key);
    }

    public long prevKey(long key)
    {
        return dataStructure.prevKey(key);
    }

    public long rangeKey(long key1, long key2)
    {
        return dataStructure.rangeKey(key1, key2);
    }

}
