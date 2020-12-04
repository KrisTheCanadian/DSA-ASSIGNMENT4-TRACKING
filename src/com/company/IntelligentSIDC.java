package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

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

    public void benchmarkAddFromFile(String name)
    {
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                int data = myReader.nextInt();

                benchmarkAdd(data);
            }
            myReader.close();
        } catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void benchmarkAdd(int key)
    {
        if(!dataStructure.keyExists(key))
        {
            Student student = new Student("Info", key);
            dataStructure.add(key, student);
            System.out.println("Key: " + key + " has been entered.");
        }
        else
       {
                System.out.println("Key: " + key + " Already Exists, Skipping.");
       }
    }

    public boolean remove(long key)
    {
        return dataStructure.remove(key);
    }

    public String getValues(long key)
    {
        return dataStructure.getValues(key).info;
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
