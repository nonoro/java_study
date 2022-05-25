package ch14.stream;

import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class Student11 {
    String name;
    boolean isMale;     //  성별
    int hak;            //  학년
    int ban;            //  반
    int score;

    Student11(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }

    String getName() {
        return name;
    }

    boolean isMale() {
        return isMale;
    }

    int getHak() {
        return hak;
    }

    int getBan() {
        return ban;
    }

    int getScore() {
        return score;
    }

    public String toString() {
        return String.format("[%s, %s, %d학년, %d반, %3d점]", name, isMale ? "남":"여", hak, ban, score);
    }
    //  groupingBy()에 사용
    enum Level { HIGH, MID, LOW }       //  성적을 상, 중, 하 세 단계로 분류
}

class StreamEx11 {
    public static void main(String[] args) {
        Student11[] stuArr = {
                new Student11("나자바", true, 1, 1, 300),
                new Student11("김지미", false, 1, 1, 250),
                new Student11("김자바", true, 1, 1, 200),
                new Student11("이지미", false, 1, 2, 150),
                new Student11("남자바", true, 1, 2, 100),
                new Student11("안지미", false, 1, 2, 50),
                new Student11("황지미", false, 1, 3, 100),
                new Student11("강지미", false, 1, 3, 150),
                new Student11("이자바", true, 1, 3, 200),

                new Student11("나자바", true, 2, 1, 300),
                new Student11("나자바", false, 2, 1, 250),
                new Student11("나자바", true, 2, 1, 200),
                new Student11("나자바", false, 2, 2, 150),
                new Student11("나자바", true, 2, 2, 100),
                new Student11("나자바", false, 2, 2, 50),
                new Student11("나자바", false, 2, 3, 100),
                new Student11("나자바", false, 2, 3, 150),
                new Student11("나자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<Student11>> stuBySex = Stream.of(stuArr).collect(partitioningBy(Student11::isMale));

        List<Student11> maleStudent = stuBySex.get(true);
        List<Student11> femaleStudent = stuBySex.get(false);

        for (Student11 s : maleStudent) {
            System.out.println(s);
        }

        for (Student11 s : femaleStudent) {
            System.out.println(s);
        }

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr).collect(partitioningBy(Student11::isMale, counting()));

        System.out.println("남학생 수 :" + stuNumBySex.get(true));
        System.out.println("여학생 수 :" + stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<Student11>> topScoreBySex = Stream.of(stuArr).collect(partitioningBy(Student11::isMale, maxBy(comparingInt(Student11::getScore))));

        System.out.println("남학생 1등 :" + topScoreBySex.get(true));
        System.out.println("여학생 1등 :" + topScoreBySex.get(false));

        Map<Boolean, Student11> topScoreBySex2 = Stream.of(stuArr).collect(partitioningBy(Student11::isMale, collectingAndThen(maxBy(comparingInt(Student11::getScore)), Optional::get)));

        System.out.println("남학생 1등 :" + topScoreBySex2.get(true));
        System.out.println("여학생 1등 :" + topScoreBySex2.get(false));

        System.out.printf("%n4. 다중분할(성별 불합격자, 100점 이하)%n");

        Map<Boolean, Map<Boolean, List<Student11>>> failedStuBySex = Stream.of(stuArr).collect(partitioningBy(Student11::isMale, partitioningBy(s -> s.getScore() <= 100)));

        List<Student11> failedMaleStu = failedStuBySex.get(true).get(true);
        List<Student11> failedFemaleStu = failedStuBySex.get(false).get(true);

        for (Student11 s : failedMaleStu) {
            System.out.println(s);
        }

        for (Student11 s : failedFemaleStu) {
            System.out.println(s);
        }
    }
}
