## < 유용한 클래스 >

> 1. java.util.Objects클래스
- Object클래스의 보조 클래스로 Math클래스처럼 모든 메서드가 static이다. 객체의 비교나 null check에 유용하다
- isNull() : 해당 객체가 null인지 확인해서 null 이면 true 아니면 false 반환
```
static boolean isNull(object obj)
```
- nonNull() : isNull과 반대 = !Object.isNull(obj)
```
static boolean nonNull(object obj)
```
- requireNonNull() : 해당 객체가 null이 아니어야 하는 경우에 사용 만일 객체가 null이면 NullPointerException을 발생, 두번째 매개변수로 지정하는 문자열은 예외의 메시지가 된다.
```
static <T> T requireNonNull(T obj, String message) => ( null인지 여부 확인하는 객체, 예외의 메시지 )
```
- compare() : 비교대상이 같으면 0, 크면 양수, 작으면 음수, 대소문자 구분없이 비교(aa = AA)
- deepEquals() : 객체를 재귀적으로 비교하기 때문에 다차원 배열의 비교도 가능하다.
- toString() : toString(Object o, String nullDefualt) => (String으로 변환할 객체, 객체가 null일 경우 대신 사용할 값)

> 2. java.util.Random클래스 
- double randNum = Math.random(); = double randNum = new Random().nestDouble(); 이 두 문장은 동일하다
- 1~6사이의 정수를 난수로 얻고자 할 때
```
int num = (int) (Math.random() * 6) + 1;        //  1~6까지 랜덤
int num = new Random().nextInt(6) + 1;          //  nextInt(6)은 0~6사이의 정수를 반환
```

>> 1) Random클래스의 생성자와 메서드
- boolean nextBoolean()
- double nextDouble()
- float nextFloat()
- int nextInt()
- int nextInt(int n) : 0 ~ n 범위에 있는 int값을 반환(n은 범위에 포함되지 않음)

> 3. 정규식(Regular Expression) - java.util.regex패키지
- 정규식 : 텍스트 데이터 중에서 원하는 조건(패턴, pattern)과 일치하는 문자열을 찾아 내기 위해 사용하는 것, 미리 정의된 기호와 문자를 이용해서 작성한 문자열을 말한다.


- 정규식 이용시
1) 많은 양의 텍스트 파일 중 원하는 데이터를 쉽게 뽑아낼 수 있다.
2) 입력된 데이터가 형식에 맞는지 체크할 수 있다.
3) 예시 : html문서에서 전화번호나 이메일 주소만을 따로 추출한다던가, 입력한 비밀번호가 숫자와 영문자의 조합으로 되어 있는지 확인한다.


- 정규식들
1) int[] fillRand(int[] arr, int from, int to) : 배열 arr을 from과 to범위의 값들로 채워서 반환한다.
2) int[] fillRand(int[] arr, int[] data) : 배열 arr을 배열 data에 있는 값들로 채워서 반환한다.
3) int getRand(int from, int to) : from과 to범위의 정수(int)값을 반환한다. from과 to 모두 범위에 포함된다.
4) Pattern p = Pattern.compile("c[a-z]"); : 정규식을 매개변수로 Pattern클래스의 static메서드인 Pattern compile(String regex)을 호출하여 Pattern인스턴스를 얻는다.
5) Matcher m = p.matcher(data[i]); : 정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher인스턴스를 얻는다.
6) if (m.metches()) : Matcher인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인한다.

> 4. java.util.Scanner클래스
- Scanner생성자
1) Scanner(String source)
2) Scanner(File source)
3) Scanner(InputStream source)
4) Scanner(Readable source)
5) Scanner(ReadableByteChannel source)
6) Scanner(path source)

-입력받을 값에 따른 메서드
1) boolean nextBoolean()
2) byte nextByte()
3) shourt nextShort()
4) int nextInt()
5) long nextLong()
6) double nextdouble()
7) float nextFloat()
8) String nextLine()

