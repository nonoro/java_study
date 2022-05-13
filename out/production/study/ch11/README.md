## < 컬렉션 프레임웍(collections framework) > : 여러번 반복하고 빠르게 전체적으로 보고 실습 해보기
- 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식 : 컬렉션(여러 객체(데이터)를 모아 놓은것) + 프레임웍(표준화된(정해진 틀) 프로그래밍 방식)
- 장점
  1) 컬렉션을 쉽고 편리하게 다룰 수 있는 다양한 클래스를 제공(저장, 삭제, 검색, 정렬 등)
  2) 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어있어 사용법을 익히기 편리하다
  3) 코드의 재사용성이 높다.
  4) 유지보수가 쉬워짐
- 컬렉션 클래스
  - 다수의 데이터를 저장할 수 있는 클래스 
  - 예) Vector, ArrayList, HashSet등
  
### 1. 컬렉션 프레임웍의 핵심 인터페이스 (***제일중요***)
- 컬렉션데이터 그룹 3가지 - 3가지 인터페이스 - List, Set, Map
- 인터페이스의 List와 set의 공통된 부분을 다시 뽑아 새로운 인터페이스인 Collection을 추가로 정의
- Map인터페이스는 List와 Set과는 전혀 다른 형태로 컬렉션을 이뤄 같은 상속계층도에 포함되어있지 않다.
- List : ***순서 O, 중복 O***
  - 예) 대기자 명단
    - 구현 클래스 : ***ArrayList, LinkedList***, Stack, Vector(ArrayList와 거의 같음 얘는 옛날거)등
- List 인터페이스의 메서드(컬렉션 메서드도 가지고있다)
    1) void add(), boolean addAll : 추가
    2) Object get() : 읽기(객체가져오기)
    3) Object set() : 변경(내용변경)
    4) Object remove() : 삭제
    5) int indexOf() (왼 -> 오), int lastIndexOf() (오 -> 왼) : 검색
    6) void sort() : 정렬
    7) List subList() : 일부만 뽑아내는것(from ~ to)
- Set : ***순서 X, 중복 X*** 
  - 예) 양의 정수 집합, 소수의 집합, 네발동물(개, 고양이, 사자, 코끼리, 개(x)-중복허용 x, 순서도 유지 x)
    - 구현 클래스 : ***HashSet, TreeSet***등
- Set 인터페이스의 메서드
    1) 집합과 관련된 메서드 + 컬렉션 메서드 
- Map : 키와 값의 쌍으로 이루어진 데이터의 집합, 순서는 X, 키는 중복을 X 값은 중복을 O
  - 예) 우편번호, 지역변호(전화번호 => 02 - 서울 031 - 경기), id와 pwd(비밀번호) - id(키)는 같을 수 없지만 pwd(값)는 같을 수 있다
    - 구현 클래스 : ***HashMap, TreeMap***, Hashtable, Properties 등
- Map 인터페이스의 메서드
    1) Object put(Object key, Object value), void putAll(Map t) : 추가
    2) Set entrySet(), Set keySet(), Collection Values() : 읽기 ( Key와 Value의 한쌍을 entry라고 한다 ) 
    3) Object remove(Object key) : 삭제
    4) boolean containsKey(Object Key), boolean containsValue(Object Value), Object get(Object key) : 검색

* Collection타입은 순서 O, X 중복 O, X 둘다 가능

#### 1) Collection인터페이스
- Collection인터페이스 : List와 Set의 조상
- Collection인터페이스는 컬렉션 클래스에 저장된 데이터를 읽고, 추가하고 삭제하는 등의 컬렉션을 다루는 가장 기본적인 메서드를 정의하고 있다.
- 매개변수로 Object대신 E, T, K, V를 사용하는데 이것은 지네릭스에 의한 표기이다. 
- Collection인터페이스의 메서드
  1) boolean add() : 추가
  2) void clear() : 전체삭제
  3) boolean contains() : 검색
  4) boolean remove() : 삭제

