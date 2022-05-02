package ch09.utilClasses;

import java.util.regex.*;               //  Pattern과 Matcher가 속한 패키지

public class RegularEx02 {
    public static void main(String[] args) {
        String[] data2 = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};
        String[] pattern2 = {".*", "c[a-z]*" , "c[a-z]", "c[a-zA-Z]", "c[a-zA-z0-9]", "c.", "c.*", "c//.", "//w", "c//d", "c.*t", "[b|c].*", ".*a.*", ".*a.+", "[b|c].{2}"};

        for (int x = 0; x < pattern2.length; x++) {
            Pattern p2 = Pattern.compile(pattern2[x]);
            System.out.print("Pattern : " + pattern2[x] + " 결과: ");
            for (int i = 0; i < data2.length; i++) {
                Matcher m = p2.matcher(data2[i]);
                if (m.matches()) {
                    System.out.print(data2[i] + ",");
                }
            }
            System.out.println();
        }
    }               //  public static void main(String[] args) {
}
