package ch09.javaLangPackage;

import java.util.StringJoiner;

class StringEx04 {
    public static void main(String[] args) {
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");

        System.out.println(String.join("-", arr));

        StringJoiner sj = new StringJoiner("/", "[", "]");      //  new StringJoiner(구분자, 처음, 끝)
        for (String s : arr) {
            sj.add(s);
        }
            System.out.println(sj.toString());
        }

    }

