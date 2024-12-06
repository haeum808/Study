// positional parameter vs named parameter

// 함수 선언
void setStart(String name, int age) { // positional parameter
  print('called set started $name, $age');
}

void setStart2({String name = '이준경', int age = 27}) { // named parameter
  print('called set started $name, $age');
}

void setStart3({required String name}) { // named parameter with required
  print('called set started $name');
}

void main() {
  setStart('이준경', 27); // 함수 호출
  setStart2(age: 50, name: '김영인');
  setStart2(age: 50);
  setStart3(name: '홍길동');
}
