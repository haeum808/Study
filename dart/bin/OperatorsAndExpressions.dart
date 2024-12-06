void main() {
  // 1. 산술 연산자
  int a = 10;
  int b = 3;

  // 덧셈
  int sum = a + b;
  print(sum);
  // 뺄셈
  int minus = a - b;
  print(minus);
  // 곱셉
  int product = a * b;
  print(product);

  // 나눗셈
  double divided = a / b;
  print(divided);

  // 나머지
  int remain = a % b;
  print(remain);

  // 몫
  int mok = a ~/ b;
  print(mok);

  // 2. 비교 연산자
  bool isResult = (a == b);
  print(isResult);

  bool isResult2 = (a > b);
  print(isResult2);

  // 3. 논리 연산자
  bool result1 = (true || false); // 논리 합 (OR)
  print(result1);

  bool result2 = (false && false); // 논리 곱 (AND)
  print(result2);

  bool result3 = !result2; // 논리 부정 (NOT)
  print(result3);

  // 4. 할당 연산자
  double c = 10;
  c += 30; // 더하고 할당
  print(c);

  c -= 10; // 빼고 할당
  c *= 10; // 곱하고 할당
  c /= 10; // 나누고 할당

  // 5. 조건 연산자
  int age = 30;
  String ageStatus = age >= 18 ? "성인" : "미성년자"; // 3항 연산자
  print(ageStatus);
}
