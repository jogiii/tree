package com.tree;

public class TreeApp {

    public static void main(String[] args) {
        Tree theTree = new Tree();
        theTree.insert(30,1.5);
        theTree.insert(38,1.7);
        theTree.insert(32,1.9);
        theTree.insert(72,1.9);
        theTree.insert(55,1.9);
        theTree.insert(41,1.9);
        theTree.insert(42,1.9);
        theTree.insert(60,1.9);
        theTree.insert(90,1.9);
        theTree.insert(78,1.9);
        theTree.insert(74,1.9);
        theTree.insert(92,1.9);

        theTree.traverse(Integer.parseInt("3"));


    }
}
