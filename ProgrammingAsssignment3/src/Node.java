public class Node {
  private String data;
  private Node leftChild;
  private Node rightChild;
  private int where;

  public Node(String s, int where) { // constructor for a new node
    data = new String(s);
    leftChild = null;
    rightChild = null;
    this.where = where;
  }

  public int getWhere() { // returns the position of a node in the list
    return where;
  }

  public void setrightChild(Node n) { // sets the rightChild node
    rightChild = n;
  }

  public Node getrightChild() { // returns the rightChild node
    return rightChild;
  }

  public void setleftChild(Node n) { // sets the leftChild node
    leftChild = n;
  }

  public Node getleftChild() { // returns the leftChild node
    return leftChild;
  }

  public String getData() { // returns node data
    return data;
  }

  public void displayNode() {
    System.out.print('{' + where + ", " + data + '}');
  }

}
