package ch05.part_b;

public class ArrayEx18 {
    public static void main(String[] args) {
        int[] [] score = {
                { 100, 100, 100 }
                , { 20, 20, 20 }
                , { 30, 30, 30 }
                , { 40, 40, 40 }
        };
        int sum = 0;

        for(int i = 0; i < score.length; i++) {                // 지금 위의 배열은 4행 3열 따라서 score.length가 4행이니까 4이고
            for(int j = 0; j < score[i].length; j++) {         // score[i].length는 3열이니까 3이다 얘는 각각의 행의 길이가 같기 때문에 i대신 0을 넣어도 되지만 각각 행의 길이가 다르면 0을 넣으면 안된다.
                System.out.printf("score[%d][%d] = %d%n", i, j, score[i][j]);
            }
        }

        for (int[] tmp : score) {
            for(int i : tmp) {
                sum += i;
            }
        }
        System.out.println("sum=" + sum);
    }
}
