package 力扣.力扣杯.秋2019.Day5;

import java.util.HashMap;

public class LCP1061 {
    /*这里咋一看是可以的,,但是细想是行不通的
     * 如果哈希表某个val对应的最小值,未必是最小,可能是val对val的多次映射*/
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuffer res = new StringBuffer();
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, (char) Math.min(map.getOrDefault(c1, c1), Math.min(c1, c2)));
            System.out.println(c1 + "-" + map.get(c1));
            map.put(c2, (char) Math.min(map.getOrDefault(c2, c2), Math.min(c1, c2)));
            System.out.println(c2 + "-" + map.get(c2));
        }
        for (int i = 0; i < baseStr.length(); i++) {
            res.append(map.getOrDefault(baseStr.charAt(i), baseStr.charAt(i)));
        }
        return res.toString();
    }

    /**
     * 并查集
     *
     * @param s1
     * @param s2
     * @param baseStr
     * @return 一个字符与多个字符等价, , 实际上是考察并查集的union
     * `UF`的 `union`方法需要改造,使得等价的两个字符union,根节点指向字典序更小
     */
    public String smallestEquivalentString2(String s1, String s2, String baseStr) {
        int n = s1.length();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        //1.初始化UF类,26个英文字母
        UF uf = new UF(26);
        //2.遍历s1,s2将等价的字符链接起来
        for (int i = 0; i < n; i++) {
            char c1 = chars1[i];
            char c2 = chars2[i];
            uf.union(c1 - 'a', c2 - 'a');
        }
        //3.遍历baseStr,将每个字符找到字典序最小的等效字符,并拼接
        StringBuffer res = new StringBuffer();
        for (char c : baseStr.toCharArray()) {
            char s = (char) (uf.findParent(c - 'a') + 'a');
            res.append(s);
        }
        return res.toString();
    }
}

class UF {
    private int[] parent;//记录父节点的数组
    private int count;//不等同节点的个数

    public UF(int n) {
        parent = new int[n];
        //这里让每个节点的父节点都是自己
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;//设置大小
    }

    /**
     * @param x 某个节点
     * @return 这个节点的爷爷变成父亲(不断循环), 不断往上走一层, 只为了找到根源节点
     */
    public int findParent(int x) {
        while (parent[x] != x) {//当此前节点不是父节点时
            //让`父亲`变`爷爷`
            parent[x] = parent[parent[x]];
            //往上走一层
            x = parent[x];
        }
        return x;
    }

    /**
     * @param p
     * @param q
     * @return 是否是同一个根源节点
     */
    public boolean isConnected(int p, int q) {
        return findParent(p) == findParent(q);
    }

    /**
     * 更改union方法
     * 合并两个节点,并设置根源节点都指向更小的根源节点
     *
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pParent = findParent(p);
        int qParent = findParent(q);
        if (pParent == qParent) {
            return;
        }
        //让父节点指向更小的节点
        if (pParent < qParent) {
            parent[qParent] = pParent;
        } else {
            parent[pParent] = qParent;
        }
        --count;//合并之后,,更新大小
    }

    /**
     * @return 返回count
     */
    public int getCount() {
        return count;
    }
}