#### 2) List인터페이스
- List인터페이스 : 중복을 허용, 저장순서가 유지되는 컬렉션을 구현하는데 사용된다.

#### 3) Set인터페이스
- Set인터페이스 : 중복을 허용하지않음, 저장순서가 유지되지 않는 컬렉션 클래스을 구현하는데 사용된다.
- Set인터페이스 구현클래스 : HashSet, TreeSet 등

#### 4) Map인터페이스
- Map인터페이스 : 키와 값을 하나의 쌍으로 묶어서 저장하는 컬렉션 클래스를 구현하는데 사용, 키는 중복x, 값은 중복 O
- 기존에 저장된 데이터와 중복된 키와 값을 저장하면 기존의 값은 없어지고 마지막에 저장된 값이 남게 된다.
- Map인터페이스 구현클래스 : Hashtable, HashMap, LinkedHashMap, SortedMap, TreeMap등
- values()에서는 반환타입이 Collection : Map인터페이스에서 값(Value)은 중복을 허용하기 때문
- 키는 반환타입이 Set : Map인터페이스에서 키는 중복을 허용하지 않기 때문

#### 5) Map.Entry인터페이스
- Map의 내부 인터페이스
- key-value쌍을 다루기 위해 내부적으로 Entry인터페이스를 정의해 놓았다.

#### 6) ArrayList
- ArrayList는 기존의 vector를 개선한 것으로 구현원리와 기능적으로 동일
    - ArrayList와 달리 Vector는 자체적으로 동기화처리가 되어 있다.
- List인터페이스를 구현하기 때문에 순서 O, 중복 O 
- Object배열을 이용해서 데이터를 순차적으로 저장(배열기반)
- 정리 : ArrayList는 List인터페이스를 구현해서 저장순서가 유지되고 중복을 허용하고 데이터의 저장공간으로 배열을 사용한다.
- ArrayList의 기본 생성자
  1) ArrayList()
  2) ArrayList(Collection c)
  3) ArrayList(int initialCapacity) : 배열의 길이를 넣어주는 생성자(추가 삭제를 할 수 있기 때문에 좀 넉넉하게)
- ArrayList의 추가 메서드
  1) boolean add(Object o)
  2) void add(int index, Object element) : 원래 추가를하면 맨뒤에(오른쪽) 추가되는데 얘는 추가할 위치(index)를 정할 수 있음
  3) boolean addAll(Collection c) : 컬렉션이 가진위치 그대로 저장
  4) boolean addAll(int index, Collection c) : 위치를 지정해서 거기에 저장
- ArrayList의 삭제 메서드
  1) boolean remove(Object o) 
  2) Object remove(int index) 
  3) boolean removeAll(Collection c)
  4) void clear()
- ArrayList의 검색 메서드
  1) int indexOf(Object o) : 왼쪽부터 오른쪽으로 객체가 몇번째에 저장되어있는지 찾음 못찾으면 -1을 반환
  2) int lastIndexOf(Object O) : 오른쪽 부터 왼쪽으로 객체를 찾음
  3) boolean contains(Object o) : 객체 존재여부 확인
  4) Object get(int index) : 객체 읽기
  5) Object set(int index, Object element) : 특정 위치에있는 객체를 다른것으로 바꿈
  6) List subList(int fromIndex, int tolndex) : 리스트가 있으면 일부만 뽑아내서 새로운 리스트를 만듬
  7) Object[] toArray() : ArrayList의 객체 배열을 반환
  8) boolean isEmpty() : 객체가 비어있는지 확인
  9) void trimToSize() : 빈공간 제거
  10) int size() : 객체의 갯수 반환

