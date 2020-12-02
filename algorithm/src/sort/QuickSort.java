package sort;

/**
 * @author Yuno
 * @create 2020/12/2-19:12
 */
public class QuickSort {
    private static void quickSort(int[] keys, int begin, int end){
        if (begin >= 0 && begin < end && end < keys.length){//序列有效
            int i = begin, j = end;//i、j下标分别从子序列的前后两端开始
            int x = keys[i];
            while (i != j){
                while (i < j && keys[j] >= x){//从后向前寻找较小值移动，不移动与基准值相等的元素
                    j--;
                }
                if (i < j){
                    keys[i++] = keys[j];//子序列后端较小元素向前移动
                }
                while (i < j && keys[i] <= x){//从前向后寻找较大值移动，不移动与基准值相等的元素
                    i++;
                }
                if (i < j){
                    keys[j--] = keys[i];//子序列前端较大元素向后移动
                }
            }
            keys[i] = x;//基准值x到达最终位置
            quickSort(keys, begin, j - 1);//前端子序列再排序，递归调用
            quickSort(keys, i+1, end);//后端子序列在排序，递归调用
        }
    }
    public static void quickSort(int[] keys){
        quickSort(keys, 0, keys.length -1);
    }

    public static void main(String[] args) {
        int[] keys = {39, 39, 97, 75, 61, 19, 26, 49};
        quickSort(keys);
        for (int x : keys){
            System.out.print(x + " ");
        }
    }
}
