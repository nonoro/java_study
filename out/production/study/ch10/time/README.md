## < java.time패키지 >
- 클래스
  - java.time : 날짜, 시간을 다루는 핵심 클래스 제공
  - java.time.chrono : 표준(ISO)이 아닌 달력 시스템을 위한 클래스 제공
  - java.time.format : 날짜와 시간을 파싱하고 형식화하기 위한 클래스 제공
  - java.time.temporal : 날짜와 시간의 필드와 단위를 위한 클래스를 제공
  - java.time.zone : 시간대와 관련된 클래스들을 제공
- String클래스와 같이 불변이다.

### 1. java.time패키지의 핵심 클래스
- Calendar와 달리 날짜와 시간을 별도의 클래스로 분리해 놓았다.
- 시간 : LoalTime클래스
- 날짜 : LocalDate클래스
- 시간 + 날짜 : LocalDateTime클래스
- LocalDateTIme + 시간대 : ZonedDateTime


#### 1) Period와 Duration
- 날짜와 시간의 간격을 표현하기 위한 클래스
- 날짜 - 날짜 : Period
- 시간 - 시간 : Duration

#### 2) 객체 생성하기 - now(), of()
- java.time패키지에 속한 클래스의 객체를 생성하는 가장 기본적인 방법은 now()와 of()이다.
- now() : 현재 날짜와 시간을 저장하는 객체를 생성
- of() : 해당 필드의 값을 순서대로 지정해 주기만하면 된다.

#### 3) Temporal과 TemporalAmount
- Temporal, TemporalAccessor, TemporalAdjuster를 구현한 클래스
  - LocalDate, LocalTime, LocalDateTime, ZonedDateTIme, Instant등
- TemporalAmount를 구현한 클래스
  - Period, Duration
- TemporalAmount인지 아닌지만 확인하면 된다. 

#### 4) TemporalUnit과 TemporalField
- TemporalUnit : 날짜와 시간의 단위를 정희해 놓은 인터페이스
  - 열거형 ChronoUnit : TemporalUnit인터페이스를 구현한 것
- TemporalField : 년, 월, 일 등 날짜와 시간의 필드를 정의해 놓은 것
  - 열거형 chronoField : TemporalField인터페이스를 구현한 것
- get() : 날짜와 시간에서 특정 필드의 값만을 얻을 때 사용하는 메서드
- plus(), minus() : 특정 날짜와 시간에서 지정된 단위의 값을 더하거나 뺄 때 쓴다.

### 2. LocalDate와 LocalTime
- now(), of() 둘다 static메서드이다
- 객체생성방법
  1) now() : 현재의 날짜와 시간을 LocalDate와 LocalTime으로 각각 반환하는 static메서드
  2) of() : 지정된 날짜와 시간을 LocalDaye와 LocatTime으로 각각 반환하는 static메서드
  ```
  예시) 
  LocalDate today = LocalDate.now();    //  오늘의 날짜
  LocalTime now = LocalTime.now();      //  현재 시간
  
  LocalDate birthDate = LocalDate.of(1999, 12, 31);   //  1999년 12월 31일
  LocalTime birthTime = LocalTime.of(23, 59, 59)      //  23시 59분 59초
  
  -of()
  static LocalDate of(int year, Month month, int dayOfMonth)
  static LocalDate of(int year, int month, int dayOfMonth)
  
  static LocalTime of(int hour, int min)
  static LocalTime of(int hour, int min, int sec)
  static LocalTime of(int hour, int minm int sec, int nanoOfsecond)
  ```
  
#### 1) 특정 필드의 값 가져오기 - get(), getXXX()
- Calendar와는 달리 월의 범위가 1~12이고 요일은 월요일이 1 화요일이 2 ~~ 일요일은 7이다.
- HOUR_OF_DAY는 밤 12시를 0으로 표현한다, CLOCK_HOUR_OF_DAY는 24로 표현한다.

#### 2) 필드의 값 변경하기 - with(), plus(), minus()
- with() : 날짜와 시간에서 특정 필드 값을 변경하기위한 메서드.
- 필드를 변경하는 메서드들은 항상 새로운 객체를 생성해서 반환하므로 대입 연산자를 같이 사용해야한다.

#### 3) 날짜와 시간의 비교 - isAfter(), isBefore(), isEqual()

