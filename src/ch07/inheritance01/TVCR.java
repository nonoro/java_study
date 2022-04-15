package ch07.inheritance01;

class TV {                    // 얘는 컴파일 할 경우 class Tv extends Object 이렇게 Object가 자동으로 추가됨
    boolean power;          //  전원상태(on/off)
    int channel;            //  채널

    void power()      { power = !power; }
    void channelUp()  { ++channel; }
    void channelDown() { --channel; }

}

class VCR {                  // 얘도 마찬가지로 컴파일 할 경우 Object가 자동으로 추가됨
    boolean power;      //  전원상태(on/off)
    int counter = 0;
    void power()  {  power = !power; }
    void play()  { /* 내용생략*/ }
    void stop()  { /* 내용생략*/ }
    void rew()  { /* 내용생략*/ }
    void ff()  { /* 내용생략*/ }
}

class TVCR extends Tv {
    VCR vcr = new VCR();

    void play() {         //  여기부터 vcr.ff()까지 외부적으로는 TVCR 클래스의 인스턴스를 사용하는 것처럼 보이지만 내부적으로는 VCR의 클래스의 인스턴스를 생성해서 사용하는 것이다
        vcr.play();       //  그리고 TVCR클래스에 VCR클래스의 메서드와 일치하는 선언부를 가진 메서드를 선언하지만 내용은 VCR클래스의 것을 호출해서 사용하는것이다.
    }

    void stop() {
        vcr.stop();
    }

    void rew() {
        vcr.rew();
    }

    void ff()  {
        vcr.ff();
    }
}
