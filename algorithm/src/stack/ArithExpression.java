package stack;

/**
 * @author Yuno
 * @create 2020/11/8-15:50
 */
public class ArithExpression {
    private static Operators operators;//运算符集合
    static{
        operators = new Operators();
    }
    public ArithExpression(String infix){
        StringBuffer postfix;//转换成后缀表达式
        postfix = toPostfix(infix);
        System.out.println("postfix=\"" + postfix + "\"\nvalue=" + toValue(postfix));
    }

    public StringBuffer toPostfix(String infix){//返回将infix中缀表达式转换成的后缀表达式
        Stack<String> stack = new SeqStack<String>(infix.length());//运算符栈，顺序栈
        StringBuffer postfix = new StringBuffer(infix.length()*2);//后缀表达式字符串
        int i = 0;
        while(i < infix.length()){
            char ch = infix.charAt(i);
            if(ch >= '0' && ch <= '9'){//数字，添加到后缀表达式，没有正负符号
                while(i < infix.length() && (ch = infix.charAt(i)) >= '0' && ch <= '9'){
                    postfix.append(ch + "");
                    i++;
                }
                postfix.append(" ");//添加空格作为数值之间的分隔符
            }
            else{
                switch(ch){
                    case ' '://跳过空格
                        i++;
                        break;
                    case '('://左括号，入栈
                        stack.push(ch + "");
                        i++;
                        break;
                    case ')'://右括号，出栈，直到出栈运算符为左括号
                        String out = "";
                        while((out = stack.pop()) != null && !out.equals("(")){
                            postfix.append(out);
                        }
                        i++;
                        break;
                    default:
                        while(!stack.isEmpty() && !stack.peek().equals("(") && operators.compare(ch + "", stack.peek()) >= 0){
                            postfix.append(stack.pop());//出栈运算符添加到后缀表达式
                        }
                        stack.push(ch + "");//当前运算符入栈
                        i++;
                }
            }
        }
        while(!stack.isEmpty()){
            postfix.append(stack.pop());//所有运算符出栈
        }
        return postfix;
    }

    public static int toValue(StringBuffer postfix){//计算后缀表达式的值
        Stack<Integer> stack = new LinkedStack<Integer>();//操作数栈，链式栈
        int value = 0;
        for(int i = 0; i < postfix.length(); i++){//逐个检查后缀表达式中的字符
            char ch = postfix.charAt(i);
            if(ch >= '0' && ch <= '9'){//遇到数字字符
                value = 0;
                while(ch >= '0' && ch <= '9'){//将整数字符串转换为整数型，没有符号，以空格结束
                    value = value * 10 + ch - '0';
                    ch = postfix.charAt(++i);
                }
                stack.push(value);//new Integer（value）整数对象入栈，java自动将int整数封装成Integer对象
            }
            else{
                if(ch != ' '){//约定操作数后有一个空格分隔
                    int y = stack.pop(), x = stack.pop();
                    value = operators.operate(x, y, ch + "");//根据运算符分别计算
                    System.out.print(x + (ch + "") + y + "=" + value + ", ");//显示运算过程
                    stack.push(value);//运算结果入栈
                }
            }
        }
        return stack.pop();//返回运算结果
    }

    public static void main(String[] args) {
        int value = ArithExpression.toValue(new StringBuffer("1 2 3 4 - * + 5 +"));
        System.out.println(value);
    }
}
