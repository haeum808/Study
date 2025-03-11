import 'dart:ffi';

void main() {
  // The Var Keyword
  var name = '해음'; // 주로 지역변수, 타입 추론
  name = '푸린';

  String name2 = '푸린'; // 주로 변수 프로퍼티
  name2 = '해음';

  // Dynamic Type
  var name3; // dynamic
  name3 = 'haeum';

  if (name3 is String) {
    name3.isEmpty;
  }

  name3 = 12;

  if (name3 is int) {
    name3.isOdd;
  }

  // Nullable Variables
  String? name4 = 'haeum';
  name4 = null;

  if (name4 != null) {
    name4.isNotEmpty;
  }

  name4?.isNotEmpty;

  // Final Variables
  var name5 = 'haeum'; // 변수
  String name6 = 'haeum'; // 변수
  final String name7 = ''; // 수정 불가능한 변수
  final name8 = ''; // 수정 불가능한 변수

  // Late Variables
  late var name9;
  late final String name10;
  // do something, go to api
  name9 = 'haeum';
  name9 = 'haeum2';
  name10 = 'haeum';

  // Constant Variables
  const name11 = 'haeum'; // compile-time constant
}
