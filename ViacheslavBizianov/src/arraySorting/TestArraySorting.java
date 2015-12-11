package arraySorting;


public class TestArraySorting {
    public static void main(String[] args) {

        Array a = new Array();
        int[] array1 = new int[]{55,53,15,34,32,5,17,78,56,23};
        int[] array2 = new int[]{55,53,15,34,32,5,17,78,56,23};
        int[] array3 = new int[]{55,53,15,34,32,5,17,78,56,23};
        int[] array4 = new int[]{55,53,15,34,32,5,17,78,56,23};

        System.out.println("Bubble sorting");
        a.bubbleSort(array1);
        display(array1);

        System.out.println("\nSelection sorting");
        a.selectionSort(array2);
        display(array2);

        System.out.println("\nInsertion sorting");
        a.selectionSort(array3);
        display(array3);

        System.out.println("\nQuick sorting");
        a.quickSort(array4,0,array4.length-1);
        display(array4);
    }

    private static void display(int[] array) {
        for (int i : array){
            System.out.print(i + " ");
        }
    }
}
