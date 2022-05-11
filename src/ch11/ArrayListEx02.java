package ch11;

import java.util.*;

class ArrayListEx02 {
    public static void main(String[] args) {
        final int LIMIT = 10;       //  자르고자 하는 글자의 개수를 지정한다.
        String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()zzz";
        int length = source.length();

        List list = new ArrayList(length/LIMIT + 10);       //  크기를 약간 여유있게 잡는다.

        for (int i = 0; i< length; i += LIMIT) {    //  처음에 인덱스 0~10인데 이것은 source에서 인덱스 10 은 a이다 0~9까지가 갯수가 10개라고 인덱스 10 이 9라고 착각하지말것!
            if (i + LIMIT < length) {               //  인덱스 10은 저렇게 갯수로보면 실젲로 0~10까지 11개가 있는 것이다.
                list.add(source.substring(i, i + LIMIT));
            } else {
                list.add(source.substring(i));
            }
        }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }

