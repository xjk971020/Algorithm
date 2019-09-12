package niuke.zhenti;

import java.util.Scanner;

/**
 * 2048游戏
 */
public class TwoZeroFourEight {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String solution(String[] input) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            res.append(process(input[i]));
        }
        return res.toString();
    }

    static String process(String result) {
        String res = new String();
        String temo = result;
        result = result.replaceAll(" ", "");
        for (int i = 0; i < result.length() - 1; ++i) {
            if (result.charAt(i) != '0' || result.charAt(i) != ' ') {
                if (result.charAt(i) == result.charAt(i+1)) {
                    int temp = Integer.valueOf(result.substring(i,i+1)) * 2;
                    res = res + " " + temp;
                    i++;
                } else {
                    res = res + " " + result.charAt(i);
                }
            }
        }
        res = res.substring(1);
        while (res.length() < temo.length()) {
            res = res + " 0";
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
        System.out.println(res);
    }
}