- ArrayList에 저장된 객체의 삭제과정
1) ArrayList에 저장된 첫 번째 객체부터 삭제하는 경우(배열 복사 발생) - 오래걸림 - 이렇게 위에서부터 지우면 성능상도 안좋고 다 지워지지 않는 경우도 생김
- 변수 i 를 증가시켜가면서 삭제하면 한 요소가 삭제될 때마다 빈 공간을 채우기 위해 나머지 요소들이 복사되어 자리이동을 하기 때문에 올바른 결과를 얻을 수 없다.
- 원리 : 만약 위에서부터 0, 1, 2 ,3 ,4 ,5 이렇게 있을때 2를 지우고싶으면 3, 4, 5를 복사해서 2, 3, 4의 자리에 덮어씌우면 0, 1, 3, 4, 5, 5 이렇게 된다 그리고나서 마지막에 있는 5를 없애기위해 date[size -1] = null을해준다. 그리고 size의 크기를 실제 데이터의 갯수의 크기와 맞춰야하므로 size--를 해준다.
  ```
  System.arraycopy(data, 3, data, 2, 2);   //  data[3]에서 data[2]로 2개의 데이터를 복사라하는 의미. (2개의 데이터는 데이터 3을 포함하는 곳에서 부터 아래로 2개)
  ``` 
  ```
   for (int i = 0; i < list.size(0; i++)
        list.remove(i);
   ```
3) ArrayList에 저장된 마지막 객체부터 삭제하는 경우(배열 복사 발생안함) - 빠름 - 
   ```
   for (int i = list.size() - 1; i >= 0; i--)
     list.remove(i);
   ```
- Java API 소스 보기 - /jdk설치경로/src.zip

#### 7) LinkedList
- 배열의 장단점
  - 장점 
    1) 배열은 구조가 간단하고 데이터를 읽는 데 걸리는 시간(접근시간, access time)이 짧다. (접근시간이 짧다 : 배열의 첫번째요소와 마지막요소를 불러오는 시간이 같다)
    2) 연속적이다.(만약 첫번째 배열주소가 0x100이고 int[]배열이고 한칸당 4바이트 일 경우 3번째 배열의 주소를 알고싶으면 0x100 + 4 * 2(index)를 하면 된다. 따라서 n번째 요소의 주소를 구하는게 빠르다)
  - 단점 (크기변경 x, 추가삭제의 시간이 많이걸린다)
    1) 크기를 변경할 수 없다. (크기를 변경하는 경우 새로운 배열을 생성 후 데이터를 복사해야함)
       * 크기를 변경하기 위한 방법
          1) 더 큰 배열 생성
          2) 기존내용복사
          3) 참조변경 
    2) 비순차적인 데이터의 추가, 삭제에 시간이 많이 걸린다.(만약 인덱스 2의 위치의 데이터를 지우고 싶으면 삭제시 나머지 2뒤에 있는 배열전체를 복사해서 앞으로 땡겨야됨 그래서 시간이 오래 걸림)
       그러나 순차적인 데이터 추가(끝에 추가)와 삭제(끝부터 삭제)는 빠르다.
    
- LinkedList : 배열의 단점을 보완(불연속적으로 존재하는 데이터르 서로 연결(link)) 
  - 기차를 연결해논 것과 비슷 
  - 변경에 유리 중간에 끼워넣을 수 있음
  - 중간에 요소를 삭제하고 싶으면 현재 노드에 삭제하고자 하는 요소의 다음 요소를 참조하도록 변경하면 된다.
    ```
    Class Node {              //  현재 노드(객체)
        Node next;            //  다음 요소(노드)의 주소를 저장
        Object obj;           //  데이터를 저장
    ```
  - LinkedList 단점 
    1) 불연속적이라서 접근성이 나쁘다.(바로 다음 요소까지는 갈 수 있는데 한번에 갑자기 1번에서 5번째 요소까지 못간다.)
  
- ***doubly linked list(이중 연결리스트)*** (현재 이게 제일 많이 쓰임)
  1) linked list의 단점을 보완한 것
  2) 접근성 향상(현재 요소에서 앞 뒤로 이동가능)
  ```
  Class Node {              //  현재 노드(객체)
    Node next;
    Node previous;          //  다음 요소
    Object obj;             //  이전 요소
  ```
