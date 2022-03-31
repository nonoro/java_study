## 2. String배열
```
=> String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
```
- String배열의 참조형 변수의 기본값은 null이다. (null은 어떠한 객체도 가리키고 있지 않다는 뜻)
- <변수 타입에 따른 기본값>
1. boolean - false
2. char - \u0000
3. byte, short, int - 0
4. long - 0L
5. float - 0.0f
6. double - 0.0d 또는 0.0
7. 참조형 변수 - null

#### 1. String배열의 초기화
=> int 배열과 동일
- 참조형 배열의 경우 배열에 저장되는 것은 객체의 주소이다. 그래서 참조형 배열을 객체 배열이라고도 한다.

#### 2. char배열과 String클래스
=> String 클래스는 char배열에 기능(메서드)을 추가한 것이다.
* 매서드 = 객체지향 언어에서 '함수', '기능' 이라는 말 대신 사용하는 용어
* char배열과 String클래스의 한 가지 중요한 차이는 String객체(문자열)는 읽을수만 있고 내용을 변경 할 수 없다.
* String클래스의 주요 메서드
1. char charAt(int index) - 문자열에서 해당 위치(index)에 있는 문자를 반환한다.
2. int length() - 문자열의 길이를 반환한다.
3. String substring(int from, int to) - 문자열에서 해당 범위(from~to)에 있는 문자열을 반환한다 (to는 범위에 포함되지 않음)
4. boolean equals(Object obj) - 문자열의 내용이 obj와 같은지 확인한다. 같으면 결과는 true, 다르면 false 가 되기 때문이다.
5. char[] toCharArray() - 문자열을 문자배열(char[])로 변환해서 반환한다.

- char배열과 String클래스의 변환 
```
char[] chArr = { 'A', 'B', 'C' }
String str = new String(chArr);  // char배열 -> String
char[] tmp = str.toCharArray();  // String -> char배열
```

#### 3. 커맨드 라인을 통해 입력받기
=> Scanner클래스의 nextLine()외에 화면을 통해 사용자로부터 값을 입력받는 방법

## 3. 다차원 배열
=> 2차원 이상의 배열이다, 주로 테이블 형태의 데이터를 담는다

#### 1. 2차원 배열의 선언과 인덱스
```
타입[][] 변수이름;    =     int[] [] score;
타입 변수이름[][];    =     int score [] [];
타입[] 변수이름[];    =     int[] score[];

ex) 4행 3열의 데이터를 담기위한 배열을 형성
int[] [] socre = new int[] [];
```
- 2차원 배열의 인덱스
1. 2차원 배열은 행과 열로 이루어져 있다.
2. 행index의 범위 : 0 ~ 행의길이-1 
3. 열index의 범위 : 0 ~ 열의길이-1 
4. 2차원 배열의 각 요소에 접근하는 방법 : 배열이름[행index][열index]

#### 2. 2차원 배열의 초기화
=> 1차원 배열과 마찬가지로 괄호{}를 써서 생성과 초기화를 동시에 할 수 있다. 다만 1차원 배열보다 괄호{}를 한번 더 써서 행별로 구분해 준다.
```
int[] [] arr = new int [] []{ {1, 2, 3}, {4, 5, 6} };
int[] [] arr = { {1, 2, 3}, {4, 5, 6} };  // new int[] [] 가 생략됨
```

#### 4. 가변 배열
```
int[] [] score = new int[5][] // 두번째 차원의 길이는 지정하지 않는다.
이렇게 하면 각 행마다 다른 길이의 배열을 생성할 수 있다.
```
* score.length : 행의 갯수, score[i].length : 열의 갯수
#### 5. 다차원 배열의 활용
- 예제
1. 좌표에 x표하기
2. 빙고 
3. 행렬의 곱셈 ( 두 행렬의 곱셈이 가능하려면 배열m1의 열의 길이와 배열m2의 행의 길이가 일치해야한다.)
4. 단어 맞추기
