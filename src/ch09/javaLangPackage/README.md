## < java.lang패키지 >

### 1. Object클래스
    - 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다. iv, cv는 없다
    - notify(), wait() 등은 쓰레드와 관련된 메서드이다.
    - 종류
    => boolean equals(Object ojt) (객체비교), Object clone()(객체 복사), int hashCode(), String toString() (객체를 문자열로 반환), Class getClass() (객체의 클래스 정보를 반환)

#### 1) boolean equals(Object obj)
    - 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true 다르면 false
    - Object클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)
    - equals(Object obj)의 오버라이딩 : 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야 한다.

### 2. hashCode()
    - 객체의 해시코드를 반환하는 메서드, 해시코드 : 정수값 : 해싱이라는 알고리즘에서 사용 : 11장 컬렉션프레임워크에서 자세히 배움
    - Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
    - 해싱은 데이터 관리기법 중 하나로 다량의 데이터를 저장하고 검색하는데 유용
    - equals()를 오버라이딩하면, hashCode()도 오버라이딩 해야한다. : 두개의 공통점은 객체의 주소를 가지고 작업을 한다는 점이고 equals는 주소를 iv를 가지고 작업하게 오버라이딩을 하는데 
                                                               hashCode도 마찬가지로 주소를 가지고 작업을 하기 때문에 iv를 이용해서 작업하도록 오버라이딩을 해야한다.
    - 암기 : equals() 결과가 true인 두 객체의 해시코드는 같아야한다.
    - System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일 : identityHashCode 객체마다 다른 해시코드 반환 (참고)
    - 32bit JVM에선 주소값이 int값임 그래서 해시코드가 int 값, 근데 64bit JVM에서는 주소가 8바이트여서 long임 따라서 주소값이 겹치는 경우가 발생 할 수도 있음

### 3. toString(), toString()의 오버라이딩
    - toString() : 객체를 문자열(String)으로 변환하기 위한 메서드
    - 해시코드와 마찬가지로 toStiring은 주소값을 불러오기 때문에 오버라이딩 하지 않으면 객체의 주소값을 불러온다 형태는 : 클래스이름"@"16진객체주소
    - 객체 == iv집합 이므로 객체를 문자열로 변환한다는 것은 iv의 값을 문자열로 변환한다는 것과 같다.

### 4. clone()
    - 객체 자신을 복제해서 새로운 객체를 생성하는 메서드
    - Cloneable인터페이스를 구현한 클래스의 인스턴스만 복제할 수 있다.
    - Object클래스에 정의된 clone()은 인스턴스변수의 값만을 복제한다
    - 인스턴스변수가 참조형일 때, 참조하는 객체도 복제되게 오버라이딩 해야된다 안그러면 불완전복제(얕은 복사)가 되어 참조변수가 같은 주소를 가질 뿐 복제된 객체가 생성되지 않는다

### 5. 공변 반환타입
    - 오버라이딩할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것
    - 조상의 타입이 아닌 실제로 반환되는 자손 객체의 타입으로 변환할 수 있어서 번거로운 형변환이 줄어든다.
    - 예시 : 배열의 clone
            int[] arr = {1, 2, 3, 4, 5};
            int[] arrClone = arr.clone();

### 6. 얕은 복사와 깊은복사
    - 얕은 복사 : 원본과 복제본이 같은 객체를 공유하므로 원본을 변경하면 복사본도 영향을 받는다
    - 깊은 복사 : 원본과 볷제본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복제본에 영향을 미치지 않는다.

### 7. getClass()
    - 자신이 속한 클래스의 Class 객체를 반환하는 메서드
    - Class객체를 통해서 객체를 생성하고 메서드를 호출하는 등 보다 동적인 코드를 작성할 수 있다
    - Class 객체는 클래스의 모든 정보를 담고 있으며 클래스당 단 1개만 존재 클래스파일(*.class)이 메모리에 로드될때 생성된다 
      클래스 : 클래스객체 = 1 : 1
    - Class 객체를 얻는 방법
        1) Class cObj = new Card().getClass();  //  생성된 객체로 부터 얻는 방법
        2) Class cObj = Card.class;             //  클래스 리터럴(*.class)로 부터 얻는 방법
        3) Class cObj = Class.forName("Card");  //  클래스 이름으로 부터 얻는 방법

### 8. String클래스
    - 문자열을 다루기 위한 클래스
    - String클래스 = 데이터(char[]=문자배열) + 메서드(문자열 관련)

