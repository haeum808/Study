void main() {
  // Basic Data Types
  String name = 'haeum';
  bool alive = true;
  int age = 12;
  double money = 69.99;
  num x = 12;
  x = 1.1;

  // Lists
  var giveMeFive = true;
  var numbers = [1, 2, 3, 4, if (giveMeFive) 5];
  List<int> numbers2 = [1, 2, 3, 4];

  print(numbers);

  // String Interpolation
  var name2 = 'haeum';
  var age2 = 10;
  var greeting = "Hello everyone, my name is $name2 and I'm ${age2 + 2}";
  print(greeting);

  // Collection For
  var oldFriends = ['haeum', 'haeum2'];
  var newFriends = [
    'haeum3',
    'haeum4',
    'haeum5',
    for (var friend in oldFriends) "Best $friend",
  ];
  print(newFriends);
}
