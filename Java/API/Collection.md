
# HashMap 

    HashMap<Key, Value> map = new HashMap<>();          // 초기값 지정하지 않고 생성
    HashMap<Key, Value> map = new HashMap<>(){{
    put(Key, Value);
    put(Key, Value);
    }};                                                 // 초기값 지정하여 생성
    value       = map.put(key, value);                  // (key, value) 넣기, key가 이미 있으면 갱신, 이전 value 반환, 이전 value가 없으면 null 반환
    void        = map.clear();                          // 모든 값 삭제
    value       = map.get(key);                         // value 얻기, 없으면 null 반환
    boolean     = map.containsKey(key);                 // key가 있는지 확인
    boolean     = map.containsValue(value);             // value가 있는지 확인
    value       = map.remove(key);                      // (key, value) 제거, value 반환, 없으면 null 반환
    int         = map.size();                           // 크기 반환
    boolean     = map.isEmpty()                         // map이 크기가 0인지 확인
    Set         = map.keySet();                         // 모든 key 반환
    Collection  = map.values();                         // 모든 value 반환
    for (Map.Entry entry : map.entrySet()) {            // map 순회
    key         = entry.getKey();
    value       = entry.getValue();}

# LinkedHashMap 

    LinkedHashMap<Key, Value> map = new LinkedHashMap<>();
    LinkedHashMap<Key, Value> map = new LinkedHashMap<>(){{
    put(key, value);
    put(key, value);
    }};
    
    // HashMap과 동일
    // 입력된 순서대로 데이터 저장

# TreeMap 

    TreeMap<Key, Value> map = new TreeMap<>();
    TreeMap<Key, Value> map = new TreeMap<>(Collections.reverseOrder());
    TreeMap<Key, Value> map = new TreeMap<>(){{
    put(key, value);
    put(key, value);
    }};
    
    // HashMap과 동일
    // 오름차순 순서대로 데이터 저장

# HashSet 

    HashSet<Element> set = new HashSet<>(Arrays.asList(element1, element2));    // 초기값 지정하여 생성
    HashSet<Element> set = new HashSet<>();                                     // 초기값 지정하지 않고 생성
    boolean             = set1.retainAll(set2);                                 // 교집합, set1이 바뀌었으면 true, 아니면 false
    boolean             = set1.addAll(set2);                                    // 합집합, set1이 바뀌었으면 true, 아니면 false
    boolean             = set1.removeAll(set2);                                 // 차집합, set1 - set2, set1이 바뀌었으면 true, 아니면 false
    boolean             = set1.containsAll(set2);                               // set1이 set2를 포함하면 true, 아니면 false
    boolean             = set.add(element);                                     // element를 set에 넣기, 넣어지면 true, 이미 있었으면 false
    void                = set.clear();                                          // element 전부 삭제
    boolean             = set.remove(element);                                  // elemenet 삭제, 삭제됬는지 반환
    int                 = set.size();                                           // 크기 반환
    boolean             = set.isEmpty();                                        // set이 비어있는지 확인
    boolean             = set.contains(element);                                // element가 있는지 확인
    Iterator iterator   = set.iterator();                                       // set 순회
    while(iterator.hasNext()){
    element             = iterator.next();}
    int[]               = set.stream().mapToInt(i -> i).toArray();              // HashSet<Integer> -> int[]로 바꾸기

# TreeSet 

    TreeSet<Element> set = new TreeSet<>(Arrays.asList(element1, element2));
    TreeSet<Element> set = new TreeSet<>();
    TreeSet<Element> set = new TreeSet<>(Collections.reverseOrder());
    int[]                = set.stream().mapToInt(i -> i).toArray();             // TreeSet<Integer> -> int[]로 바꾸기
    
    // HashSet과 동일
    // 오름차순 순서대로 데이터 저장

# LinkedHashSet 

    LinkedHashSet<Element> set = new LinkedHashSet<>(Arrays.asList(element1, element2));
    LinkedHashSet<Element> set = new LinkedHashSet<>();
    int[]                      = set.stream().mapToInt(i -> i).toArray();   // LinkedHashSet<Integer> -> int[]로 바꾸기
    
    // HashSet과 동일
    // 입력된 순서대로 데이터 저장

# Stack 

    Stack<Element> stack = new Stack<>();
    element             = stack.push(element);                          // element stack에 넣기
    element             = stack.pop();                                  // element stack에서 빼기, stack이 비어있으면 Exception
    element             = stack.peek();                                 // stack에 가장 나중에 들어간 element 반환, 존재하지않으면 Exception
    void                = stack.clear();                                // stack에 있는 모든 element 지우기
    int                 = stack.size();                                 // stack의 크기 반환
    boolean             = stack.empty();                                // stack이 비어있는지 확인
    boolean             = stack.contains(element);                      // element가 있는지 확인
    Iterator iterator   = stack.iterator();                             // stack 순회(stack에서 나오는 순서가 아니라 들어간 순서)
    while(iterator.hasNext()){
    element             = iterator.next();}
    int[]               = stack.stream().mapToInt(i -> i).toArray();    // Stack<Integer> -> int[]로 바꾸기

