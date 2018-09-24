package data_structures;

public class MyArray {

    public static void insertElementAtIndex(int[] myarray, int startIndex, int targetIndex) {
        int value = myarray[startIndex];
        if (startIndex == targetIndex) {
            return;
        } else if (startIndex < targetIndex) {
            for (int i=startIndex+1; i<=targetIndex; i++) {
                myarray[i-1] = myarray[i];
            }
            myarray[targetIndex] = value;
        } else {
            for (int i=startIndex-1; i>=targetIndex; i--) {
                myarray[i+1] = myarray[i];
            }
            myarray[targetIndex] = value;
        }
    }

    public static int[] insertExtraElementAtIndex(int[] myarray, int index, int value) {
        int[] newArray = new int[myarray.length * 2];

        for(int i=0; i<index; i++) {
            newArray[i] = myarray[i];
        }
        newArray[index] = value;

        for(int i=index+1; i<newArray.length; i++) {
            newArray[i] = myarray[i-1];
        }

        return newArray;
    }

    public static int[] appendElement(int[] myarray, int value) {
        return insertExtraElementAtIndex(myarray, myarray.length, value);
    }

    public static void printAllElements(int[] myarray) {
        System.out.print("[");
        for(int i=0; i<myarray.length; i++) {
            System.out.print(myarray[i]);
            if (i != myarray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
