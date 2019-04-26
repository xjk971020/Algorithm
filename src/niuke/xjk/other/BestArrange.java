package niuke.xjk.other;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xjk
 * @date 2019/4/25 -  8:14
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目 的宣讲。
 * 给你每一个项目开始的时间和结束的时间(给你一个数 组，里面 是一个个具体的项目)，
 * 你来安排宣讲的日程，要求会 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次
 **/
public class BestArrange {
    public static class Program {
        int start;
        int end;
        public Program(int start,int end) {
            this.start  = start;
            this.end = end;
        }
    }
    public static class eariliestEndComparator implements Comparator<Program> {

        /**
         * 根据最早结束时间对Program数组进行升序排序
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Program o1, Program o2) {
            return o2.end - o1.end;
        }
    }

    /**
     *
     * @param program  项目数组
     * @param cur  当前时间
     * @return
     */
    public static int bestArrange(Program[] program,int cur) {
        Arrays.sort(program,new eariliestEndComparator());
        int result = 0;
        for (int i = 0;i < program.length; ++i) {
            if (cur < program[i].start) {
                ++result;
                cur = program[i].end;
            }
        }
        return result;
    }
}
