## < 형식화 클래스 >
- java.txt패키지의 DecimalFormat(10진수 숫자), SimpleDateFormat(날짜를 형식화해줌)
- 숫자와 날짜를 원하는 형식으로 쉽게 출력 가능 (숫자, 날짜 -> 형식 문자열 : format()메서드를 씀)
```
double number = 1234567.89;             //  10진수
DecimalFormat df = new DecimalFormat("#.#E0");      //  지수형식
String result = df.format(number);      //  result = "1.2E6"
```
- 형식 문자열에서 숫자와 날짜를 뽑아내는 기능(형식 문자열 -> 숫자, 날짜 : parse() 메서드를 씀)
```
DecimalFormat df = new DecimalFormat("#,###.##");
Number num = df.parse("1,234,567.89");
double d = num.doubleValue();       //  1234567.89
```

###1. DecimalFormat
- 숫자(10진수)를 형식화할 때 사용(숫자 -> 형식 문자열) : 원래는 + "" 이렇게 하는데 DecimalFormat은 좀 다양하게 가능)
- 특정 형식의 문자열을 숫자로 변환할 때도 사용(형식 문자열 -> 숫자)
    - Number : 모든 숫자 래퍼클래스의 최고 조상
    - parse : 특정 형식의 문자열을 숫자로 바꿀때 쓰는 메서드 이걸 쓰면 문자열이 Number타입의 객체로 바뀜
    - 참고) Integer.parseInt()는 콤마(,)가 포함된 문자열을 숫자로 변환 못함, Float.parseFloat()얘도 마찬가지 그냥 parse만 가능

###2. SimpleDateFormat
- 날짜와 시간을 다양한 형식으로 출력할 수 있게 해준다.
- Date와 Calendar만으로 날짜 데이터를 원하는 형태로 다양하게 출력하는 것이 불편하고 복잡하지만 SimpleDateFormat을 사용하면 간편하다.
- 특정 형식으로 되어 있는 문자열에서 날짜와 시간을 뽑아낼 수도 있다.

### 3. ChoiceFormat
- 특정 범위에 속하는 값을 문자열로 변환해준다. 연속적 또는 불연속적인 범위의 값들을 처리하는 데 있어서 if문이나 switch문은 적절하지 못한 경우가 많다. 따라서 ChoiceFormat을 잘 사용하여 복잡한 코드를 간단하고 직관적으로 만들 수 있다.
- 범위의 경계값을 저장하는 limit배열 : 낮은 값부터 큰 값의 순서로 적어야함.
- 범위에 포함된 값을 치환할 문자열을 저장하는 grades배열 
- 패턴을 처리해 보다 간결하게 표현 가능

### 4. MessageFormat
- 데이터를 정해진 양식에 맞게 출력할 수 있도록 도와준다.
- 데이터가 들어갈 자리를 만들어 놓은 양식을 미리 작성하고 다수의 데이터를 같은 양식으로 출력할 때 사용하면 좋다.
- 예시) 안내문

