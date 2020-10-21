import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 2, 4, 6, 1, 3, 2, 6};
        print(sort(array));
    }

    /**
     * печать элментов массива
     * @param array массив целых чисел
     */
    private static void print(int[] array){
        for (int i : array){
            System.out.printf("%d ", i);
        }
    }

    /**
     *
     * @param array несортированный массив
     * @return отсортированный массив
     */
    private static int[] sort(int[] array) {
        int length = array.length;
        if (length < 2)
            return array;
        int middle = length / 2;
        return merge(sort(Arrays.copyOfRange(array, 0 , middle)),
                sort(Arrays.copyOfRange(array, middle, length)));
    }

    /**
     *
     * @param array_1 первый подмассив
     * @param array_2 второй подмассив
     * @return resultArr отсортированный подмассив
     */
    private static int[] merge(int[] array_1, int[] array_2) {
        int len_1 = array_1.length;
        int len_2 = array_2.length;
        int len = len_1 + len_2;

        int count_1 = 0, count_2 = 0;
        int[] resultArr = new int[len];

        for (int i = 0; i < len; i++) {
            if (count_2 < len_2 && count_1 < len_1) {
                if (array_1[count_1] > array_2[count_2]) {
                    resultArr[i] = array_2[count_2++];
                } else {
                    resultArr[i] = array_1[count_1++];
                }
            } else {
                if (count_2 < len_2){
                    resultArr[i] = array_2[count_2++];
                } else {
                    resultArr[i] = array_1[count_1++];
                }
            }
        }
        return resultArr;
    }
}
