package ch09.utilClasses;

import java.util.*;

class RandomEx04 {
    final static int RECORD_NUM = 10;  //  생성할 레코드의 수를 정한다.
    final static String TABLE_NAME = "TEST_TABLE";
    final static String[] CODE1 = {"010", "011", "017", "018", "019"};
    final static String[] CODE2 = {"남자", "여자"};
    final static String[] CODE3 = {"10대", "20대", "30대", "40대", "50대"};

    public static void main(String[] args) {
        for (int i = 0; i < RECORD_NUM; i++) {
            System.out.println(" INSERT INTO " + TABLE_NAME + " VALUES (" + " '" + getRandArr(CODE1) + "'" + ", '" + getRandArr(CODE2) + "'"
            + ", '" + getRandArr(CODE3) + "'" + ", " + getRand(100, 200)    //  100~200 사이의 값을 얻는다.
            + "); ");
        }
    }

    public static String getRandArr(String[] arr) {
        return arr[getRand(arr.length-1)];      //  배열에 저장된 값 중 하나를 반환한다. , -1을 하는 이유는 CODE1의 배열 길이는 5이다 그래서 arr.lengths가 5인데  그럼 getRand(4) 가 된다 그럼 여기서
    }                                              //  getRand 함수로 가면 getRand(0, 4)를 반환해주므로 인덱스 0 1 2 3 4 의 범위 안에 있는 숫자를 랜덤으로 돌려주게된다 getRand는 from 부터 to까지 포함을 하기 때문에 -1을 해준것이다 다른것들은 to는 포함을 안함

    public static int getRand(int n) {
        return getRand(0, n);
    }

    public static int getRand(int from, int to) {
        return (int) (Math.random() * (Math.abs(to-from) + 1)) + Math.min(from, to);
    }
}
