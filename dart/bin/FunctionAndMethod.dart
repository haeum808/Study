// 함수 (Function) - 코드의 논리를 분리하고 재 사용성을 높이는 데 사용된다.
// 함수 이름, 매개 변수 (parameter) 반환 유형 (return type) 으로 구성.
void main() { // void 리턴타입일 경우 아무런 값을 반환하지 않고 오로지 실행한다.
  // 프로그램의 출발지인 main 함수
  print(add(5, 3)); // 함수 호출
  setStart();
}

int add(int a, int b) {
  return a + b; // 두 정수 값을 매개변수로 전달받은 것을 더한다음에 반환(return) 하는 함수
}

void setStart() {
  print('시작 합니다');
}

// 메서드 (Method) - 클래스 내부에서 정의된 함수
class UserInfo {
  String name = '이준경';
  int age = 27;
  String hobby = 'climbing';

  void setStart() {

  }
}
