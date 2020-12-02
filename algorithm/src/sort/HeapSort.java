package sort;

import javax.swing.*;

/**
 * @author Yuno
 * @create 2020/12/2-19:33
 */
public class HeapSort {
    private static void swap(int[] keys, int i, int j){//交换keys[i]和keys[j]元素
        int temp = keys[j];
        keys[j] = keys[i];
        keys[i] = temp;
    }
    public static void heapSort(int[] keys){//堆排序（降序）
        for (int i = keys.length / 2 - 1; i >= 0; i--){//创建最小堆，根节点值最小
            sift(keys, i, keys.length - 1);
        }
        for (int i = keys.length - 1; i > 0; i--){//堆排序，每趟将最小值交换到最后，在调整成最小值
            swap(keys, 0, i);
            sift(keys, 0, i - 1);
        }
    }
    private static void sift(int[] keys, int parent, int end){
        int child = 2 * parent + 1;//child是parent的左孩子
        int x = keys[parent];//当前子树的原根植
        while (child <= end){
            if (child < end && keys[child + 1] < keys[child]){//若左孩子值更小
                child++;//child记住孩子值较小者
            }
            if (x > keys[child]){//若父节点值较大
                keys[parent] = keys[child];//则将较小孩子结点值上移
                parent = child;//parent、child两者都向下一层
                child = 2 * parent + 1;
            }
            else break;
        }
        keys[parent] = x;//x调整后的位置
    }

    public static void main(String[] args) {
        int[] keys = {81, 76, 19, 49, 97, 81, 13, 35};
        heapSort(keys);
        for (int x : keys){
            System.out.print(x + " ");
        }
    }
}
