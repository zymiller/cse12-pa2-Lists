public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        this.front = new Node(null, null);
        this.size = 0;
        for (E e : contents) {
        	add(e);
        }
        
    }
    
    public void add(E e) {
    	Node temp = this.front;
    	while (temp.next != null) {
    		temp = temp.next;
    	}
    	temp.next = new Node(e, null);
    	this.size++;
    }
    
    public boolean isEmpty() {
    	if (this.size == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }

    @SuppressWarnings("unchecked")
    public E[] toArray() {
    	E[] copy = (E[])(new Object[this.size]);
    	Node temp = this.front;
    	int index = 0;
    	while (temp.next != null) {
    		temp = temp.next;
    		copy[index] = temp.value;
    		index++;
    	}
		return copy;
    }
    
    public void transformAll(MyTransformer mt) {
    	Node temp = this.front;
    	while (temp.next != null) {
    		temp = temp.next;
    		temp.value = (E)mt.transformElement(temp.value);
    	}
    }
    
    public void chooseAll(MyChooser mc) {
    	Node temp = this.front;
    	Node nextNode = temp;
    	while (nextNode.next != null) {
    		if (mc.chooseElement(nextNode.next.value) == false) {
    			nextNode = nextNode.next;
        		size -= 1;
        	} else {
        		nextNode = nextNode.next;
        		temp.next = nextNode;
        		temp = temp.next;
        	}
    	}

    	temp.next = null;
    }

}