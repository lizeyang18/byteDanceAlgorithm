package byteDance;

/**
 * Created by lizeyang on 2020/5/15.
 * 翻转字符串中的单词
 */
public class test27 {
    public static String reverseWord(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int l = 0,r = 0;
        while(r<chars.length){
            if(chars[l] ==' '){
                l++;
                r++;
            }else if(chars[r]==' '){
                reverse(chars,l,r-1);
                l = ++r;
            }else if(r == chars.length-1){
                reverse(chars,l,r);
            }else{
                r++;
            }
        }
        s = String.valueOf(chars).replaceAll("\\s+"," ").trim();
        return s;
    }

    public static void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        String str = "  I'm a student.";
        System.out.println(reverseWord(str));
    }
}
