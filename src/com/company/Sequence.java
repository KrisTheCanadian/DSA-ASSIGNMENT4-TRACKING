package com.company;

public class Sequence<T> implements IIntelligentSIDC<T>
{
    ArrayList<Node<T>> hashTable;
    AVLBinaryTree<Integer> sortedKeys;

    boolean need2UpdateKeys = true;

    public int primeSize = 1301;
    public int count = 0;
    Sequence()
    {
        hashTable = new ArrayList<>(primeSize);
    }

    private int hashTableInsert(long key, T data)
    {
        int hashkey = (int) (key % primeSize);
        int probing = hashkey;

        Node<T> newNode = new Node<>((int) key, data);
        Node<T> hashNode = hashTable.get(hashkey);

        while(hashNode != null)
        {
            if(hashNode.key == Integer.MIN_VALUE)
            {
                break; //open addressing (it's available)
            }
            hashNode = hashTable.get(probing = (probing + 1) % primeSize);
        }
        hashTable.insert(newNode, probing);
        return probing;
    }

    private void resetKeys()
    {
        sortedKeys = new AVLBinaryTree<>();
        Node<T> currentNode;
        for(int i = 0; i < hashTable.size(); i++)
        {
            currentNode = hashTable.get(i);
            if(currentNode != null)
            {
                sortedKeys.insert(currentNode.key, 0);
            }
        }
    }


    @Override
    public ArrayList<Integer> allKeys()
    {
        if(need2UpdateKeys)
        {
            resetKeys();
        }
        return sortedKeys.allKeys();
    }


    @Override
    public boolean add(long key, T data)
    {
        count++;
        need2UpdateKeys = true;
        hashTableInsert(key, data);
        return true;
    }

    @Override
    public boolean remove(long key)
    {
        if (!keyExists(key))
        {
            return false;
        }

        int i = (int) (key % primeSize);

        while(key != hashTable.get(i).key)
        {
            i = (i + 1) % primeSize;
        }

        hashTable.get(i).key = Integer.MIN_VALUE;

        count--;
        return true;
    }

    @Override
    public T getValues(long key)
    {
        int hashkey = (int) (key % primeSize);
        int probing = hashkey;

        Node<T> hashNode = hashTable.get(hashkey);

        while(hashNode != null)
        {
            if(hashNode.key == key)
            {
                return hashNode.getData();
            }
            hashNode = hashTable.get(probing = (probing + 1) % primeSize);
        }
        return null;
    }

    @Override
    public long nextKey(long key)
    {
        if(need2UpdateKeys)
        {
            resetKeys();
        }
        return sortedKeys.nextKey(key);
    }

    @Override
    public long prevKey(long key)
    {
        if(need2UpdateKeys)
        {
            resetKeys();
        }
        return sortedKeys.prevKey(key);
    }

    @Override
    public long rangeKey(long key1, long key2)
    {
        if(need2UpdateKeys)
        {
            resetKeys();
        }
        return sortedKeys.rangeKey(key1, key2);
    }

    @Override
    public boolean keyExists(long key)
    {
        int hashkey = (int) (key % primeSize);
        int probing = hashkey;

        Node<T> hashNode = hashTable.get(hashkey);

        while(hashNode != null)
        {
            if(hashNode.key == key)
            {
                return true;
            }
            hashNode = hashTable.get(probing = (probing + 1) % primeSize);
        }
        return false;
    }
}
