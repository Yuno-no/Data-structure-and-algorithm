package Rrute_Force;

/**
 * @author Yuno
 * @create 2020/10/17-15:12
 */

//将target串中所有与pattern匹配的子串全部替换成s，返回替换后的target
public class ReplaceAll {
    StringBuffer target;
    String pattern;
    String s;
    public ReplaceAll(StringBuffer target, String pattern, String s){
        this.target = target;
        this.pattern = pattern;
        this.s = s;
    }

    public StringBuffer replace(){
        int i = target.indexOf(pattern);

        while(i != -1){
            target.delete(i, i + pattern.length());
            target.insert(i, s);
            i = target.indexOf(pattern, i + s.length());
        }
        return target;
    }

    public static void main(String[] args) {
        StringBuffer target = new StringBuffer("aaaaaaaa");
        String pattern = "a";
        String s = "cb";
        System.out.println(new ReplaceAll(target, pattern, s).replace());
    }
}
