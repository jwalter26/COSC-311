public class DoubleNode {
  private String data;
  private DoubleNode prev;
  private DoubleNode next;
  private int where;

  public DoubleNode(String s, int where) { // constructor for a new node
    data = new String(s);
    prev = null;
    next = null;
    this.where = where;
  }

  public int getWhere() { // returns the position of a node in the list
    return where;
  }

  public void setNext(DoubleNode n) { // sets the next node
    next = n;
  }

  public DoubleNode getNext() { // returns the next node
    return next;
  }

  public void setPrev(DoubleNode n) { // sets the previous node
    prev = n;
  }

  public DoubleNode getPrev() { // returns the previous node
    return prev;
  }

  public String getData() { // returns node data
    return data;
  }
}
