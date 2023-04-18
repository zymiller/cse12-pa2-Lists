public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] copy = (E[])(new Object[this.size]);
        for (int i = 0; i < this.size; i++) {
        	copy[i] = elements[i];
        }
        return copy;
    }
    
    public void transformAll(MyTransformer mt) {
    	for (int i = 0; i < this.size; i++) {
    		elements[i] = (E)mt.transformElement(elements[i]);
    	}
    }
    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
    	int newLength = 0;
    	for (E i : this.elements) {
    		if (mc.chooseElement(i) == true) {
    			newLength++; 
    		}
    	}
    	E[] newList = (E[])(new Object[newLength]);
    	int itemCount = 0;
    	for (E i : this.elements) {
    		if (mc.chooseElement(i) == true) {
    			newList[itemCount] = i;
    			itemCount++;
    		}
    	}
    	this.size = itemCount;
    	this.elements = newList;
    }
    
}