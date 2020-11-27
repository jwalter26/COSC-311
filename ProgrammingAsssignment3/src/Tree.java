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
                if (k.getData().compareTo(current.getData()) < 0) {
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

    public int search(String searchElem) { // searches for a node in the tree
        Node c = root;
        while (c != null) {
            if (c.getData().equals(searchElem)) break;
            if (searchElem.compareTo(c.getData()) < 0)
                c = c.getleftChild();
            else c = c.getrightChild();
        }
        if (c == null) return -1;
        if (c.getData().equals(searchElem)) return c.getWhere();
        else return -1;
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
            if (current == null){ 
                System.out.println("Not found");
                return false;
            }
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
    
    public void inOrder(Node localRoot, DataBaseRecord [] d) {
        if(localRoot != null) {
          inOrder(localRoot.getleftChild(),d);
          System.out.println(d[localRoot.getWhere()] + " ");
          inOrder(localRoot.getrightChild(),d);
        }
    }

    public void inOrderBackwards(Node localRoot, DataBaseRecord [] d) {
        if(localRoot != null) {
          inOrderBackwards(localRoot.getrightChild(),d);
          System.out.println(d[localRoot.getWhere()] + " ");
          inOrderBackwards(localRoot.getleftChild(),d);
        }
    }
    
}