- doubly circular linked list(이중 원형 연결리스트)
  1) 첫 요소와 끝 요소를 연결해 놓은것 : 티비 채널 끝에서 위로 올리면 1번채널로 가는것과 비슷

- Arraylist(배열기반-연속적) vs LinkedList(연결기반-불연속적)
  1) 순차적으로 데이터를 추가/삭제 - ArrayList가 빠름
  2) 비순차적으로 데이터를 추가/삭제 - LinkedList가 빠름 (중간에 추가 삭제)
  3) 접근시간(access ime) - ArrayList가 빠름 (인덱스가 n인 데이터의 주소 = 배열의 주소 + n * 데이터 타입의 크기)

#### 8) 스텍과 큐(Stack & Queue)
- 스택(Stack) : LIFO(Last In First Out)구조 마지막에 저장된 것을 제일 먼저 꺼내게 된다. (밑이 막힌 상자에 책을 넣고 뺀다고 생각하면된다.)
  - 저장(push), 추출(pop) 
  - 0, 1, 2 이렇게 들어오면 2, 1, 0 이렇게 나감
- 큐(Queue) : FIFO(First In First Out)구조 제일 먼저 저장한 것을 제일 먼저 꺼내게 된다. (양 끝이 뚫린 상자, 줄서기라고 보면 됨)
  - 저장(offer), 추출(poll)
  - 0, 1, 2 이렇게 들어오면 0, 1, 2 이렇게 나감

- 스택을 구현할 때 효율적인 것 : 배열 vs 링크드리스트 = 배열 : 순차적으로 저장되고 제일 위 부터 순차적으로 추가 및 삭제를 할 수 있어서
- 큐를 구현할 때 효율적인 것 : 배열 vs 링크드리스트 = 링크드리스트 : 삭제방향이 왼쪽에서 오른쪽 따라서 배열로 할 시 삭제할때 너무 비효율적임
- Stack에서 search는 만약 0, 1, 2를 push했다고 했을 때 pop할 때 순서가 2, 1, 0인데 그래서 상자안에 담겻을때 인덱스가 2부터 1, 2, 3이다. (search는 배열과 달리 0이 아닌 1부터 시작)
- Queue에서는 객체를 추가하고 삭제할때 예외를 발생하는 메서드랑 발생시키지않고 null을 반환하는 메서드가 있다.
  - null을 반환하는 메서드는 offer(입력), poll(삭제) 
  - 자바에서 Queue는 인터페이스로 구성되어있어서 Queue = new Queue()를 하면 안된다 인터페이스이기 때문에
  - Queue의 기능을 가진 객체를 쓰고 싶을때 하는방법
    1) Queue를 직접 구현한다.
    2) Queue를 구현한 클래스를 사용한다. 
       => Java API에 Queue인터페이스가 있음 거기보면 Queue인터페이스를 구현한 클래스의 목록이 있다. 이중에 LinkedList를 사용하면 된다. 

#### 9) 스택과 큐의 활용
- 스택의 활용 예 : 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로
- 큐의 활용 예 : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

* PriorityQueue 
  - Queue인터페이스의 구현체 중의 하나로, 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼내게 된다는 특징이 있다. 우선순위는 숫자가 작을수록 높음
  - null은 저장할 수 없다.
  - 저장공간으로 배열을 사용하며 각 요소를 힙이라는 자료구조의 형태로 저장한다.

* Deque(Double-Ended Queue)
  - 한 쪽 끝으로만 추가/삭제 할 수 있는 Queue와 달리 Dequq(덱 or 디큐)은 양쪽 끝에 추가/삭제가 가능하다.
  - Deque는 스택과 큐를 하나로 합쳐놓은 것과 같으며 스택으로 사용할 수도 있고, 큐로 사용할 수도 있다.

