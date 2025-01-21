package com.tree;

class Tree {
    private Node root;
    public Tree(){
        root = null;
    }
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
        newNode.dData = dd;

        if(root == null)
            root = newNode;

        else{
            Node current = root;
            Node parent;

            while(true){
                parent = current;

                if(id<current.iData){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }

    }




    public boolean delete(int key){

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // step 1 : search

        while(current.iData != key){
            parent = current;
            if(key< current.iData){
                isLeftChild = true;
                current = current.leftChild;

            }
            else {
                isLeftChild = false;
                current = current.rightChild;

            }
            if(current == null)
                return false;  // node not found
        }
        // step 2 : delete the node

        // case 1: delete node with no child

        if(current.leftChild == null && current.rightChild ==null){

            if(current == root){
                root = null;
            } else if (isLeftChild) {
                parent.leftChild =null;
            }else
                parent.rightChild = null;

        }
        // case 2: delete node with one child either left or right
        //  case 2.1: if no right child replace it with left sub tree
        if(current.rightChild == null){
            if( current == root){
                root = null;
            }
            else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }else {
                parent.rightChild = current.leftChild;
            }
        }

        // case 2.2: if no left child replace it with right sub tree

        else if(current.leftChild == null){
            if(current == root){
                root = null;

            }else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }else
                parent.rightChild = current.rightChild;
        }


        // case 3: delete node with two children
        else{
            Node successor = getSuccessor(current);

            if(current == root){
                root =successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            }
            else{
                parent.rightChild =successor;
            }

            successor.leftChild = current.leftChild;
        }
        return true;

    }

    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;

    }
public void traverse(int traverseType){

        switch (traverseType){
            case 1:
                System.out.println("\n Preorder traversal");
                preOrder(root);
                break;
            case 2:
                System.out.println("\n Postorder traversal");
                postOrder(root);
                break;
            case 3:
                System.out.println("\n inorder traversal");
                inOrder(root);
                break;


        }
    System.out.println();

}

    private void inOrder(Node root) {

        if(root != null){
            inOrder(root.leftChild);
            System.out.println(root.iData+ " ");
            inOrder(root.rightChild);
        }
    }

    private void postOrder(Node root) {

        if(root !=null){
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.println(root.iData+ " ");
        }
    }

    private void preOrder(Node root) {

        if(root != null){
            System.out.println(root.iData+ " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

}
