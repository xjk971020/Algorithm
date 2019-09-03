package leetcode;

import java.util.LinkedList;

/**
 * @Author:cathetine
 * @Date:19-9-3
 * @Time:下午8:05
 * 406. 根据身高重建队列
 *
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        //冒泡排序
        for(int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (people[i][0] < people[j][0]) {
                    int[] temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
                if (people[i][0] == people[j][0] && people[i][1] > people[j][1]) {
                    int[] temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
            }
        }
        LinkedList<int[]> linkedList = new LinkedList<>();
        for (int[] i : people) {
            linkedList.add(i[1], i);
        }
        return linkedList.toArray(new int[people.length][2]);
    }
}