#### 1) 변경 불가능한(immutable) 클래스
    - 내용을 변경할 수 없는 불변(immutable) 클래스  // im(not) + mut(change) + able
    - 덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐 : 문자열은 내용을 변경할 수 없어서 계속 새로운 객체가 만들어지기 때문에 성능이 떨어짐
        String a = "a";
        String b = "b";
        a = a + b;     //  "ab"가 출력됨 근데 이게 a 값이 바뀐게아니라 "ab"를 담는 새로운 객체 주소가 생성되고 a의 주소가 "ab"의 객체 주소로 바뀔뿐임
        * 따라서 문자열의 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer를 사용 : 간단한 한 두번의 문자결합은 괜찮지만 반복문 안에서 문자를 지속적으로 결합할 경우 StringBuffer를 사용한다.
    
#### 2) 문자열의 비교
    - String str = "abc"(문자열 리터럴); 와 String str = new String("abc");의 비교
        String str1 = "abc";    //  문자열 리터럴 "abc"의 주소가 str1에 저장됨
        String str2 = "abc";    //  문자열 리터럴 "abc"의 주소가 str2에 저장됨
        String str3 = new String("abc");        //  새로운 String인스턴스를 생성
        String str4 = new String("abc");        //  새로운 String인스턴스를 생성
        1) 문자열 리터럴로 문자열을 만들면 하나의 문자열을 여러 참조변수가 공유한다 따라서 주소가 같음(문자열 리터럴은 이미 존재하는 것을 재사용하는 것)
        2) new 연산자 사용시 항상 새로운 객체가 만들어짐 따라서 주소가 다름
        * 그런데 문자열은 어짜피 내용을 변경불가임 그래서 굳이 new를 이용해서 같은 내용의 문자열을 여러개를 만들 필요가 없음
        * 문자열의 같고 다름을 표시할 떄는 equals를 써야됨 등가비교 연산자 == 는 주소비교이고 equals는 내용비교임 따라서 어떨땐 true고 어떨땐 false라서 
          문자열을 비교할땐 항상 equals를 이용해서 비교하기

#### 3) 문자열 리터럴(리터럴 = 상수)
    - 문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(constant pool에 저장 = 상수 저장소)
    - 같은 내용의 문자열 리터럴은 하나만 만들어진다. : String객체는 내용불변이기 때문

#### 4) 빈 문자열("", empty string)
    - 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열
        String str = ""  //  str을 빈 문자열로 초기화
    - 길이가 0인 배열을 생성하는 것은 어느 타입이나 가능 (자바는 가능한데 씨언어는 불가능)
        char[] chArr = new char[0];     //  길이가 0인 char배열
        int[] iArr = {};                //  길이가 0인 int배열
    - 빈 문자열 쓰는 이유는 숫자를 문자로 바꿀때 빈 문자열을 사용하고, 또 배열을 초기화 할 때도 null보단 빈 문자열로 하는게 유용함
    - 문자(char)와 문자열(String)의 초기화
        String s = null;                ----->              String s = "";  //  빈 문자열로 초기화
        char c = '\u0000'               ----->              char c = ' ';   //  공백으로 초기화
        * 오른쪽 코드가 더 좋은 코드이다

#### 5) Strin클래스의 생성자와 메서드
    - String(String s) : 잘 안씀
        String s = new String("Hello");        :       s = "Hello"
    - String(char[] value) : 잘 씀        : char[]을 String으로 변경할 때 쓰는 생성자
        char[] c = {'H', 'e', 'l', 'l', 'o'};                               //  char[] ---> String 으로 바꾸는방법 (캐릭터배열을 스트링으로 바꾸는 방법)
        String s = new String(c);               :   s = "Hello"             //  반대로 String을 Char[]로 바꿀땐 tocharArray()라는 메서드를 쓰면된다.
    - String(StringBuffer buf)      : 내용변경 가능 , StringBuffer를 String으로 변경할 때 쓰는 생성자
    - char charAt(int index)        : 지정된 위치에 있는 문자를 1개 반환하는 생성자
    - int compareTo(String str)     : 문자열과 사전순서로 비교하는 생성자(정렬에사용) ex) int i = "aaa".compareTo("aaa");  --> i = 0 // 같아서 0임 만약 오른쪽이 "bbb"였으면 i = -1 왼쪽이 "bbb" 였으면 i = 1;
                                    정리 ) 같으면 0, 왼쪽이 작으면 -1, 오른쪽이 작으면 1
    - String concat(String str)     : 문자열을 뒤에 덧붙이는 생성자 : Hello에 World를 따로 선언해서 Hellow World로 출력되게함
    - boolean contains(CharSequence s)  : 지정된 문자열이 포함되었는지 검사하는 생성자 
    - 나머지 책 내용 참조 