### 3. Instant
- 에포크 타임(1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초 단위로 표현한다.
- Instant생성 시 now()와 ofEpochSecond()를 사용

#### 1) Instant와 Date간의 변환
- Instant는 기존의 java.util.Date를 대체하기 위한 것

### 4. LocalDateTime과 ZonedDateTime
- LocalDate + LocalTime = LocalDateTime
- LocalDateTime + 시간대 = ZonedDateTime

#### 1) LocalDate와 LocalTime으로 LocalDateTime만들기
#### 2) LocalDateTimedmfh ZonedDateTime 만들기
#### 3) ZonOffset 
- UTC로부터 얼마만큼 떨어져있는지 표현하는 메서드 만약 +9 일경우 UTC보다 9시간(32400초 = 60 * 60 * 9초)빠르다
#### 4) OffsetDateTime
- 서로 다른 시간대에 존재하는 컴퓨터간의 통신에 사용하는 메서드
#### 5) ZonedDateTime의 변환
- GregorianCalendar와 가장 유사하다.
- LocalDate + LocalTime + 시간대(예시 : +0900 Asia/Seoul)

### 5. TemporalAdjusters
- 자주 쓰일만한 날짜 계산들을 대신해주는 메서드를 정의해 놓은 것

### 6. Period와 Duration
- Period = 날짜 - 날짜
- Duration = 시간 - 시간

#### 1) between()
- 두 날짜 date1과 date2의 차이를 나타내는 Period는 between()으로 얻을 수 있다.
- date1이 date2보다 날짜 상으로 이전이면 양수로, 이후면 음수로 Period에 저장된다.
- Duration은 시간차이를 구할때 사용한다는것 이외에는 Period와 똑같다.
- Period, Duration에서 특정 필드의 값을 얻을 때는 get()을 사용한다.
  - 그런데 Period와 달리 Duration에는 getHours(), getMinutes() 같은 메서드가 없다 따라서 Duration을 LocalTime으로 변환한 다음에 LocaTime이 가지고 있는 get메서드들을 사용하는것이 더 간단하다.
  ```
  LocalTime tmpTime = LocalTime.of(0,0).plusSeconds(du.getSeconds());
  
  int hour = tmpTime.getHour();
  int min = tmpTime.getMinute();
  int second = tmpTime.getSecond();
  int nano = du.getNano();
  ```
  
#### 2) between과 until()
- until()은 between()과 거의 같은 일을 한다. 차이점은 until()은 인스턴스 메서드 between()은 static메서드라는점이다.
- Period는 년월일을 분리해서 저장하기 때문에 D-day를 구하려는 경우에는 두 개의 매개변수를 받는 until()을 사용하는 것이 낫다. 날짜가 아닌 시간에도 until()을 사용할 수 있지만, Duration을 반환하는 until()은 없다

#### 3) of(), with()
#### 4) 사직연산, 비교연산, 기타메서드
- plus(), minus()외에 곱셈과 나눗셈을 위한 메서드도 있다. , Period에는 나눗셈을 위한 메서드가 없다.
```
pe = pe.minusYears(1).multipliedBy(2);    //  1년을 빼고 2배를 곱한다
du = du.plusHours(1).dividedBy(60);       //  1시간을 더하고 60으로 나눈다.
```
- isNegative() : 음수인지 확인하는 메서드
- isZero() : 0인지 확인하는 메서드
- negate() : 부호를 반대로 변경하는 메서드
- abs() : 부호를 없애는 메서드(절댓값으로 변경), Period에는 abs()가 없음
  - 따라서 du = du.abs   --->   if (du.isNegative())
                                  du = du.negated();   Period는 이렇게 해야된다.
- normalized() : Period에 있는 메서드이고 월의 값이 12를 넘지 않도록 해준다.

#### 5) 다른 단위로 변환 - toTotalMonths(), toDays(), toHours(), toMinutes()

### 7. 파싱과 포멧
- 날짜와 시간을 원하는 형식으로 출력하고 해석(파싱, parsing)하는 방법
- 형식화 관련 클래스들은 java.time.format패키지에 있는데 이 중에서 가장 핵심적인 것은 DateTimeFormatter이다.

#### 1) 로케일에 종속된 형식화
- DateTimeFormatter의 static메서드 ofLocalizedDate(), 0fLocalizedTime(), ofLocalized DateTime()은 로케일에 종속적인 포멧터를 생성한다
- ```
  DateTImeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
  String shortFormat = formatter.format(LocalDate.now());
  ```
  - FULL : 2015년 11월 28일 토요일 : N/A
  - LONG : 2015년 11월 28일 (토) : 오후 9시 15분 13초
  - MEDIUM : 2015.11.28 : 오후 9:15:13
  - SHORT : 15.11.28 : 오후 9:15

#### 2) 출력형식 직접 정의하기
- DateTimeFormatter의 ofPattern()으로 원하는 출력형식을 직접 작성할 수 있다.

#### 3) 문자열을 날짜와 시간으로 파싱하기
- 문자열을 날짜 또는 시간으로 변환하려면 static메서드 parse()를 사용하면 된다.