## < 입출력 >
- 스트림 : 데이터를 운반하는데 사용되는 연결통로
  1) 단방향통신, 따라서 입출력 통신을 위해선 2개의 스트림이 필요
  2) 큐와같은 FIFO구조 : 먼저보낸 데이터를 먼저받음 놀이기구 입장대기랑 비슷
  3) int read()로 입력하고 void write(int b)로 출력한다.
  4) read()는 반드시 구현되어야 하는 핵심적인 메서드 이것만 구현하면 매개변수로 무엇이 들어가든 사용가능

- 보조스트림 : 실제 데이터를 주고받는 스트림이 아니라서 데이터를 입출력할 수 없지만 스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다.
    1) 단독사용 불가 스트림을 먼저 생성한 후에 이를 이용해서 보조스트림 생성
    2) 버퍼를 이용한 보조스트림 사용
    3) BufferedInputStream : 입력(성능향상)
    4) BufferedOutputStream : 출력(성능향상)

- 문자기반 스트림 : Reader, Writer
  1) 문자 데이터를 입출력할 때 바이트기반 스트림 대신 쓰는 스트림
  2) InputStream -> Reader로 바꿔쓰면 문자스트림
  3) outputStream -> writer로 바꿔쓰면 문자스트림
  4) byte배열 대신 char배열 사용

### 1. 바이트기반 스트림
- InputStram과 outputStream
  1) InputStram과 outputStream은 모든 바이트기반 스트림의 조상
  2) mark()와 reset()을 이용해 이미 읽은 데이터를 되돌려서 다시 읽을 수 있다.
  3) 스트림을 사용해 모든 작업을 마치고나면 JVM이 자동적으로 닫아 주기는 하지만 close()를 호출해서 반드시 닫아주자!

- ByteArrayInputStream과 ByteArrayOutputStream
  1) ByteArrayInputStream과 ByteArrayOutputStream은 메모리, 즉 바이트배열에 데이터를 입출력하는데 사용되는 스트림 
  2) 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트배열에 담아서 변환 등의 작업을 하는데 사용한다.
  * 스트림은 종류가 달라도 읽고 쓰는 방법은 동일하다
 
- FileInputStream과 FileOutputStream
  1) FileInputStream과 FileOutputStream는 파일에 입출력을 하기 위한 스트림으로 실제로 프로그래밍에서 많이 사용된다.

### 2. 바이트 기반의 보조 스트림
- FilterInputStream과 FilterOutputStream
  1) 모든 보조스트림의 조상
  
- BufferedInputStream과 BufferedOutputStream
  1) 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림
  2) 버퍼 = 바이트배열
    
- DataInputStream과 DataOutputstream
  1) DataInputStream은 DataInput 인터페이스를 구현
  2) DataOutputstream은 DataOutput 인터페이스를 구현
  3) 8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점이 있음
  4) 각 기본 자료형을 16진수로 표현하여 저장

- SequenceInputStream
  1) 여러 개의 입력스트림을 연속적으로 연결해서 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와준다.
  2) 큰 파일을 여러 개의 작은 파일로 나누었다가 하나의 파일로 합치는 것과 같은 작업을 수행할 때 사용하면 좋다.

- PrintStream
  1) 데이터를 기반스트림에 다양한 형태로 출력할 수 있는 print, println, printf와 같은 메서드를 오버로딩하여 제공한다.
  2) PrintWriter가 추가되어 더 다양한 언어의 문자를 처리하는데 적합한 PrintWriter를 주로 쓴다

### 3. 문자기반 스트림
- Reader와 Writer
  1) 문자기반 스트림의 조상 : Reader와 Writer
  2) char배열 사용

- FileReader와 FileWriter
  1) 파일로부터 텍스트데이터를 읽고 파일에 쓰는데 사용된다.

- PipedReader와 PipedWriter
  1) 쓰레드 간에 데이터를 주고받을 때 사용
  2) 다른 스트림과 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고받음 그래서 입출력 마친 후 어느 한쪽 스트림만 닫아도 나머지 스트림은 자동으로 닫힘

- StringReader와 StringWriter
  1) StringBuffer getBuffer() : StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환한다.
  2) String toString() : StringWriter에 출력된 (StringBuffer에 저장된) 문자열을 반환한다.


### 4. 문자기반의 보조스트림
- BufferedReader와 BufferedWriter
  1) 입출력의 효율을 높임
  2) BufferedReader의 readLine() 을 사용하면 데이터를 라인단위로 읽을 수 있다.
  3) BufferedWriter의 newline()을 사용하면 줄바꿈을 할 수 있다.

- InputStreamReader와 OutputStreamWriter
  1) 바이트기반 스트림을 문자기반 스트림으로 연결시켜준다 그리고 바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환하는 작업을 수행한다.
  2) 
