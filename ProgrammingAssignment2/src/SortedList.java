public class SortedList 
{
    private DoubleNode front;
    private DoubleNode back;
    
    public SortedList() // constructor for a new sorted list
    {
        front = null;
        back = null;
    }

    public void insert(DoubleNode k) // inserts a new node into the list. Sakib Jabbar provided assistance with writing this method
    {
        k.setNext(null);

        if(front==null)
        {
            front=k;
            back=k;
            front.setPrev(null);
            return;
        }

        if(k.getData().compareTo(front.getData())<0) // compares the new node data with the front node data
        {
            k.setPrev(null);
            front.setPrev(k);
            k.setNext(front);
            front=k;
            return;
        }

        if(k.getData().compareTo(back.getData())>0) // compares the new node data with the rear node data
        {
            k.setPrev(back);
            back.setNext(k);
            back=k;
            return;
        }

        DoubleNode tmp=front.getNext();
        while(tmp.getData().compareTo(k.getData())<0)
            tmp=tmp.getNext();

        tmp.getPrev().setNext(k);
        k.setPrev(tmp.getPrev());
        tmp.setPrev(k);
        k.setNext(tmp);
    }

    public DoubleNode getFront() { // returns the front node
        return front;
    }

    public DoubleNode getBack() { // returns the back node
        return back;
    }

    public int search(String searchElem) { // searches for a node in the list
        DoubleNode c =  front;
        while (c != null) {
            if (c.getData().compareTo(searchElem) == 0) break;
            else c = c.getNext();
        }
        if (c == null) return -1;
        if (c.getData().compareTo(searchElem) == 0) return c.getWhere();
        else return -1;
    }

    public DoubleNode delete(int del) // deletes a node from the list. The course textbook provided assistance wih writing this method (pages 228-229).
    {
        DoubleNode current=front;
        while(current.getWhere()!=del) 
        {
            current=current.getNext();
            if(current==null)
                return null;
        }
        if(current==front)
            front=current.getNext();
        else
            current.getPrev().setNext(current.getNext());
        if(current==back)
            back=current.getPrev();
        if(current.getNext() == null)
            current=current.getPrev();
        else
            current.getNext().setPrev(current.getPrev());
        return current;
    }
}


