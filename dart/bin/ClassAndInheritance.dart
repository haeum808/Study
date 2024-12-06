// 클래스 (class) - 객체를 생성하기 위한 템플릿 또는 청사진 (blueprint), 설계도
class Person {
  // 상태 - 멤버 변수
  String name; // 이름
  int age; // 나이

  // 생성자 (Constructor)
  Person(this.name, this.age);

  // 행동 - 메서드 (함수)
  void sayHello() {
    print('안녕하세요 저는 $name이고, $age살 입니다.');
  }
}

// 상속 - 기존 클래스의 특성을 다른 클래스에서 재사용하고 확장하는 매커니즘
// 부모 클래스 (super class)와 자식 클래스 (sub class)간에 상속 관계가 형성됨
class Man extends Person {
  Man(String name, int age) : super(name, age);

  @override
  void sayHello() {
    super.sayHello(); // 부모 클래스의 정의되어있는 함수 호출
    print('\n제 성별은 남자 입니다.');
  }
}

class Woman extends Person {
  Woman(String name, int age) : super(name, age);

  @override
  void sayHello() {
    super.sayHello(); // 부모 클래스의 정의되어있는 함수 호출
    print('\n제 성별은 여자 입니다.');
  }
}

void main() {
  Person personJoon = Person('이준경', 27); // 클래스 인스턴스 생성
  Person personOinn = Person('김영인', 26); // 클래스 인스턴스 생성
  Person personIroha = Person('이로하', 16); // 클래스 인스턴스 생성

  personJoon.sayHello(); // 함수 내의 메서드 호출
  personOinn.sayHello(); // 함수 내으 메서드 호출

  var man = Man('이준경', 27);
  man.sayHello();
}
