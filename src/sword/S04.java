package sword;

import java.util.stream.Stream;

public class S04 {
    /**
     * 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * 数据范围:0 \le len(s) \le 1000 \0≤len(s)≤1000 。保证字符串中的字符为大写英文字母、小写英文字母和空格中的一种。
     * 进阶：时间复杂度 O(n)\O(n)  ,空间复杂度 O(n) \O(n)
     */


    public static void main(String[] args) {
        String target = "hello world ";
        System.out.println(replaceSpace(target));
    }

    public static String replaceSpace (String s) {
        if(null == s || s.isEmpty())
            return null;
        int blankCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                blankCount++;
        }

        int newSize = s.length() + 2 * blankCount;
        char[] res = new char[newSize];
        int x = res.length - 1;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                res[x] = '0';
                x--;
                res[x] = '2';
                x--;
                res[x] = '%';
                x--;
            } else {
                res[x] = s.charAt(i);
                x--;
            }
        }
        return String.valueOf(res);
    }
}
