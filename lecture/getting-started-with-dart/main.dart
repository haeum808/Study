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
}
