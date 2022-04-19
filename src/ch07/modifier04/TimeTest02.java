package ch07.modifier04;

public class TimeTest02 {
    public static void main(String[] args) {
        Time02 t2 = new Time02(12, 35, 30);
        System.out.println(t2);
//        t2.hour = 13;
        t2.setHour(t2.getHour() + 13);    //  현재시간보다 1시간 후로 변경한다
        t2.setMinute(t2.getMinute() + 15);
        t2.setSecond(t2.getSecond() + 19);
        System.out.println(t2);        //  System.out.println(t.toString())과 같다.
    }
}

class Time02 {
    private int hour;
    private int minute;
    private int second;

    Time02(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    Time02() {

    }

    public int getHour() {
        return hour;
    }

    void setHour(int hour) {
        if (isValidHour(hour)) {
            return;
        }

        this.hour = hour % 24;   // 24시가 지났을때 1시부터 시작인데 이걸 나타내기위해 모듈러 연산자 사용
    }


    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (isValidMinute(minute)) {
            return;
        }

        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        if (isValidsecond(second)) {
            return;
        }

        this.second = second;
    }

    private boolean isValidHour(int hour) {
        return hour < 0 ;
    }

    private boolean isValidMinute(int minute) {
        return minute < 0 || minute > 59;
    }

    private boolean isValidsecond(int second) {
        return second < 0 || second > 59;
    }

    public String toString() {
        return hour + ":" + minute + ":" + second;
    }
}