package ch14.stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamEx10 {
    public static void main(String[] args) {
        Student10[] stuArr = {
                new Student10("이자바", 3, 300),
                new Student10("김자바", 1, 200),
                new Student10("안자바", 2, 100),
                new Student10("박자바", 2, 150),
                new Student10("소자바", 1, 200),
                new Student10("나자바", 3, 290),
                new Student10("감자바", 3, 180),
        };

        //  학생 이름만 뽑아서 List<String>에 저장
        List<String> names = Stream.of(stuArr).map(Student10::getName).collect(Collectors.toList());
        System.out.println(names);

        //  스트림을 배열로 변환
        Student10[] stuArr2 = Stream.of(stuArr).toArray(Student10[]::new);      //   Student10[]::new = s -> s.new student10[]

        for (Student10 s : stuArr2) {
            System.out.println(s);
        }

        //  스트림을 Map<String, Student>로 변환. 학생 이름이 key
        Map<String, Student10> stuMap = Stream.of(stuArr).collect(Collectors.toMap(s -> s.getName(), p -> p));

        for (String name : stuMap.keySet()) {
            System.out.println(name + "-" + stuMap.get(name));
        }

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr).collect(summingInt(Student10::getTotalScore));
        System.out.println("count=" + count);
        System.out.println("totalScore=" + totalScore);

        totalScore = Stream.of(stuArr).collect(reducing(0, Student10::getTotalScore, Integer::sum));
        System.out.println("totalScore=" + totalScore);

        Optional<Student10> topStudent = Stream.of(stuArr).collect(maxBy(Comparator.comparingInt(Student10::getTotalScore)));
        System.out.println("topStuednt=" + topStudent.get());

        IntSummaryStatistics stat = Stream.of(stuArr).collect(summarizingInt(Student10::getTotalScore));
        System.out.println(stat);

        String stuNames = Stream.of(stuArr).map(Student10::getName).collect(joining(",", "{", "}"));
        System.out.println(stuNames);
    }
}

class Student10 implements Comparable<Student10> {
    String name;
    int ban;
    int totalScore;

    Student10(String name, int ban, int totalScore) {
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

    public int compareTo(Student10 s) {
        return s.totalScore - this.totalScore;
    }
}
