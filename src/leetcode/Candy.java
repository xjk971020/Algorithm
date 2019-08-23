package leetcode;

import java.util.Arrays;

/**
 * @author:xjk 2019/8/23 11:11
 * candy
 * leetcode
 * 题目描述
 * 有N个小朋友站在一排，每个小朋友都有一个评分
 * 你现在要按以下的规则给孩子们分糖果：
 * 每个小朋友至少要分得一颗糖果
 * 分数高的小朋友要他比旁边得分低的小朋友分得的糖果多
 * 你最少要分发多少颗糖果？
 *
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        Arrays.fill(count, 0);
        int sum = 0;
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] > ratings[i+1]) {
                count[i]++;
            }
        }
        for (int i = count.length - 1; i > 0; i--) {
            if (ratings[i] > ratings[i-1]) {
                count[i]++;
            }
            sum += count[i];
        }
        sum += count[0];
        return sum;
    }
}
