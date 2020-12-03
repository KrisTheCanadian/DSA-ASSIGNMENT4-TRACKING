package com.company;

public class Node<T>
{
    private Node<T> left;
    private Node<T> right;
    private T data;
    int key;

    int height;

    Node(int key, T data)
    {
        this.data = data;
        this.key = key;
    }

    void setRight(Node<T> right)
    {
        this.right = right;
    }

    void setLeft(Node<T> left)
    {
        this.left = left;
    }

    void setData(T data)
    {
        this.data = data;
    }

    Node<T> getRight()
    {
        return right;
    }

    Node<T> getLeft()
    {
        return left;
    }

    T getData()
    {
        return data;
    }
}
