package Rrute_Force;

/**
 * @author Yuno
 * @create 2020/10/17-15:30
 */

//删除target串中所有与pattern匹配的子串，返回删除后的target串
public class RemoveAll {
    StringBuffer target;
    String pattern;

    public RemoveAll(StringBuffer target, String pattern){
        this.target = target;
        this.pattern = pattern;
    }

    public StringBuffer move(){
        int t_len = target.length();
        int p_len = pattern.length();
        int empty = target.indexOf(pattern);//empty为首个与pattern匹配的子串
        int next = empty;

        while (next != -1){//move为待移动子串序号
            int move = next + p_len;
            next = target.indexOf(pattern, move);//next为从move开始的下个匹配子串序号
            while (next > 0 && move < next || next < 0 && move < t_len){//将move~next-1之间的子串向前移动
                target.setCharAt(empty++, target.charAt(move++));
            }
        }
        if (empty != -1){
            target.setLength(empty);
        }
        return target;
    }
}
