package ch07.abstract_class06;

abstract class Player {            //  추상클래스(미완성 클래스, 미완성 설계도)
    abstract void play(int pos);   //  추상 메서드(미완성 메서드)
    abstract void stop();          //  추상 메서드(선언부만 있고 구현부{}가 없는 메서드)
}

//  추상 클래스는 상속을 통해 완성해야 객체 생성가능

class AudioPlayer extends Player {
    void play(int pos) {
        System.out.println(pos + "위치 부터 play합니다.");
    }
    void stop(){                                    //  만약 이게 없으면 이 클래스도 Player클래스로부터 상속받은 선언부들의 몸통을 다 구현하지 못했기 때문에
        System.out.println("재생을 멈춥니다.");        //  추상클래스로 변한다, 그래서 이 클래스로도 객체를 생성할 수 없게 된다.
    }
}


public class PlayerTest {
    public static void main(String[] args) {
//        Player player = new Player()
//        AudioPlayer audioPlayer = new AudioPlayer();
        Player audioPlayer = new AudioPlayer();    //  다형성
        audioPlayer.play(100);
        audioPlayer.stop();
    }
}