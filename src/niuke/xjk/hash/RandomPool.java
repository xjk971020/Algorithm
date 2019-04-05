package niuke.xjk.hash;

import java.util.HashMap;

/**
 * @author xjk
 * @date 2019/3/31 -  20:19
 * 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。 getRandom()：
 * 等概率随机返回结构中的任何一个key
 **/
public class RandomPool {
    public static class Pool<K> {
        HashMap<Integer,K> indexKeyMap;
        HashMap<K,Integer> keyIndexMap;
        int size;
        public Pool() {
            indexKeyMap = new HashMap<>();
            keyIndexMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (!indexKeyMap.containsKey(key)) {
                indexKeyMap.put(size,key);
                keyIndexMap.put(key,size++);
            }
        }

        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int keyIndex = keyIndexMap.get(key);
                int lastIndex = --size;
                K indexKey = indexKeyMap.get(lastIndex);
                indexKeyMap.put(keyIndex,indexKey);
                keyIndexMap.put(indexKey,keyIndex);
                indexKeyMap.remove(indexKey);
                keyIndexMap.remove(lastIndex);
            }
        }

        public K getRandom() {
            if (size == 0) {
                return null;
            }
            int index = (int) (Math.random()*size);
            return indexKeyMap.get(index);
        }
    }
}