#### 6) join()과 StringJoiner
    - join()은 static 메서드이며 여러 문자열 사이에 구분자를 넣어서 결합한다.
        String animals = "dog,cat,bear"
        String[] arr = animals.split(",");  //  문자열을 ','를 구분자로 나눠서 배열에 저장 (',' 이건 구분자)
        String str = String.join("-", arr); //  배열의 문자열을 '-'로 구분해서 결합 ('-' 이건 구분자)
        System.out.println(str);            //  dog-cat-bear ("dog" + "-" + "cat" + "-" + "bear")
    - StringJoiner : java.util.StringJoiner클래스를 사용하여 문자열을 결합할 수도 있다.
        new StringJoiner(구분자, 처음, 끝)

#### 7) 유니코드의 보충문자
    - 확장에 의해 새로 추가된 문자들을 보충문자라고 하는데 String클래스에서 보충문자를 지원하는 것은 
      매개변수가 int ch인 것들은 보충문자 지원, 매개변수가 char ch인 것들은 보충문자 지원하지 않음

#### 8) 문자 인코딩 변환
    - getBytes(String charsetName)를 사용하면, 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다.

#### 9) String.format()
    - printf()하고 사용법이 완전히 똑같다

#### 10) 문자열과 기본형 간의 변환
    - 숫자를 문자열로 바꾸는 방법(valueOf)
        int i = 100;   // 숫자 + ""(빈문자열)
        String str1 = i + "";               //  100을 "100"으로 변환하는 방법1 - 편리 보통이걸씀
        String str2 = String.valueOf(i);    //  100을 "100"으로 변환하는 방법2 - 속도가 빠름
    - 문자열을 숫자로 바꾸는 방법(valueOf)
        int i = Integer.parseInt("100");    //  "100"을 100으로 변환하는 방법1 old한 방법 얘는 parse 뒤에 기본형에따라 달라짐
        int i2 = Integer.valueOf("100");    //  "100"을 100으로 변환하는 방법2 new방법 얘는 그냥 앞에 타입만 맞추고 뒤엔 뭐든 valuOf하면됨 이거쓰기
        Integer i2 = Integer.valueOf("100");    // 원래는 valueOf 반환 타입이 Integer 참조형임 근데 int 기본형으로 써도됨

### 9. StringBuffer클래스와 StringBuilder클래스

#### 1) StringBuilder클래스
    - String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
    - 문자열을 저장 & 다루기위한 클래스이다.
    - String과 달리 내용을 변경할 수 있다(mutable)
        StringBuffer sb = new StringBuffer("abc"); //    이렇게하면 'a' 'b' 'c' 배열이 생성이된다
        sb.append("123");                          //    이렇게하면 'a' 'b' 'c' '1' '2' '3' abc배열 옆에 123 이 추가된다

#### 2) StringBuffer의 생성자
    - 배열은 길이 변경불가. 공간이 부족하면 새로운 배열 생성해야한다.
        a) 새로운 배열 생성 보통 2배로함
        b) 내용복사
        c) 참조변경
    - StringBuffer는 저장한 문자열의 길이를 고려해서 적절한 크기로 생성해야한다.

#### 3) StringBuffer의 변경
    - StringBuffer는 String과 달리 내용 변경이 가능하다
        append() : 끝에 문자열 추가
        delete() : 삭제
        insert() : 삽입
        => 이 메서드 들의 반환타입은 StringBuffer 따라서
            StringBuffer sb = new StringBuffer("abc");
            sb.append("123");          ------>          sb.append("123").append("ZZ");
            sb.append("ZZ");                                   sb       이 두 문장을 위에 하나로 변경가능
            StringBuffer  
    - StringBuffer는 equals()가 오버라이딩되어있지 않다(주소비교) (this == obj) 이렇게 되어있다. 그래서 내용이 같아도 주소가달라서 equals결과가 false가뜸
      따라서 StrinBuffer을 String으로 변환 후에 equals()로 비교해야 한다.
            String s = sb.toSTring();               // sb를 String으로 변환
            String s2 = sb2.toString();
            
            System.out.println(s.equals(s2));       //  true

