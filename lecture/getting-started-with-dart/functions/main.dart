void main() {
  // Defining a Function
  sayHello('haeum');

  // Named Parameters
  sayHello2(); // default value
  sayHello3(age: 19, country: 'cuba', name: 'haeum'); // required
}

// Defining a Function
String sayHello(String name) {
  return "Hello $name nice to meet you!";
}

num plus(num a, num b) => a + b; // fat arrow syntax

// Named Parameters
String sayHello2({
  String name = 'anon',
  int age = 99,
  String country = 'wakanda',
}) {
  return "Hello $name, you are $age, and you come from $country";
}

String sayHello3({
  required String name,
  required int age,
  required String country,
}) {
  return "Hello $name, you are $age, and you come from $country";
}
