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
                if (k.getData().compareTo(current.getData()) < 0) { // inserts the new node in the corrected spot to maintain sorted order
                    current = current.getleftChild();
                    if (current == null) {
                        parent.setleftChild(k); // new node becomes a left child
                        return;
                    }
                }
                else {
                    current = current.getrightChild();
                    if (current == null) {
                        parent.setrightChild(k); // new node becomes a right child
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
            if (searchElem.compareTo(c.getData()) < 0) // goes right or left depending if the search value would precede or follow the current node value
                c = c.getleftChild();
            else c = c.getrightChild();
        }
        if (c == null) return -1; // prevents NullPointerException in edge casing
        if (c.getData().equals(searchElem)) return c.getWhere(); // returns the where value of the node being searched; search successful
        else return -1; // node not found
    }

    public Node delete(String del) // deletes a node from the tree
    {
        Node current = root;
        Node parent = root;
        boolean isleftChild = false;

        while (del.compareTo(current.getData()) != 0) { // searches for the node data in the tree
            parent = current;
            if (del.compareTo(current.getData()) < 0) {
                isleftChild = true;
                current = current.getleftChild(); // goes left if the current node data is greater than the node data to be deleted
            }
            else {
                isleftChild = false;
                current = current.getrightChild(); // goes right if otherwise
            }    
            if (current == null){ 
                System.out.println("Not found"); // node not found
                return null;
            }
        }
        
        if (current.getleftChild() == null && current.getrightChild() == null) { // current node has no children
            if (current == root) // tree is empty
                root = null;
            else if (isleftChild) // detaches from parent node
                parent.setleftChild(null);
            else parent.setrightChild(null);
        }

        else if (current.getrightChild() == null) { // no right child, left subtree goes in place
            if (current == root)
                root = current.getleftChild();
            else if (isleftChild)
                parent.setleftChild(current.getleftChild());
            else
                parent.setrightChild(current.getleftChild());
        }

        else if(current.getleftChild()==null) // no left child, right subtree goes in place
            if (current == root)
                root = current.getrightChild();
            else if(isleftChild)
                parent.setleftChild(current.getrightChild());
            else
                parent.setrightChild(current.getrightChild());
        
        else { // has both left and right child, therefore the successor node goes in place
            Node successor = getSuccessor(current);
            if(current == root)
                root = successor;
            else if(isleftChild)
                parent.setleftChild(successor);
            else
                parent.setrightChild(successor);
            successor.setleftChild(current.getleftChild()); // successor's left child becomes the current's left child
        }
        return current; // successful deletion
    }

    private Node getSuccessor(Node delNode) { // returns next highest node after the deleted node
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.getrightChild();
        while(current != null) { // goes left from the deleted node's right child until the edge of the tree is reached
            successorParent = successor;
            successor = current;
            current = current.getleftChild();
        }
        if(successor != delNode.getrightChild()) { // connections to be made if the successor is not the deleted node's right child
            successorParent.setleftChild(successor.getrightChild());
            successor.setrightChild(delNode.getrightChild());
        }
        return successor;
    }
    
    public void inOrder(Node localRoot, DataBaseRecord [] d) { // traverses the tree in ascending order recursively
        if(localRoot != null) {
          inOrder(localRoot.getleftChild(),d);
          System.out.println(d[localRoot.getWhere()] + " ");
          inOrder(localRoot.getrightChild(),d);
        }
    }

    public void inOrderBackwards(Node localRoot, DataBaseRecord [] d) { // traverses the tree in descending order recursively
        if(localRoot != null) {
          inOrderBackwards(localRoot.getrightChild(),d);
          System.out.println(d[localRoot.getWhere()] + " ");
          inOrderBackwards(localRoot.getleftChild(),d);
        }
    }
}


