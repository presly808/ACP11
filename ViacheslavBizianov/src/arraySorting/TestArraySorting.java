package arraySorting;


public class TestArraySorting {
    public static void main(String[] args) {

        Array a = new Array();
        int[] array1 = new int[]{55,53,15,34,32,5,17,78,56,23};
        int[] array2 = new int[]{55,53,15,34,32,5,17,78,56,23};
        int[] array3 = new int[]{55,53,15,34,32,5,17,78,56,23};

        System.out.println("Bubble sorting");

        a.bubbleSort(array1);

        for (int i : array1){
            System.out.print(i + " ");
        }

        System.out.println("\nSelection sorting");

        a.selectionSort(array2);

        for (int i : array2){
            System.out.print(i + " ");
        }

        System.out.println("\nInsertion sorting");

        a.selectionSort(array3);

        for (int i : array3) {
            System.out.print(i + " ");
        }
    }
}
