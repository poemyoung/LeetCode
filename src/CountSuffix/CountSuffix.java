package CountSuffix;

import java.util.EmptyStackException;

/**
 * 计算后缀表达式算法
 * 来自：数据结构与算法分析JAVA描述习题
 * 注意：只处理整数
 * 两个数之间用空格隔开
 */
public class CountSuffix {

    //待计算的表达式
    char[] expression;
    //计算的最终结果
    int results;
    //计算用的栈
    Stack stk;
    public CountSuffix(String str){
        expression = str.toCharArray();
        stk = new Stack();
        deal();;
    }
    /**
     * 维护一个内部栈类
     */
    private static class Stack{
        //记录栈最大长度
        int maxSize;
        //记录栈长度
        int size;
        //维护的栈数组
        Object[] elements;
        //无参构造函数
        public Stack(){
            maxSize = 4;
            elements = new Object[maxSize];
            size = 0;
        }
        //有参构造函数
        public Stack(int maxSize){
            this.maxSize = maxSize;
            elements = new Object[maxSize];
            size = 0;
        }

        //入栈方法
        public void push(Object a){
            //超界扩容
            if(size == maxSize){
                maxSize = maxSize * 2;
                Object[] newElements = new Object[maxSize];
                //扩容过程
                System.arraycopy(elements, 0, newElements, 0, maxSize / 2);
                elements = newElements;
            }
            //不超界或扩容完成
            elements[size++] = a;
        }
        //出栈方法
        public Object pop(){
            if(size == 0){
                throw new EmptyStackException();
            }
            else {
                return elements[--size];
            }
        }
        //获取栈顶元素
        public Object peek(){
            if(size == 0){
                System.out.println("堆栈为空");
                return null;
            }
            else {
                return elements[size - 1];
            }
        }
    }

    /**
     * 处理方法
     */
    public void deal(){
        //临时数组，用于保存一个数(整数）
        char[] temp = new char[9];
        //临时数组位置指针
        int k = 0;
        //flag,表示字符数组中是否有数字(即数字还未处理完）
        boolean f = false ;
        //循环入栈
        for (int i = 0;i < expression.length;i++){
            //判断是数字就放入temp数组中
            if(Character.isDigit(expression[i])){
                f = true;
                temp[k++] = expression[i];
            }else if(expression[i] == ' '){
                //压栈，清空
                if(f) {
                    stk.push(Integer.parseInt(String.copyValueOf(temp,0,k)));
                    temp = new char[9];
                    k = 0;
                    f = false;
                }
            }
            else {
                //判断前面是不是数字
                if(f){
                    stk.push(Integer.parseInt(String.copyValueOf(temp,0,k)));
                    temp = new char[9];
                    k = 0;
                    f = false;
                }
                //判断非数字就出栈计算
                //计算结果
                int res;
                switch (expression[i]){
                    case '+':
                        res = (int)stk.pop() + (int)stk.pop();
                        break;
                    case '-':
                        //先弹出来的是减数，后弹出来的是被减数
                        int sub = (int)stk.pop();
                        res  = (int)stk.pop() - sub;
                        break;
                    case '*':
                        res  = (int)stk.pop() * (int)stk.pop();
                        break;
                    case '/':
                        //先弹出来的是除数，后弹出来的是被除数
                        int div = (int)stk.pop();
                        res = (int)stk.pop() / div;
                        break;
                    default:
                        System.out.println("输入不合法！");
                        return;
                }
                stk.push(res);
            }
        }

        //算到最后栈中只有结果
        if(stk.size  == 1){
            results = (int)stk.pop();
        }else {
            System.out.println("错了错了");
            return;
        }
    }

    public int getResults(){
        return results;
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        String t = "21 32 8 / 3 1 + *-";
        CountSuffix test = new CountSuffix(t);
        System.out.println(test.getResults());
    }
}