#### 10) Iterator, Listlterator(양방향), Enumeration(old버전)
- 컬렉션에 저장된 데이터를 접근(읽기)하는데 사용되는 인터페이스
- Iterator 핵심 메서드 (얘만 알면 됨)
  - boolean hasNext() : 읽어올 요소가 남아있는지 확인
  - Object next() : 다음 요소를 읽어 온다.
- Enumeration은 Iterator의 구버전
- Listlterator는 Iterator의 접근성을 향상시킨 것(단방향 -> 양방향), (잘안씀)

> Iterator
- 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화한 것
- 컬렉션에 Iterator()를 호출해서 lterator를 구현한 객체를 얻어서 사용


* 참조변수의 타입을 Collection타입으로 하는 이유 
- Collection에없고 생성하고자하는 객체의 타입에만 있는 메서드를 사용하는게 아니라면 Collection타입의 참조변수로 선언하는 것이 좋다. 이유는 Collection인터페이스를 구현한 다른 클래스로 클래스를 변경시 선언문 하나만 변경하면 되고 나머지 아래 코드는 검토하지 않아도 되기 떄문이다.

#### 11) Map과 iterator
- Map에는 iterator()가 없다.
- Map에서 iterator()를 호출하기 위해선 keySet(), entrySet(), values()를 호출해야한다.
  ```
        ex) Map map = new HashMap();
        ...
        Iterator it = map.entrySet().iterator();
  ```               
  
#### 12) ListIterator와 Enumeration
- Enumeration = Iterator의 구버전
- ListLterator = Iterator에 양방향 조회기능추가(List인터페이스를 구현한 컬렉션에서만 사용가능)

> remove()
- next()로 읽을때 읽으면서 원래 있던곳에 그 읽은 정보를 삭제하는것 
- 얘는 만약 0, 1, 2, 3, 4 가 있을때 next() 로 0을 읽은다음 remove()를 하면 0을 삭제한다 그리고 또 next()로 1을 읽고 remove()를 하면 1을 삭제한다
  결국 0, 1, 2, 3, 4를 담고있는 객체에는 2, 3, 4만 남게된다.
                           
#### 13) Arrays
- 배열을 다루기 편리한 메서드(모두 static메서드임) 제공
- 배열의 출력 - toString()
- 배열의 복사 - copyOf(복사대상, 복사기준), copyOfRange(arr, from, to) - to는 범위에 안들어감, copy는 둘다 남는 공간은 0으로 채운다
- 배열 채우기 - fill(arr, 9(이 값으로 배열을 채움)), setAll()
- 배열의 정렬과 검색 -sort(), binarySearch()-얘 쓰려면 sort로 정렬한다음 쓸 수 있다, 인덱스를 반환 
- 다차원 배열의 출력 - deepToString()
- 다차원 배열의 비교 - deepEquals()
- 배열을 list로 변환 - asList(Object...a) - 가변 매개변수 - list는 읽기전용 그래서 추가는 안됨 그래서 변경하고 싶으면 ArrayList에 추가하고자하는 객체의 값을 복사해서 넣고 새로운 객체를 만들어서 추가

#### 14) Comparator와 Comparable
- 객체 정렬에 필요한 메서드(정렬기준 제공)를 정의한 메서드
  - Comparable 기본 정렬기준을 구현하는데 사용 : compareTo(): 주어진객체를 자신(this)과 비교
  - Comparator 기본 정렬기준외에 다른 기준으로 정렬하고자 할 때 사용 : compare(정렬대상, 정렬기준) : 0-같다, 양수-왼쪽이크다, 음수-오른쪽이크다,
  * 정렬 sort()
    1) 두 대상 비교
    2) 자리바꿈
    3) 오름차순
    4) 내림차순

