package com.tree;

public class Tree {
    private Node root;
    public Node find(int key){

        Node current = root;
        while(current.iData != key){
            if(key< current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if(current == null)
                return null;
        }
        return current;
    }

    public Node minimum(){

        Node current, last = null;
        current = root;
        while(current !=null){
            last =current;
            current = current.leftChild;
        }
        return last;
    }

    public Node maximum(){

        Node current , last = null;
        current = root;

        while(current !=null){
            last = current;
            current = current.rightChild;
        }
        return last;

    }

    public void insert(int id,double dd){

        Node newNode = new Node();
        newNode.iData = id;
        newNode.fData = dd;

        if(root == null)
            newNode = root;

        else {
            Node current = root;
            Node parent;

            while(true){
                parent = current;

                if(id< current.iData){
                    current = current.leftChild;

                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;

                    if(current ==null){
                        parent.rightChild = newNode;
                        return;
                    }
                }


            }


        }


    }

    public void delete(){

    }

    //various other methods


}
