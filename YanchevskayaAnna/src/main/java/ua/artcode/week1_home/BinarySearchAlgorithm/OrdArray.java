package ua.artcode.week1_home.BinarySearchAlgorithm;

/**
 * Created by 1 on 29.09.2015.
 */
public class OrdArray {
    private long[] a;
    private  int nElems;

    public OrdArray (int max)
    {
        a = new long[max];
        nElems = 0;
    }

    public int size()
    { return nElems;}

    public int find(long searchKey)
    {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true)
        {
            curIn = (lowerBound + upperBound)/2;
            if(a[curIn]==searchKey)
                return curIn; //Элемент найден
            else if (lowerBound > upperBound)
                return nElems; //Элемент не найден
            else               //Деление диапазона
            {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1; // В верхней половине
                else
                    upperBound = curIn - 1; // В нижней половине
            }
        }
    }

    public void insert(long value)
    {
        int j;
        for (j=0; j < nElems; j++)
            if (a[j] > value)
                break;
        for (int k = nElems; k > j; k--)
            a[k] = a[k-1];
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value)
    {
        int j = find(value);
        if (j==nElems)
            return false;
        else {
           for (int k = j; k < nElems; k++)
                a[k] = a[k + 1];
           nElems--;
           return  true;
        }
    }

    public  void display()
    {
        for (int j=0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println();
    }


}