#### 4) StringBuffer의 생성자와 메서드
    - 기본생성자 StringBuffer()일 경우 기본 16문자를 담을 수 있는 캐릭터배열이 만들어짐
    - bufferSize = StringBuffer인스턴스 배열의 총 길이
    - stringSize = 배열에 담긴 문자열의 길이
    - apend는 맨뒤에 차례대로 넣는다.
    - insert는 위치를 지정해서 넣을 수 있다.
        예시)     StringBuffer sb = new StringBuffer("0123456")
                 sb.insert(4, '.'); 
                 // 이 경우 4 뒤에 . 이 들어간다 무조건 boolean이든 float 이든 앞에 x자리쪽 인덱스 뒤에 y자리쪽 문자열이 들어감 
                 // 따라서 "0123.456
    - delete는 StringBuffer(int start, int end) 인데 여기서 end지점의 인덱스는 빼고 삭제다
        예시)     StringBuffer sb = new StringBuffer("123456789");                         
                 StringBuffer sb2 = sb.delete(3, 6); 
                // 이 경우 3번째에 위치한 4부터 ~ 6번째인 7까지 없어지는게아니라 끝에는 빼고 4~6까지 없어진다
                // 대부분의 경우가 모두 end자리 인덱스는 제외하고임 replace도 마찬가지
                // 따라서 "123789" 출력
    - setCharAt(int index, char ch) : 인덱스 위치에 있는 문자를 바꾼다.
    - trim() : 양 끝의 빈 공백을 없애줌
    - setLength() : 지정된 길이로 문자열의 길이를 변경한다. 길이를 늘리는 경우 빈 공간은 \u0000로 채워져 공백으로 출력되고 주로 trim()과 함께 사용하여 공백을 없앤다
    - toString() : StrinBuffer를 String으로 바꿀때 사용한다
    - substring(int start, int end) : start부터 end전까지의 지정된 길이의 문자를 출력하고 나머지는 삭제한다  start만 입력할 경우 start~맨끝 까지 출력한다.
    - replace(int start, int end, String str) : (시작, 끝, 교체할 문자)

#### 5) StringBuilder
    - StringBuffer와 거의 똑같은데 StringBuffer는 동기화되어 있지만(동기화 되어있다 = 멀티 쓰레드에 안전하다.(thread=safe) StringBuilder는 동기화되어 있지않다
        < 쓰레드 : 일꾼 >
        * 싱글쓰레드 : 한번에 1개 작업 ( 지금까지 작성한 것들은 전부 싱글 쓰레드 )
                ex) 카톡에서 파일을 다운로드 할 경우 파일을 다운로드 하는동안 채팅을 못하는 경우, 다운로드하던가 채팅하던가 둘 중 하나밖에 못함
          멀티쓰레드 : 한번에 n개 작업
                ex) 파일 다운로드와 채팅등의 여러작업을 동시에 할 수 있다.
                * 여렇이 같이 작업하다보니 데이터를 공유하는데 이걸 누가 작업하는 중에 다른 사람이 건드릴 수 있다 그걸 막아주는게 동기화이다 
                  따라서 동기화 = 데이터를 보호
    - 멀티 쓰레드 프로그램이 아닌 경우, 동기화는 불필요한 성능저하    
      이럴 떈 StringBuffer대신 StringBuilder(싱글 쓰레드 프로그램)를 사용하면 성능 향상 ( 근데 거의 Buffer를 씀 )
            예시) 만약 StringBuffer -> StringBuilder 로 바꿀경우 다른거(메서드 등) 하나도 건들지 않고 그냥 순수 클래스이름만 StringBuffer를 StringBuilder로만 바꾸면됨

### 10. Math클래스
    - 수학관련 static메서드의 집합
    - round()로 원하는 소수점 아래 세 번째 자리에서 반올림하기
    - ex) Math.round(), Math.random() 등
    - abs() : 앱솔루트 : 절대값 반환 : 양수 -> 양수, 음수 -> 양수
    - ceil() : 올림
    - floor() : 버림, 음수일때 조심 음수는 올라감 숫자가( 클수록 작아서 )
    - max() : 둘 중 큰거 반환
    - min() : 둘 중 작은거 반환
    - rint : 반올림 : roundeven : 짝수 반올림 올림했을때 짝수면 올림 아니면 내림 : 오차가 round보다 적다
    - round : 반올림 : 우리가 알고있는 일반 반올림 : HALF_UP

