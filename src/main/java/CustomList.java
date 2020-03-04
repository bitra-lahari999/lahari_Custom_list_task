import java.util.Arrays;

public class CustomList<E> {
    private int size = 0;

    //Default capacity of list is 10
    private static final int DEFAULT_CAPACITY = 10;

    //This array will store all  added to li
    private Object list[];


    public CustomList() {
        // default constructor
        list = new Object[DEFAULT_CAPACITY];
    }

    public void add(E e) {
        if (size==list.length) {
            ensureCapacity();
        }
        list[size++] = e;
    }

    public boolean	addAll(CustomList<E> c)
    {
        for(int i=0;i<c.size();i++)
        {
            add(c.get(i));
        }
        return true;
    }

    private void ensureCapacity() {
        int newSize = (size * 3)/2 + 1;
        list= Arrays.copyOf(list, newSize);
    }

    public E get(int index) throws IndexOutOfBoundsException{
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E)list[index];
    }



    //removes first occurance of an element
    boolean	contains(E element)
    {
        for(int i=0;i<size;i++)
        {
            if(list[i]==element)
            {
                return true;
            }
        }
        return false;
    }



    public int size()
    {
        return size;
    }


    int	indexOf(E e)
    {
        if(contains(e))
        {int i;
            for(i=0;i<size;i++)
            {
                if(list[i]==e)
                    break;
            }
            return i;
        }
        return -1;
    }


    int	lastIndexOf(E e)
    {
        if(contains(e))
        {int i;
            for(i=size-1;i>=0;i--)
            {
                if(list[i]==e)
                    break;
            }
            return i;
        }
        return -1;
    }

    boolean	isEmpty()
    {
        if(size==0)
            return true;
        return false;
    }



    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 0; i < size ;i++) {
            sb.append(list[i].toString());
            if(i<size-1){
                sb.append(",");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    E[] toArray()
    {
        return (E[])list;
    }

    public boolean remove(E item) {
        try{
            int index=indexOf(item);
            remove(index);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public E remove(int i) throws IndexOutOfBoundsException
    {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        int t=i;
        while(i<size-1)
        {
            list[i]=list[i+1];
            i++;
        }
        Arrays.fill(list,size-1, size, null);
        size--;
        return (E)list[t];

    }


    public void clear()
    {
        if (size > 0)
        {
            // Allow for garbage collection.
            Arrays.fill(list,0, size, null);
            size = 0;
        }
    }


}
