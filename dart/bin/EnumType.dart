// enum type
// enum (열거형) - 타입 정의 보통 많이 사용 !, 상수들의 그룹을 정의할 때 유용하다.
// 왜 필요 ? -> 협업하는 개발자들 간에 코드를 더 읽기 쉽고 이해하기 쉽게 만들어 줄 수 있기 때문에
enum Color {
  red,
  green,
  blue,
  yellow,
}

void main() {
  // enum 값을 변수에 할당
  Color myColor = Color.blue;

  // 조건문으로 enum 값을 비교
  if (myColor == Color.red) {
    print('빨간색');
  } else if (myColor == Color.blue) {
    print('파란색');
  } else if (myColor == Color.green) {
    print('초록색');
  } else if (myColor == Color.yellow) {
    print('노란색');
  }

  print(Color.red.index);
  for (int i = 0; i < Color.values.length; i++) {
    print(Color.values[i]);
  }
}
