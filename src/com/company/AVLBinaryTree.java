package com.company;

public class AVLBinaryTree<T> implements IIntelligentSIDC<T>
{
    private Node<T> root;
    ArrayList<Integer> keys;
    boolean needsToBeUpdated = true; //for sorted key list

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

    private Node<T> rotateRight(Node<T> y)
    {
        Node<T> x = y.getLeft();
        Node<T> z = x.getRight();

        x.setRight(y);
        y.setLeft(z);

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node<T> rotateLeft(Node<T> y)
    {
        Node<T> x = y.getRight();
        Node<T> z = x.getLeft();

        x.setLeft(y);
        y.setRight(z);

        updateHeight(y);
        updateHeight(x);

        return x;
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

    private Node<T> balance(Node<T> z)
    {
        updateHeight(z);
        int balance = getBalanceFactor(z);
        if (balance > 1)
        {
            if (getHeight(z.getRight().getRight()) > getHeight(z.getRight().getLeft()))
            {
                z = rotateLeft(z);
            }
            else
            {
                z.setRight(rotateRight(z.getRight()));
                z = rotateLeft(z);
            }
        }
        else if (balance < -1)
        {
            if (getHeight(z.getLeft().getLeft()) > getHeight(z.getLeft().getRight()))
            {
                z = rotateRight(z);
            }
            else
            {
                z.setLeft(rotateLeft(z.getLeft()));
                z = rotateRight(z);
            }
        }

        return z;
    }

    public void InOrderTraversal(Node<T> node, int count)
    {
        if(node != null)
        {
            InOrderTraversal(node.getLeft(), count);
            keys.insert(node.key, count++);
            InOrderTraversal(node.getLeft(), count);
        }
        needsToBeUpdated = false;
    }

    @Override
    public ArrayList<Integer> allKeys()
    {
        if(needsToBeUpdated)
        {
            InOrderTraversal(root, 0);
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
            InOrderTraversal(root, 0);
        }

        int index = keys.find((int) key);

        if(index > -1)
        {
            index++;
            if(index < keys.size())
            {
                return keys.get(index);
            }
        }

        return -1;
    }

    @Override
    public long prevKey(long key)
    {
        if(needsToBeUpdated)
        {
            InOrderTraversal(root, 0);
        }

        int index = keys.find((int) key);

        index--;
        if(index < keys.size() && index > -1)
        {
            return keys.get(index);
        }

        return -1;
    }

    @Override
    public long rangeKey(long key1, long key2)
    {
        if(needsToBeUpdated)
        {
            InOrderTraversal(root, 0);
        }

        int index1 = keys.find((int) key1);
        int index2 = keys.find((int) key2);

        if(index1 < keys.size() && index1 > -1 && index2 < keys.size() && index2 > -1)
        {
            if(index1 > index2)
            {
                return index2 - index1;
            }
            else
            {
                return index1 - index2;
            }
        }

        return -1;
    }

    @Override
    public boolean keyExists(long key)
    {
        return (find((int) key) == null);
    }
}
