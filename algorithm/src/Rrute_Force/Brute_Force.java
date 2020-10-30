package Rrute_Force;

import java.awt.desktop.SystemEventListener;
import java.lang.annotation.Target;
import java.util.Scanner;

/**
 * @author Yuno
 * @create 2020/10/17-10:19
 */
public class Brute_Force {
    String pattern;
    String target;
    public Brute_Force(String target, String pattern){
        this.pattern = pattern;
        this.target = target;
    }

    public int indexOf(){
        return this.target.indexOf(pattern, 0);
    }

    /*返回目标串target从begin开始的首个与模式串pattern匹配的字符串序号，匹配失败时返回-1
    * 0 <= begin < this.length(). 对begin容错，若begin < 0,则从0开始;若begin序号越界,则查找不动
    * 若pattern == null, 则抛出空对象异常*/
    public int indexOf(int begin){
        int t_len = this.target.length();
        int p_len = this.pattern.length();

        if (begin < 0){//对begin容错，若begin < 0,则从0开始
            begin = 0;
        }
        if (t_len == 0 || t_len < p_len || begin >= t_len){//若目标串空、较短或begin越界，则不需比较
            return -1;
        }
        int t = begin, p = 0;//t,p分别为目标串和模式串的字符下标

        while (t < t_len && p < p_len){//若目标串和模式串的两字符相等，则继续比较后续的字符
            if (target.charAt(t) == pattern.charAt(p)){
                t++;
                p--;
            }
            else{//否则t，p回溯，进行下次匹配
                t = t - p + 1;//目标串下标t退回到下个待匹配子串序号
                p = 0;//模式串下标p退回到0
                if (t > t_len - p_len){//若目标串剩余子串的长度不够，则不再比较
                    break;
                }
            }
        }
        return p == p_len ? t - p_len : -1;//若匹配成功，则返回匹配字符串，否则返回-1
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入目标串:");
        String target = sc.next();
        System.out.println("请输入模式串：");
        String pattern = sc.next();
        Brute_Force bf = new  Brute_Force(target, pattern);
        int n = bf.indexOf();
        if (n != -1){
            System.out.println("匹配到的字符串位于目标串的" + n + "下标位置");
        }else{
            System.out.println("未匹配到字符串");
        }
    }
}
