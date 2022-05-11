## < 날짜와 시간 >

###1. Calendar와 Date
- java.util.Date
    - 날짜와 시간을 다룰 목적으로 만들어진 클래스(JDK1.0 1995년도말)
    - Date의 메서드는 거의 deprecated(앞으로 사용하지 말라는 말)되었지만, 여전히 쓰이고 있다.
- java.util.Calendar
    - Date클래스를 개선한 새로운 클래스(JDK1.1 1997년도말). 여전히 단점이 존재 : Calendar와 Date의 단점은 항상 날짜와 시간을 같이 다루게 되어있음
- java.time패키지
    - Date와 Calendar의 단점을 개선한 새로운 클래스들을 제공(JDK1.8 2014년도)
        - 여기선 날짜와 시간을 따로 다룰 수 있게 아니면 합쳐서 다룰 수 있게 클래스를 나눠놈
            1) 날짜 : LocalDate
            2) 시간 : LocalTime
            3) 날짜 + 시간 : LocalDateTime
####1) Calendar와 GregorianCalendar(서양력)
- Calendar는 추상클래스이기 때문에 직접 객체를 생성할 수 없고 메서드 getInstance()를 통해 구현된 객체를 얻어야 한다.
    - getInstance()메서드는 Calendar클래스를 구현한 클래스의 인스턴스를 반환한다.
    - Calendar cal = new Calendar(); : 에러
    - Calendar cal = Calendar.getInstance(); : 서양력, 불교력, 일본력 이 셋중에 어떤 캘린더를 사용하는지 판단해서 한 가지를 반환해줌


- Calendar클래스 - 예제1 get()
    - get()으로 날짜와 시간 필드 가져오기 - int get(int field)
      ```
      Calendar cal = Calendar.getInstance();   //  현재 날짜와 시간으로 셋팅됨
      int thisYear = cal.get(Calendar.YEAR);   //  올해가 몇년인지 알아낸다.
      int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);  //  이 달의 마지막 날
      ```
    - Calendar에 정의된 필드
    - 날짜
        - YEAR : 년
        - MONTH : 월(0부터시작 EX) 0 = 1월)
        - WEEK_OF_YEAR : 1월1일 ~ 지금까지 몇번째 주 인지
        - WEEK_OF_MONTH : 그 달의 몇 번째 주
        - DATE : 일
        - DAY_OF_MONTH : 그 달의 몇 번째일
        - DAY_OF_YEAR : 그 해의 몇 번째일(1월1일부터 몇일 지낫는지)
        - DAY_OF_WEEK : 요일(1~7) 1: 일요일
        - DAY_OF_WEEK_IN_MONTH : 그 달의 몇 번째 요일
    - 시간
        - HOUR : 시간(0~11)
        - HOUR_OF_DAY : 시간(0~23)
        - MINUTE : 분
        - SECOND : 초
        - MILLISECOND : 천분의 일초
        - ZONE_OFFSET : GMT기준 시차(천분의 일초 단위)
        - AM_PM : 오전/오후

####2) Date와 Calendar간의 변환
```
1. Calendar를 Date로 변환
      Calendar cal = Calendar.getInstance();
        ... 
      Date d = new Date(cal.getTimeInMillis());   //  Date(long date)
      
2. Date를 Calendar로 변환
      Date d = new Date();
        ...
      Calendar cal = Calendar.getInstance();
      cal.setTime(d)  
```

####3) Calendar클래스 - 예제 2,3 set()

- set()으로 날짜와 시간지정하기
```
void set(int field, int value)
void set(int year, int month, int date)
void set(int year, int month, int date, int hourOfDay, int minute)
void set(int year, int month, int date, int hourOfDay, int minute, int second)
            년        월          일        시             분           초
```

- 날짜 지정하는 방법. 월(MONTH)이 0부터 시작한다는 점에 주의
```
Calendar date1 = Calendar.getInstance();        //  캘린더 객체 생성
date1.set(2017, 7, 15);     //  2017년 8월 15일(7월 아님)

//  아래처럼 해도 됨 
//  date1.set(Calendar.YEAR, 2017);     //  2017년 8월 15일(7월 아님)
//  date1.set(Calendar.MONTH, 7);     //  2017년 8월 15일(7월 아님)
//  date1.set(Calendar.DATE, 15);     //  2017년 8월 15일(7월 아님)
  
```

