void main() {
  // 변수란 - 변할 수 있는 수 (값)
  String name = "이준경"; // 이준경이라는 문자열을 name이라는 변수에 값을 할당한다.

  name = '이준경2'; // 할당된 변수의 값을 변경
  print(name);

  int age = 27;
  print(age);

  var name2 = '김영인'; // dart에서 지원하는 문법, 변수 값에 대한 타입 추론을 하게된다.
  print(name2);

  var age2 = 30;
  print(age2);

  // bool - true나 false의 논리를 정의할 때 사용함.
  bool isChecked = false;
  print(isChecked);

  // double - 소수 점 값을 표현하는 단위
  double tall = 164.9;
  print(tall);
}
