<br />

"SOLID"은 소프트웨어 디자인의 다섯 가지 기본 원칙을 나타내는 약어이다. 이 원칙들은 로버트 C. 마틴(Robert C. Martin)이 소프트웨어 설계의 원칙을 강조하기 위해 제안한 것으로, 소프트웨어의 유지보수성, 확장성, 가독성, 유연성을 증진하기 위한 것이다. Solid의 각 글자는 다음과 같은 원칙을 나타낸다.

<p></p>

- SRP: 단일 책임 원칙 (Single Responsibility Principle)
- OCP: 개방-폐쇄 원칙 (Open/Closed Principle)
- LSP: 리스코프 치환 원칙 (Liskov Substitution Principle)
- ISP: 인터페이스 분리 원칙 (Interface Segregation Principle)
- DIP: 의존관계 역전 원칙 (Dependency Inversion Principle)

<br />

## Single Responsibility Principle

> There should never be more than one reason for a class to change.

<p></p>

- 하나의 클래스는 하나의 기능을 가져야 한다는 원칙이다.
- 책임 영역이 확실해져 한 책임의 변경에서 다른 책임의 변경으로의 연쇄작용에서 자유로울 수 있다.
- 기능의 범위를 정하는 기준은 변경의 범위를 보면 된다. 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것이다.

<br />

## Open/Closed Principle

> You should be able to extend a classes behavior, without modifying it.

<p></p>

- 소프트웨어 구성요소가 확장에는 열려 있으나 변경에는 닫혀 있어야 한다는 원칙이다.
- 요구사항의 변경이나 추가사항이 발생하면, 기존의 코드를 수정하지 않고도 새로운 기능을 추가해야한다는 것을 뜻한다.
- 추상화와 다형성을 통해 코드의 수정을 최소화할 수 있다. 이를테면, 인터페이스를 구현한 새로운 클래스를 하나 만들어서 새로운 기능을 구현하는 방법이 있다.

<br />

## Liskov Substitution Principle

> Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.

<p></p>

- 서브 타입은 언제나 기본 타입으로 대체할 수 있어야 한다는 원칙이다.
- 다형성에서 하위 클래스는 인터페이스 규약을 지켜야 한다는 뜻이다. 예를 들어, 자동차 인터페이스가 있을 때, 그 구현체에서 엑셀은 앞으로 가라는 기능이기 때문에 뒤로 가게 구현하면 LSP를 위반하는 것이 된다.

<br />

## Interface Segregation Principle

> Clients should not be forces to depend upon interfaces that they do not use.

<p></p>

- 클라이언트는 자신이 사용하지 않는 메서드에 의존하지 않아야 한다는 원칙이다.
- 하나의 일반적인 인터페이스보다 여러 개의 구체적인 인터페이스가 낫다는 뜻이다.
- SRP가 클래스의 단일 책임을 강조한다면, ISP는 인터페이스의 단일 책임을 강조한다.

<br />

## Dependency Inversion Principle

> High level modules should not depend upon low level modules. Both should depend upon abstractions.
>
> Abstractions should not depend upon details. Details should depend upon abstractions.

<p></p>

- 고수준 모듈은 저수준 모듈에 의존해서는 안되며, 둘 모두 추상화에 의존해야 한다. 또한 추상화에 의존하며, 구체화에 읜존하면 안된다는 원칙이다.
- 구현 클래스에 의존하지 않고 상위 요소(추상 클래스나 인터페이스)에 의존하라는 뜻이다.

<br />
<br />
<br />

[출처: 김영한, 「스프링 핵심 원리 - 기본편」, 인프런](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8)

[출처: 「객체지향 개발 5대 원리: SOLID」, 넥스트리소프트](https://www.nextree.co.kr/p6960/)

<br />
