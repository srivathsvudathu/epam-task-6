package collections;

import java.util.Arrays;
import java.util.ArrayList;

public class CustomArrayLists {
	 
     Object[] myStore;
     int actSize = 0;
     
    public CustomArrayLists(){
        myStore = new Object[10];
    }
     
    public Object get(int index){
        if(index < actSize){
            return myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
     
    public void add(Object obj){
        if(myStore.length-actSize <= 5){
            increaseListSize();
        }
        myStore[actSize++] = obj;
    }
     
    public Object remove(int index){
        if(index < actSize){
            Object obj = myStore[index];
            myStore[index] = null;
            int tmp = index;
            while(tmp < actSize){
                myStore[tmp] = myStore[tmp+1];
                myStore[tmp+1] = null;
                tmp++;
            }
            actSize--;
            return obj;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
         
    }
     
    public int size(){
        return actSize;
    }
     
    private void increaseListSize(){
        myStore = Arrays.copyOf(myStore, myStore.length*2);
        System.out.println("\nNew length: "+myStore.length);
    }
     
    public static void main(String a[]){
        CustomArrayLists q = new CustomArrayLists();
        q.add(new Integer(2));
        q.add(new Integer(5));
        q.add(new Integer(1));
        q.add(new Integer(23));
        q.add(new Integer(14));
        q.add(new Integer(78));
        for(int i=0;i<q.size();i++){
            System.out.print(q.get(i)+" ");
        }
        qq.add(new Integer(29));
        System.out.println("Element at Index 5:"+q.get(5));
        System.out.println("List size: "+q.size());
        System.out.println("Removing element at index 2: "+q.remove(2));
        for(int i=0;i<q.size();i++){
            System.out.print(q.get(i)+" ");
        }
    }
}