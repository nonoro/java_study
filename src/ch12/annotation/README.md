## < 에너테이션(annotation) >
> 1. 에너테이션이란?
- 주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공
- 소스코드의 주속 '/** ~ */'
- 에너테이션 사용 예
  - @Test : 이 아래있는 메서드가 테스트 대상임을 프로그램에게 알린다

> 2. 표준 에너테이션
- Java에서 제공하는 에너테이션
- 메타에너테이션 : 에너테이션을 만들때 사용   

> 3. @Override -> javac.exe
- 오버라이딩을 올바르게 했는지 컴파일러가 체크하게 한다.
- 오버라이딩할 때 메서드이름을 잘못적는 실수를 하는 경우가 많다
- 오버라이딩할 때는 메서드 선언부 앞에 @Override를 붙이자.

> 4. @Deprecated
- 앞으로 사용하지 않을 것을 권장하는 필드나 메서드를 붙인다
- 주로 java.util.Date클래스의 대부분의 메서드에 @Deprecated가 붙어있다.

> 5. @Functionallnterface
- 함수형 인터페이스에 붙이면, 컴파일러가 올바르게 작성했는지 체크
  - 함수형 인터페이스에는 하나의 추상메서드만 가져야 한다는 제약이 있음

> 6. @SuppressWarnings
- 컴파일러의 경고메시지가 나타나지 않게 억제한다.
- 괄호()안에 억제하고자하는 경고의 종류를 문자열로 지정
- 둘 이상의 경고를 동시에 억제하려면 다음과 같이 한다
  - @SuppressWarnings( { "deprecation", "unchecked", "varargs" } )
- 보통 @SafeVarargs와 같이 사용한다

> 7. 메타 애너테이션
- 메타 애너테이션은 '애너테이션을 위한 애너테이션'
- 메타 애너테이션은 java.lang.annotation패키지에 포함
  1) @Target
  - 애너테이션을 정의할 때 적용대상 지정에 사용
  2) @Retention
  - 애너테이션이 유지(retention)되는 기간을 지정하는데 사용
  - 컴파일러에 의해 사용되는 애너테이션의 유지 정책은 SOURCE이다
  3) @Documented, @inherited
  - javadoc으로 작성한 문서에 포함시키려면 @Documented를 붙인다
  - 애너테이션을 자손 클래스에 상속하고자 할 때, @Inherited를 붙인다.
  4) @Repeatable
  - 반복해서 붙일 수 있는 애너테이션을 정의할 때 사용
  - @Repeatable이 붙은 애너테이션은 반복해서 붙일 수 있다.
  - @Repeatable인 @ToDo를 하나로 묶을 컨테이너 애너테이션도 정의해야 함

> 8. 애너테이션 타입 정의하기
- 애너테이션을 직접 만들어 쓸 수 있다.
```
@interface 애너테이션이름 {   
    타입 요소이름();
```
- 에너테이션의 메서드는 추상 메서드이며(구현할 필요 없음), 애너태이션을 적용할 때 지정(순서X)

> 9. 애너테이션의 요소
- 적용시 값을 지정하지 않으면, 사용될 수 있는 기본값 지정 가능(null제외)
- 요소가 하나이고 이름이 value일 때는 요소의 이름 생략가능
- 요소의 타입이 배열인 경우, 괄호{}를 사용해야 한다.

> 10. 애너테이션의 조상
- Annotation은 모든 애너테이션의 조상이지만 상속은 불가
- 사실 Annotation은 인터페이스이다. - 추상메서드 들을 가지고 잇는데 이걸 구현안하고 사용할 수 있다. 컴파일러가 자동으로 구현해줌

> 11. 마커 애너테이션
- 요소가 하나도 정의되지 않은 애너테이션

> 12. 애너테이션 요소의 규칙
- 애너테이션의 요소를 선언할 때 아래의 규칙을 반드시 지켜야 한다
  - 요소의 타입은 기본형, String, enum, 애너테이션, Class(설계도 객체)만 허용됨
  - 괄호() 안에 매개변수를 선언할 수 없다.
  - 예외를 선언할 수 없다
  - 요소를 타입 매개변수로 정의할 수 없다.
  - static final 상수 ok, default메서드 X