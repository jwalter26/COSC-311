public class Tree 
{
    private Node root;
    
    public Tree() // constructor for a new binary search tree
    {
        root = null;
    }

    public void insert(Node k) // inserts a new node into the tree
    {
        if (root == null)
            root = k;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (k.getWhere() < current.getWhere()) {
                    current = current.getleftChild();
                    if (current == null) {
                        parent.setleftChild(k);
                        return;
                    }
                }
                else {
                    current = current.getrightChild();
                    if (current == null) {
                        parent.setrightChild(k);
                        return;
                    }
                }
            }
        }
    }

    public Node getRoot() { // returns the root node
        return root;
    }

    public Node search(String searchElem) { // searches for a node in the tree
        Node c = root;
        while (c.getData() != null) {
            if (c.getData().compareTo(searchElem) > 0)
                c = c.getleftChild();
            else if (c.getData().compareTo(searchElem) < 0)
                c = c.getrightChild();
            else return null;
        }
        if (c.getWhere() <= 0) return null;
        else return c;
    }

    public boolean delete(int del) // deletes a node from the tree
    {
        Node current = root;
        Node parent = root;
        boolean isleftChild = true;

        while (current.getWhere() !=del) {
            parent = current;
            if (del < current.getWhere()) {
                isleftChild = true;
                current = current.getleftChild();
            }
            else {
                isleftChild = false;
                current = current.getrightChild();
            }    
           if (current == null) return false;
       }

        if (current.getleftChild() == null && current.getrightChild() == null) {
            if (current == root)
                root = null;
            else if (isleftChild)
                parent.setleftChild(null);
            else parent.setrightChild(null);
        }

        else if (current.getrightChild() == null) {
            if (current == root)
                root = current.getleftChild();
            else if (isleftChild)
                parent.setleftChild(current.getleftChild());
            else
                parent.setrightChild(current.getleftChild());
        }

        else if(current.getleftChild()==null)
            if (current == root)
            root = current.getrightChild();
            else if(isleftChild)
                parent.setleftChild(current.getrightChild());
            else
                parent.setrightChild(current.getrightChild());
        else {
            Node successor = getSuccessor(current);
            if(current == root)
                root = successor;
            else if(isleftChild)
                parent.setleftChild(successor);
            else
                parent.setrightChild(successor);
            successor.setleftChild(current.getleftChild());
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getrightChild();
        while(current != null) { 
            successorParent = successor;
            successor = current;
            current = current.getleftChild();
        }
        if(successor != delNode.getrightChild()) { 
            successorParent.setleftChild(successor.getrightChild());
            successor.setrightChild(delNode.getrightChild());
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch(traverseType) {
          case 1: System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
          case 2: System.out.print("\nInorder traversal: ");
            inOrder(root);
            break;
          case 3: System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
        }
        System.out.println();
      }
    
    private void preOrder(Node localRoot) {
        if(localRoot != null) {
          System.out.print(localRoot.getWhere() + " ");
          preOrder(localRoot.getleftChild());
          preOrder(localRoot.getrightChild());
        }
    }
    
    private void inOrder(Node localRoot) {
        if(localRoot != null) {
          inOrder(localRoot.getleftChild());
          System.out.print(localRoot.getWhere() + " ");
          inOrder(localRoot.getrightChild());
        }
    }
    
    private void postOrder(Node localRoot) {
        if(localRoot != null) {
          postOrder(localRoot.getleftChild());
          postOrder(localRoot.getrightChild());
          System.out.print(localRoot.getWhere() + " ");
        }
    }

    
}


