// Null Safety (널 안정성) -> 변수가 널이 될 수 있는지 여부를 명시적으로 지정할 수 있다. -> 개발자의 실수 방지, 코드 안정성 향상
void main() {
  String name = 'joonkyung'; // not null
  String? name2 = null; // null (값이 비어있다)
  print(name2?.length);
  name2 = "joonkyung";
  print(name.length);

  // 널 합류 연산자 (??)
  String? name3 = null;
  String result = name3 ?? 'joonkyung';
  print(result);
}
