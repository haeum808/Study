void main() {
  // Defining a Function
  sayHello('haeum');

  // Named Parameters
  sayHello2(); // default value
  sayHello3(age: 19, country: 'cuba', name: 'haeum'); // required

  // Optional Positional Parameter
  var results = sayHello4('haeum', 12);
  print(results);

  // QQ Operator
  capitalizeName3('haeum');
  capitalizeName3(null);

  String? name;
  name ??= 'haeum';
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

// Optional Positional Parameters
String sayHello4(String name, int age, [String? country = 'cuba']) =>
    'Hello $name, you are $age years old from $country';

// QQ Operator
String capitalizeName1(String? name) {
  if (name != null) {
    return name.toUpperCase();
  }
  return 'ANON';
}

String capitalizeName2(String? name) =>
    name != null ? name.toUpperCase() : 'ANON';

String capitalizeName3(String? name) => name?.toUpperCase() ?? "";
