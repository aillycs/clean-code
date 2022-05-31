package sword;

public class S10 {
    public static void main(String[] args) {
        int res = NumberOf1(-2147483648);
    }

    public static int NumberOf1(int n) {
        int count = 0;
        long tool = 1;
        while(tool -1 <= Integer.MAX_VALUE) {
            if ((n & tool) >= 1)
                count++;
            tool = tool << 1;
        }
        return count;
    }
}
