package niuke.xjk.dynamicProgramming;

/**
 * @author xjk
 * @date 2019/4/25 -  19:32
 * 打印一个字符串的全部子序列
 **/
public class PrintAllSubsquences {

    public static void print(char[] str,int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        print(str,i + 1,res + String.valueOf(str[i]));
        print(str,i + 1,res);
    }

    public static void main(String[] args) {
        String test = "abc";
        print(test.toCharArray(),0,"");
    }
}
