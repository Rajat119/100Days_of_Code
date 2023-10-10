class MyCircularDeque {

    ArrayList<Integer> arr;
    int size;

    public MyCircularDeque(int k) {
        arr = new ArrayList<>();
        size = k;
    }
    
    public boolean insertFront(int value) {
        if(arr.size()<size){
            arr.add(0,value);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertLast(int value) {
        if(arr.size()<size){
            arr.add(value);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteFront() {
        if(arr.size()>0){
            arr.remove(0);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deleteLast() {
        if(arr.size()>0){
            arr.remove(arr.size()-1);
            return true;
        }else{
            return false;
        }
    }
    
    public int getFront() {
        if(arr.size()>0) return arr.get(0);
        else return -1;
    }
    
    public int getRear() {
        if(arr.size()>0) return arr.get(arr.size()-1);
        else return -1;
    }
    
    public boolean isEmpty() {
        if(arr.size()==0) return true;
        else return false;
    }
    
    public boolean isFull() {
        if(arr.size()==size) return true;
        else return false;
    }
}
