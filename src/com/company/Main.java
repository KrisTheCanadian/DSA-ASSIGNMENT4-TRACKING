package com.company;

public class Main {

    public static void main(String[] args)
    {
	    IntelligentSIDC intelligentSIDC = new IntelligentSIDC(5000);
	    long[] keys = test(intelligentSIDC, 5000);
	    ArrayList<Integer> sortedKeys = intelligentSIDC.allKeys();
    }

    public static long[] test(IntelligentSIDC intelligentSIDC, int size)
    {
        String name = "TestName ";
        long[] keys = new long[size];

        for(int i = 0; i < size; i++)
        {
            keys[i] = intelligentSIDC.add(name + i);
        }

        return keys;
    }
}