# ArrayList 

    ArrayList<Element> list = new ArrayList<>();
    ArrayList<Element> list = new ArrayList<>(Arrays.asList(element1, element2));
    preelement          = list.set(index, element);                     // index에 value 바꾸기
    boolean             = list.add(element);                            // value 추가, list가 바뀌면 true
    void                = list.add(index, element);                     // index에 value 추가, index를 벗어나면 Exception
    element             = list.remove(index);                           // index에 있는 값 제거, 제거된 값 반환, index를 벗어나면 Exception
    boolean             = list.remove(element);                         // 첫번째로 발생한 value 제거, value가 list에 있었다면 true 반환
    void                = list.clear();                                 // list 초기화
    int                 = list.size();                                  // list의 크기 반환
    boolean             = list.isEmpty();                               // list가 비어있는지 확인, 비었으면 true 아니면 false
    element             = list.get(index);                              // index에 있는 값 반환, index를 벗어나면 Exception
    int                 = list.indexOf(element);                        // value가 있는 index 반환, 없으면 -1
    boolean             = list.contains(element);                       // value가 있는지 검색, 있으면 true 없으면 false
    Iterator iterator   = list.iterator();                              // list 순회
    while(iterator.hasNext()){
    element             = iterator.next();}
    int[]               = list.stream().mapToInt(i -> i).toArray();     // ArrayList<Integer> -> int[]로 바꾸기
    void                = list.sort(Comparator.naturalOrder());        // 오름차순 정렬
    void                = list.sort(Comparator.reverseOrder());        // 내림차순 정렬

# LinkedList 

    LinkedList<Element> list = new LinkedList<>();
    LinkedList<Element> list = new LinkedList<>(Arrays.asList(element1, element2));
    void        = list.addFirst(element);                       // 가장 앞에 element 추가
    void        = list.addLast(element);                        // 가장 뒤에 element 추가
    element     = list.removeFirst();                           // 가장 앞의 값 제거, 비어있으면 Exception
    element     = list.removeLast();                            // 가장 뒤의 값 제거, 비어있으면 Exception
    element     = list.getFist();                               // 가장 앞의 값 반환, 비어있으면 Exception
    element     = list.getLast();                               // 가장 뒤의 값 제거, 비어있으면 Exception
    int[]       = list.stream().mapToInt(i -> i).toArray();     // LinkedList<Integer> -> int[]로 바꾸기
    
    // Array List와 동일
    // 요소 접근은 느리지만 요소 삽입, 삭제는 쉬움

# Queue 
    Queue<Element> queue = new LinkedList<>();
    Queue<Element> queue = new LinkedList<>(Arrays.asList(element1, element2));
    boolean                     = queue.add(element);                           // queue에 값 넣기, 실패시 exception
    boolean                     = queue.offer(element);                         // queue에 값 넣기, 실패시 false 반환
    element                     = queue.poll();                                 // queue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
    element                     = queue.remove();                               // queue에 첫번째 값을 반환하고 제거, 비어있다면 exception
    void                        = queue.clear();                                // queue 초기화
    int                         = queue.size();                                 // queue의 크기 반환
    boolean                     = queue.isEmpty();                              // queue가 비어있는지 확인, 비었으면 true 아니면 false
    element                     = queue.peek();                                 // queue의 첫번째 값 반환, 비었으면 null 반환
    boolean                     = queue.contains(element);                      // queue에 element가 포함됐는지 확인
    element                     = queue.element();                              // queue의 첫번째 값 반환, 비었으면 exception
    Iterator<Element> iterator  = queue.iterator();                             // queue 순회
    while(iterator.hasNext()){
    element                     = iterator.next();}
    int[]                       = queue.stream().mapToInt(i -> i).toArray();    // LinkedList<Integer> -> int[]로 바꾸기

# PriorityQueue 
    PriorityQueue<Element> queue = new PriorityQueue<>();                                   // 낮은 숫자가 우선순위가 높음
    PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Collections.reverseOrder()); // 높은 숫자가 우선순위가 높음
    PriorityQueue<Element> queue = new PriorityQueue<>(Arrays.asList(element1, element2));
    boolean                     = queue.add(element);                                       // queue에 값 넣기, 실패시 exception
    boolean                     = queue.offer(element);                                     // queue에 값 넣기, 실패시 false 반환
    element                     = queue.poll();                                             // queue에 첫번째 값을 반환하고 제거, 비어있다면 null 반환
    element                     = queue.remove();                                           // queue에 첫번째 값을 반환하고 제거, 비어있다면 exception
    void                        = queue.clear();                                            // queue 초기화
    int                         = queue.size();                                             // queue의 크기 반환
    boolean                     = queue.isEmpty()                                           // queue가 비어있는지 확인, 비었으면 true 아니면 false
    element                     = queue.peek();                                             // queue의 첫번째 값 반환, 비었으면 null 반환
    element                     = queue.element();                                          // queue의 첫번째 값 반환, 비었으면 exception
    boolean                     = queue.contains(element);                                  // queue에 element가 포함됐는지 확인
    Iterator<Element> iterator  = queue.iterator();                                         // queue 순회
    while(iterator.hasNext())
    element                     = iterator.next();
    int[]                       = queue.stream().mapToInt(i -> i).toArray();                // LinkedList<Integer> -> int[]로 바꾸기