#### 15) HashSet - 순서X, 중복X
> HashSet
- Set인터페이스를 구현한 가장 대표적인 컬렉션
- 순서를 유지하려면, LinkedHashSet클래스를 사용하면 된다.
- HashSet에 새로운 요소를 추가할 때는 add메서드나 addAll메서드를 사용하는데 만일 이미 HashSet에 저장되어 있는 요소와 중복된 요소를 추가하고자 한다면 false를 반환하는데 이러한 점을 이용해 컬렉션 내의 중복요들을 쉽게 제거할 수 있다.

> TreeSet - from ~ to
- 범위 검색과 정렬에 유리한 컬렉션 클래스
- HashSet보다 데이터 추가, 삭제에 시간이 더 걸림

- HashSet정리
  1) HashSet은 객체를 저장하기전에 기존에 같은 객체가 있는지 확인
  2) 같은 객체가 없으면 저장하고, 있으면 저장하지 않는다.
  3) boolean add(Object o)는 저장할 객체의 equals()와 hashCode()를 호출(중복을 확인하는 메서드)
  4) equlas()와 hashCode()가 오버라이딩 되어 있어야함 
     - 최근에는 hashCode() 메서드 사용시 return Objects.hash() 이렇게 바뀜
  
#### 16) TreeSet (39~41) - 범위 탐색, 정렬
- 이진 탐색 트리로 구현. ***범위 탐색과 정렬에 유리***
- 이진 트리는 모든 노드가 최대 2(0~2)개의 하위 노드를 갖음 각 요소(node)가 나무(tree)형태로 연결(LinkedList)의 변형

> 이진 탐색 트리
- 부모보다 작은 값은 왼쪽, 큰 값은 오른쪽에 저장
- 단점 : 데이터가 많아질 수록 추가, 삭제에 시간이 더 걸림(비교 횟수 증가) 따라서 추가,삭제는 링크드리스트가 유리

> TreeSet - 데이터 저장과정 boolean add(Object o(저장할 객체)) 
- add메서드를 호출하면 add메서드 내에서 equals랑 hashcode메서드를 호출
- 중복 x

> TreeSet 메서드 - 범위검색
1) subSet(0, 0) : 범위안의 값들을 얻을 수 있다.
2) headSet() : 괄호안에 값보다 작은 값들을 얻을 수 있다.
3) tailSet() : 괄호안에 값보다 큰 값들을 얻을 수 있다.

> 트리 순회(tree traversal)
- 이진 트리의 모든 노드를 한번씩 읽는 것을 트리 순회라고 한다.
- 전위, 중위, 후위 순회법이 있으며 중위 순회하면 오름차순으로 정렬된다.
  - 부모를 먼저 읽고 자식들을 나중에 읽는것 : 전위순회(pre order)
  - 자식부터 먼저 읽고 부모를 나중에 읽은것 : 후위순회(post order)
  - 가운데기준 왼쪽 자식 읽고 부모읽고 오른쪽자식 읽고 : 중위 순회(in order) - 오름차순으로 정렬
  - 순서대로 부모 그 아래층 자식 그리고 또 그 아래층 자식 이렇게 차례로 읽는 것 : 레벨 순회
- 정리)
  1) TreeSet은 정렬과 범위검색에 유리
  2) 단점은 트리가 커질수록 추가, 삭제가 오래걸림

  
### 17) HashMap과 Hashtable - 순서 X, 중복(키 X, 값 O)
- Map인터페이스를 구현. 데이터를 키와 값의 쌍으로 저장 (key(중복 X : id), value(중복 O : pwd))
- HashMap(동기화 X)은 Hashtable(동기화 O)의 신버젼 : 보통은 HashMap을 쓰면됨

> HashMap
- Map인터페이스를 구현한 대표적인 컬렉션 클래스
- Map은 원래 순서를 유지하지 않는다 만약 순서를 유지하려면 LinkedHashMap클래스를 사용하면 된다.

> TreeMap
- 범위 검색과 정렬에 유리한 컬렉션 클래스
- HashMap보다 데이터 추가, 삭제에 시간이 더 걸림
- key, value로 저장한다는 것만 빼면 TreeSet과 같음

