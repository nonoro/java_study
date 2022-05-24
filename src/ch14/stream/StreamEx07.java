package ch14.stream;

import java.util.*;
import java.util.stream.*;

class StreamEx07 {
    public static void main(String[] args) {
        Student7[] stuArr = {
                new Student7("이자바", 3, 300),
                new Student7("김자바", 1, 200),
                new Student7("안자바", 2, 100),
                new Student7("박자바", 2, 150),
                new Student7("소자바", 1, 200),
                new Student7("나자바", 3, 290),
                new Student7("감자바", 3, 180)
        };

        Stream<Student7> stuStream = Stream.of(stuArr);

        //  Student::getBan => 람다식 변환  (Student s) -> s.getBan()
        stuStream.sorted(Comparator.comparing(Student7::getBan))     //  반별 정렬
//                .thenComparing(Comparator.naturalOrder()))      //  기본 정렬
                .forEach(System.out::println);

        stuStream = Stream.of(stuArr);     //  스트림 다시생성
        IntStream stuScoreStream = stuStream.mapToInt (Student7::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count=" + stat.getCount());
        System.out.println("sum=" + stat.getSum());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min=" + stat.getMin());
        System.out.println("mac=" + stat.getMax());
    }
}

class Student7 implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    Student7(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName() {
        return name;
    }

    int getBan() {
        return ban;
    }

    int getTotalScore() {
        return totalScore;
    }

    //  총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
