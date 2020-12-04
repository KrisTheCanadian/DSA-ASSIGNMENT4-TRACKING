package com.company;

public class Main {

    public static void main(String[] args)
    {
        // ADT

        benchmark1();
        //benchmark2();
        //benchmark3();

        // small ADT

        //testSmallADT(); //999
        //testSmall2ADT // 100

        // big ADT

        //testLarge1ADT(); //10,000
        //testLarge2ADT(); //500000
        //testLarge3ADT //1000000
    }

    public static void benchmark1()
    {
        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(500000);


        intelligentSIDC.benchmarkAddFromFile("CSTA_test_file1.txt");
        /*
        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");
        */
    }

    public static void benchmark2()
    {
        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(500000);

    /*
        intelligentSIDC.benchmarkAddFromFile("CSTA_test_file2.txt");

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");
        */
    }

    public static void benchmark3()
    {

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(1000000);

        intelligentSIDC.benchmarkAddFromFile("CSTA_test_file3.txt");

        /*
        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");
        */
    }

    public static void testLarge3ADT()
    {

        int size = 1000000;

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(size);


        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");

    }

    public static void testLarge1ADT()
    {
        int size = 10000;

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(size);


        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");

    }

    public static void testLarge2ADT()
    {
        int size = 500000;

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(size);


        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");

    }

    public static void testSmallADT()
    {
        int size = 999;

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(size);

        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");


    }

    public static void testSmall2ADT()
    {
        int size = 100;

        IntelligentSIDC intelligentSIDC = new IntelligentSIDC(size);

        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();

        int element1 = sortedKeys.get(0);

        System.out.println(intelligentSIDC.getValues(element1));

        long nextKey = intelligentSIDC.nextKey(element1);

        System.out.println(intelligentSIDC.getValues(nextKey));

        int prevKey = (int) intelligentSIDC.prevKey(nextKey);

        System.out.println(intelligentSIDC.getValues(prevKey));

        System.out.println("Range: "+ intelligentSIDC.rangeKey(element1, nextKey));

        intelligentSIDC.remove(prevKey);

        intelligentSIDC.add("Elon Musk");


    }
}