> HashMap의 키(key)와 값(value) 
- 해싱(hashing)기법으로 데이터를 저장. 데이터가 많아도 검색이 빠르다
- Map인터페이스를 구현. 데이터를 키와 값의 쌍으로 저장
  ```
  키(key) : 컬렉션 내의 키(key) 중에서 유일해야 한다
  값(vaule) : 키(key)와 달리 데이터의 중복을 허용한다.(이미 존재하는 키에 대한 값을 저장하면 기존의 값을 새로운 값으로 덮어쓴다)
  ```
- key, value값의 한쌍이 Entry
  ```
  Entry[] table;
  class Entry {
    Object key;
    Object value;
  ```

> 해싱(hashing)
- 해시함수(hash function)로 해시테이블(hash table)에 데이터를 저장, 검색(***해쉬함수를 이용해서 데이터를 저장하고 읽어오는것이 해싱***)  
1) 환자정보관리
   - 출생년도로 분류해서 캐비넷에 저장 : 00년대, 10년대, 20년대, 30년대, 40년대, 50년대, 60년대, 70년대
   - 환자정보를 찾아주세요 주빈번호 72xxxx-xxxxxxx
   - 72xxxx-xxxxxxx이면 캐비넷 7번서랍
   - 72xxxx-xxxxxxx -> 해시함수(hash function) -> 7(인덱스, 해쉬코드 : 저장위치) 
- ***해시함수(hash function) : 어떤 키 값을 넣으면 배열의 인덱스를 알려줌 즉 저장위치를 알려줌***
- ***해쉬코드(hashcode) : 저장위치***
- ***과정 : 키(key) 주민번호를 입력 -> 해시함수가 저장위치인 해시코드(배열의 인덱스)를 알려줌 -> 그래서 그 캐비넷을 열어서 거기 있는 데이터를 확인해서 찾음***
  1) 키로 해시함수를 호출해서 해시코드를 얻는다.
  2) 해시코드(해시함수의 반환값)에 대응하는 링크드리스트를 배열에서 찾는다.
  3) 링크드리스트에서 키와 일치하는 데이터를 찾는다
  * 해시함수는 같은 키에 대해 항상 같은 해시코드를 반환해야 한다. 서로 다른 키일지라도 같은 값의 해시코드를 반환할 수도 있다.(키값이 달라도 같은 캐비넷(배열의 인덱스)에 있을 수 있기 때문에)
- ***해시테이블은 배열과 링크드리스트가 조합된 형태(링크드리스트 여러개를 배열로 묶어놓은것) : 링크드리스트의 장점인 변경이 쉽게 + 배열의 장점인 접근성이 쉽게를 섞어놓은것***
- Objects.hash()이 메서드를 이용해서 사용하면 된다. : 해싱을 구현한 클래스 :HashMap, HashSet, Hashtable

> Properties
- HashMap의 구버젼인 Hashtableㅇ르 상속받아 구현한 것
- 키와 값을 (String, String)으로 저장한다
- 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공한다.

### 18) Collections - 컬렉션을 위한 메서드(static)를 제공 : 비슷한걸로 Objects(객체), Arrays(배열), Collections(컬렉션)
- 컬렉션 채우기, 복사, 정렬, 검색 - fill(), copy(), sort(), binarySearch() 등
- 컬렉션의 동기화 - synchronizedXXX()
  ```
  List syncList = Collections.synchronizedList(new ArrayList())
  동기화된 리스트                                동기화되지 않은 리스트
  ```
- 변경불가(readOnly) 컬렉션 만들기 - unmodifiableXXX() : final과 비슷
- 싱글톤 컬렉션 만들기 - singletonXXX() : 객체 1개만 저장
- 한 종류(타입)의 객체만 저장하는 컬렉션 만들기 - checkedXXX() : 원래 컬렉션에는 모든 타입을 다 넣을 수 있음 근데 얘를 붙이면 한 타입만 됨
- 