// late 키워드
late String name; // null, 초기화가 되지않음.
String? name2;

void main() {
  name = '이준경'; // 늦은 초기화

  name2 = '김영인';
  name2 = null;
}
