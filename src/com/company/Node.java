package com.company;

public class Node<T>
{
    private Node previous;
    private Node next;
    private T data;

    Node(T data)
    {
        this.data = data;
    }

    void setNext(Node<T> next)
    {
        this.next = next;
    }

    void setPrevious(Node<T> previous)
    {
        this.previous = previous;
    }

    void setData(T data)
    {
        this.data = data;
    }

    Node<T> getNext()
    {
        return next;
    }

    Node<T> getPrevious()
    {
        return previous;
    }

    T getData()
    {
        return data;
    }
}