#### 1. 예외를 발생시키는 메서드
    - 메서드 이름에 Exact가 포함된 메서드 : 이들은 정수형간의 연산에서 발생할 수 있는 오버플로우를 감지하기 위한 것이다.
    - addExact(), subtractExact() 등 Exact가 붙은 메서드들은 오버플로우 발생시 예외를 발생시킨다
    
### 11. 래퍼(wrapper) 클래스
    - 8개의 기본형을 객체로 다뤄야할 때 사용하는 클래스.
    - 기본형값을 감싸는 클래스
    - int와 char을 제외하면 기본형의 래퍼클래스는 각각의 기본형의 이름의 앞글자를 대문자로 한 것이다. 
        int -> Interger
        char -> Character
    - 래퍼 클래스들은 모두 equals()가 오버라이딩되어있다.
    - 래퍼 클래스들은 모두 toString()이 오버라이딩되어있다.
    - MAX_VALUE, MIN_VALUE, SIZE, BYTES, TYPE등의 static상수를 공통적으로 가지고있다.

#### 1. Number클래스
    - 모든 숫자 래퍼 클래스의 조상(Biglnteger(아주 큰 정수) - long으로 표현할 수 없는걸 표현, BigDecimal(아주 큰 실수) - Double로 표현할 수 없는걸 표현 얘내는 따로 안배웠었음)
    - 추상클래스이다.
    - 래퍼 객체의 값을 -> 기본형으로 바꿀때 쓰는 메서드들을 가지고 있다.
        new Integer(100) -------------------> 100 
           Integer           intValue()       int

#### 2. 문자열을 숫자로 변환하기
    - 문자열을 숫자로 변환하는 다양한 방법
        int     i = new Integer("100").intValue();  
        int     i2 = Integer.parseInt("100")        // 주로 이 방법을 많이 사용 - 문자열을 인티져로 바꾸는 가장 많이 쓰는 방법
        int(Intger로 써도됨)     i3 = Integer.valueOf("100")
    * 문자열 -> 기본형 : 해당기본형타입(앞글자 대문자).parse해당기본형타입(앞글자 대문자)() or 해당기본형타입(앞글자 대문자).ValueOf()
                        byte b = Byte.parseByte("100");
    * 문자열 -> 래퍼클래스 : 해당기본형타입(앞글자 대문자).
                        Byte b = Byte.valueOf("100")
                        Byte b = new Byte("100");
    * 래퍼클래스 -> 문자열 : 
                        Byte b = Byte.toString("100"); 
                        String str = b.toString()
    - n진법의 문자열을 숫자로 변환하는 방법
        int i4 = Intger.parseInt("100", 2);         //  100(2) -> 4   100을 2진수로 바꾼값 = 4
        int i5 = Intger.parseInt("100", 8);         //  100(8) -> 64   100을 8진수로 바꾼값 = 64
        int i6 = Intger.parseInt("100", 16);        //  100(16) -> 256   100을 16진수로 바꾼값 = 256
        int i7 = Intger.parseInt("FF", 16);         //  FF(16) -> 255   FF을 16진수로 바꾼값 = 255
        int i8 = Intger.parseInt("FF");             //  NumberFormatException발생, ("", 여기 아무것도 안쓰면 자동으로 10이 있다고 보고 10진수로 값을 바꿈) 
                                                    //  근데 얘는 FF를 10진수에는 F가없어서 에러발생

#### 3. 오토박싱 & 언박싱(autoboxing & unboxing)
    - 기본형의 값을 객체로 자동변환하는 것을 오토박싱, 그 반대는 언박싱
    - int(기본형)  ------> Integer(참조형)
           오토박싱(기본형 값을 래퍼클래스 값으로 자동으로 바꿔줌)
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);           //  오토박싱. 10 -> new Integer(10) 으로 자동으로 바꿔줌 
            원래는 list.add(new Integer(10)) 이렇게 해야되는데 자동으로 10만 입력해도 이렇게 바꿔줌 
    - int(기본형)  <------ Integer(참조형)
           언박싱(래퍼클래스 값을 기본형 값으로 자동으로 바꿔줌)
            int value = list.get(0);    //  언박싱. new Integer(10) -> 10;
            얘도 마찬가지로 자동으로 10으로 바꿔줌