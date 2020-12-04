package com.company;

public class AVLBinaryTree<T> implements IIntelligentSIDC<T>
{
    private Node<T> root;
    ArrayList<Integer> keys = new ArrayList<>();
    boolean needsToBeUpdated = true; //for sorted key list
    private int count = 0;

    public boolean insert(int key, T data)
    {
        needsToBeUpdated = true;

        root = insert(root, key, data);
        return root != null;
    }

    public boolean delete(int key)
    {
        needsToBeUpdated = true;

        root = delete(root, key);
        return root != null;
    }

    private Node<T> find(int key)
    {
        Node<T> currentNode = root;
        while(currentNode != null)
        {
            if(currentNode.key == key)
            {
                break;
            }
            currentNode = currentNode.key < key ? currentNode.getRight() : currentNode.getLeft();
        }

        return currentNode;
    }


    private Node<T> insert(Node<T> node, int key, T data)
    {

        if (node == null)
        {
            return new Node<T>(key, data);
        }
        else if (node.key > key)
        {
            node.setLeft(insert(node.getLeft(), key, data));
        }
        else if (node.key < key)
        {
            node.setRight(insert(node.getRight(), key, data));
        }

        return balance(node);
    }

    private Node<T> delete(Node<T> node, int key)
    {
        if (node == null)
        {
            return node;
        }
        else if (node.key > key)
        {
            node.setLeft(delete(node.getLeft(), key));
        }
        else if (node.key < key)
        {
            node.setRight(delete(node.getRight(), key));
        }
        else
        {
            if (node.getLeft() == null || node.getRight() == null) {
                node = (node.getLeft() == null) ? node.getRight() : node.getLeft();
            }
            else
            {
                Node<T> mostLeftChild = mostLeftChild(node.getRight());
                node.key = mostLeftChild.key;
                node.setRight(delete(node.getRight(), node.key));
            }
        }

        if (node != null)
        {
            node = balance(node);
        }

        return node;
    }

    private int getBalanceFactor(Node<T> n)
    {
        return (n == null) ? 0 : getHeight(n.getRight()) - getHeight(n.getLeft());
    }

    private void updateHeight(Node<T> n)
    {
        n.height = 1 + Math.max(getHeight(n.getLeft()), getHeight(n.getRight()));
    }

    private int getHeight(Node<T> n)
    {
        return n == null ? -1 : n.height;
    }

    private Node<T> rotateRight(Node<T> a)
    {
        Node<T> b = a.getLeft();
        Node<T> c = b.getRight();

        b.setRight(a);
        a.setLeft(c);

        updateHeight(a);
        updateHeight(b);

        return b;
    }

    private Node<T> rotateLeft(Node<T> a)
    {
        Node<T> b = a.getRight();
        Node<T> c = b.getLeft();

        b.setLeft(a);
        a.setRight(c);

        updateHeight(a);
        updateHeight(b);

        return b;
    }

    private Node<T> mostLeftChild(Node<T> node)
    {
        Node<T> current = node;
        while(current.getLeft() != null)
        {
            current = current.getLeft();
        }

        return current;
    }

    private Node<T> balance(Node<T> node)
    {
        updateHeight(node);
        int balance = getBalanceFactor(node);
        if (balance > 1)
        {
            if (getHeight(node.getRight().getRight()) > getHeight(node.getRight().getLeft()))
            {
                node = rotateLeft(node);
            }
            else
            {
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }
        else if (balance < -1)
        {
            if (getHeight(node.getLeft().getLeft()) > getHeight(node.getLeft().getRight()))
            {
                node = rotateRight(node);
            }
            else
            {
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        return node;
    }
    private void resetKeys()
    {
        if(keys.size() <= 0)
        {
            keys = new ArrayList<>();
        }
        keys = new ArrayList<>(keys.size());
        count = 0;
        InOrderTraversal(root);
    }

    public void InOrderTraversal(Node<T> node)
    {
        if(node == null){
            return;
        }

        InOrderTraversal(node.getLeft());
        keys.insert(node.key, count++);
        InOrderTraversal(node.getRight());

        needsToBeUpdated = false;
    }

    @Override
    public ArrayList<Integer> allKeys()
    {
        if(needsToBeUpdated)
        {
            resetKeys();
        }

        return keys;
    }

    @Override
    public boolean add(long key, T data)
    {
        return insert((int) key, data);
    }

    @Override
    public boolean remove(long key)
    {
        return delete((int)key);
    }

    @Override
    public T getValues(long key)
    {
        Node<T> node = find((int) key);
        return node.getData();
    }

    @Override
    public long nextKey(long key)
    {
        if(needsToBeUpdated)
        {
            resetKeys();
        }
        int index = keys.next((int) key);
        return keys.get(index);
    }

    @Override
    public long prevKey(long key)
    {
        if(needsToBeUpdated)
        {
            resetKeys();
        }
        int index = keys.prev((int) key);
        return keys.get(index);
    }

    @Override
    public long rangeKey(long key1, long key2)
    {
        if(needsToBeUpdated)
        {
            resetKeys();
        }

        int index1 = keys.find((int) key1);
        int index2 = keys.find((int) key2);

        if(index1 < keys.size() && index1 > -1 && index2 < keys.size() && index2 > -1)
        {
            if(index1 > index2)
            {
                return index1 - index2;
            }
            else
            {
                return index2 - index1;
            }
        }

        return -1;
    }

    @Override
    public boolean keyExists(long key)
    {
        return find((int) key) != null;
    }
}
