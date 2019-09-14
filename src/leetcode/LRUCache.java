package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author:cathetine
 * @Date:19-9-14
 * @Time:下午12:45
 * 146. LRU缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> data;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (data.containsKey(key)) {
            int value = data.get(key);
            data.remove(key);
            data.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            data.remove(key);
        } else if (data.size() == capacity) {
            Iterator<Map.Entry<Integer, Integer>> iterator = data.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        data.put(key, value);
    }
}
