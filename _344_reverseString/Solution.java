package _344_reverseString;
class Solution { // 反转字符串
    public void fun1(char[] s) {
        char c;
        for (int i = 0; i < s.length / 2; i++) {
            c = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = c;
        }
    }

    public void reverseString(char[] s) {
        fun1(s);
    }
}