> 5. java.until.StringTokenizer클래스
- StringTokenizer는 긴 문자열을 지정된 구분자를 기준으로 토큰이라는 여러 개의 문자열로 잘라내는 데 사용된다
- StringTokenizer를 이용하는 방법 이외에도 정규식인 String의 split(String regex)이나 Scanner의 useDelimiter(String pattern)를 사용할 수 도 있다


- StringTokenizer의 생성자와 메서드
1) StringTokenizer(String str, String delim) : 문자열(str)을 지정된 구분자(delim)로 나누는 StringTokenizer를 생성한다.(구분자는 토큰으로 간주되지 않음)
2) StringTokenizer(String str, String delim, boolean returnDelims) : 문자열(str)을 지정된 구분자로 나누는 StringTokenizer를 생성한다. returnDelims의 값을 true로 하면 구분자도 토큰으로 간주된다.
3) int countTokens() : 전체 토큰의 수를 반환한다.
4) boolean hasMoreTokens() : 토큰이 남아있는지 알려준다.
5) String nextToken() : 다음 토큰을 반환한다.

> 6. java.math.Biglnteger클래스
- 정수형으로 표현할 수 있는 값의 한계가 있음 최대 long일때 10진수로 19자리정도 이보다 더 큰 값을 다뤄야 할 때 Biglnteger클래스를 사용한다
- Biginteger는 String처럼 불변(immutable) 따라서 부호를 따로 저장하고 배열에는 값 자체만 저장한다

>> 1) Biglnteger의 생성
- 문자열을 숫자로 표현하는 것이 일반적

>> 2) 다른 타입으로의 변환
- BigInteger도 Number로부터 상속받은 기본형으로 변환하는 메서드들을 가지고 있다. (???Value())

>> 3) BigIntger의 연산
- BigInteger는 불변이므로 반환타입이 BigInteger라는 얘기는 새로운 인스턴스가 반환된다는 뜻이다.

>> 4) 비트 연산 메서드
- 비트연산자 : and, or, xor, not

> 7. java.math.BigDecimal클래스
- BigDecimal 역시 불변이다. 정수를 이용해 실수를 표현하는것으로 오차가 없는 2진 정수로 변환한다
- 예시 123.45는 12345 * 10^-2로 표현할 수 있고 이때의 값이 BigDecimal에 저장되면 intVal의 값은 12345 scale의 값은 2가 된다 scale은 소수점 이하의 자리수를 의미한다. 그리고 precision의 값은 5개 되는데 이 값은 정수의 전체 자리수를 의미한다.


>> 1) BigDecimal의 생성
- 문자열로 숫자를 표현하는 것이 일반적인 방법이다.
- double타입의 값을 매개변수로 갖는 생성자를 사용하면 오차가 발생할 수 있다.

>> 2) BigDecimal의 연산
- 곱셈에서는 두 피연산자의 scale을 더하고 나눗셈에서는 뺸다. 덧셈과 뺄셈에서는 둘 중에서 자리가 높은 쪽으로 맞추기 위해서 두 scale중에서 큰 쪽이 결과가 된다.

>>3) 반올림 모드 - divide()와 setScale()
- 반올림(roundingMode) : 여러가지로 정의된 상수들이 있음
- 1.0/3.0처럼 divide()로 나눗셈한 결과가 무한소수일 경우 반올림 모드를 지정해주지 않으면 예외가 발생한다.

>> 4) java.math.MathContext
- 이 클래스는 반올림모드와 정밀도(precision)을 하나로 묶어 놓은 것이다.
- 한 가지 주의할 점은 이 클래스에서는 소수점이하의 자리수를 scale이 아닌 precision이 정수와 소수점 이하를 모두 포함한 자리수를 의미한다.

>> 5) Scale의 변경
- BigDecimal을 10으로 곱하거나 나누는 대신 scale값을 변경함으로써 같은 결과를 얻을 수 있다.
- BigDecimal의 Scale을 변경하려면 setScale()을 이용하면 된다.