- 시간 지정하는 방법. (년월일을 지정하는 메서드는 따로 있는데 시분초를 지정하는 메서드는 따로 없어서 얘는 년월일처럼 한번에 못함)
```
Calendar time1 = Calendar.getInstance();      //  캘린더 객체 생성
time1.set(Calendar.HOUR_OF_DAY, 10);        //  time1을 10시 20분 30초로 설정
time1.set(Calendar.MINUTE, 20);        
time1.set(Calendar.SECOND, 30);        
```

- 날짜 계산은 먄악 현재 1번 날짜와 과거 2번 날짜의 차이를 알고 싶으면 1 - 2를 하는데 1과 2를 둘 다 getTimeInmillis()를 사용하여 초로 바꿔서 계산한다음 1000으로 나누고(getTimeInMillis()는 1000분의 1초단위) 24 * 60 * 60 (하루) 로 나눠준다.
- clear()는 Calendar객체의 모든 필드를 초기화 : 1970년 1월 1일 00:00:00으로 초기화 : EPOCH Time
- clear(int field)는 Calendar객체의 특정 필드를 초기화 : 원래 객체를 만든다음 현재시간으로 뭘 할게 아니면 꼭 초기화를 해주고 시작해야된다. : 특정날짜, 년월일, 시분초 계산시 사용 : 밀리세컨드까지 계산할게 아니면 초기화를 해줘야 날짜계산할때 제대로 나옴


#### 4) Calendar클래스 - 예제 4, 5
- 복습
1) get() : 필드 읽기
2) set() : 필드 변경
3) clear() : 필드 초기화

- add() : 특정 필드의 값을 증가 또는 감소(다른 필드에 영향 O)
```
Calendar date = Calendar.getInstance();
date.clear();   //  모든 필드를 초기화
date.set(2020, 7, 31);  //  2020년 8월 31일로 설정

date.add(Calendar.DATE, 1);     //  날짜(DATE)에 1을 더한다. : 9월 1일
date.add(Calendar.MONTH, -8);   //  월(MONTH)에서 8 을 뺸다. : 1월 1일
```

- roll() : 특정필드의 값을 증가 또는 감소(다른 필드에 영향X)
```
date.roll(Calendar.DATE, 1);    // 날짜(DATE)에 1을 더한다. : 8월 1일 : add면 2020년 9월 1일임 근데 얘는 날짜(DATE)에만 영향을 미침 년, 월에는 영향 없음
date.roll(Calendar.MONTH, -8);  // 월(MONTHE)에 -8을 뺀다 : 2020년 12월 31일 : add면 2019년 12월 31일 인데 roll()이여서 다른필드에 영향을 안미침
```

- roll()과 add() 메서드 둘다 먄악 1월 31 일 일때 월필드를 1 증가시켜 2월로 만들면 2월은 28일이 말일이기 때문에 자동으로 2월의 말일인 28일로 바뀐다.
* Math.abs(); 절대값 반환 메서드

- boolean isLeapYear(int year) : 매개변수 year가 윤년이면 true를 그렇지 않으면 false를 반환한다.
- int dayDiff(int y1, int m1, int d1, int y2, int m2, int d2) : 두 날짜간의 차이를 일단위로 반환한다.
- int getDayOfWeek(int year, int month, int day) : 지정한 날짜의 요일을 반환한다.(1~7, 1이 일요일)
- String convertDayToDate(int day) : 일단위의 값을 년월일의 형태의 문자열로 변환하여 반환한다.
- int convertDateToDay(int year, int month, int day) : 년월일을 입력받아서 일단위로 변환한다.
- 두 날짜의 차이를 구하려면 일단위로 변환한 다음 두 값을 서로 빼기만 하면 된다.
- 요일을 구하는 것은 일단위로 바꾼 다음에 요일의 개수인 7로 나누고 요일이 1 부터 시작하기 위해서 1을 더한다. 1을 더하지 않고 요일의 범위를 0~6까지 해도 되지만 Calendar에서 요일범위가 1~7이기 때문에 동일하게 처리한다.