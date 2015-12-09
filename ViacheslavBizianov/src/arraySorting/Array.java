package arraySorting;


public class Array {

    public void bubbleSort(int[] array){
        for (int i=array.length-1; i>0; i--){
            for (int j=0; j<i; j++){
              if (array[j] > array[j+1]){
                  swap(array, j, j+1);
              }
            }
        }
    }

    public void selectionSort(int[] array){
        for (int i=0; i<array.length-1; i++){
            int min = array[i];
            int index_min = i;
            for (int j=i; j<array.length; j++){
                if (array[j] < min){
                    min = array[j];
                    index_min = j;
                }
            }
            if (i != index_min) {
                swap(array, i, index_min);
            }
        }
    }

    public void insertionSort(int[] array){
        for (int i=1; i<array.length; i++){
            for (int j=i-1; j>0; j--){
                if (array[i] < array[j]){
                    swap(array, i, j);
                    break;
                }
            }
        }
    }

    private void swap(int[] array, int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }
}
