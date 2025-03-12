// Your First Data Class
class Player {
  final String name = 'haeum';
  int xp = 1500;

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Constructors
class Player2 {
  late final String name;
  late int xp;

  Player2(String name, int xp) {
    this.name = name;
    this.xp = xp;
  }

  void sayHello() {
    print("Hi my name is $name");
  }
}

class Player3 {
  final String name;
  int xp;

  Player3(this.name, this.xp);

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Named Constructors Parameters
class Player4 {
  final String name;
  int xp, age;
  String team;

  Player4({
    required this.name,
    required this.xp,
    required this.team,
    required this.age,
  });

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Named Constructors
class Player5 {
  final String name;
  int xp, age;
  String team;

  Player5({
    required this.name,
    required this.xp,
    required this.team,
    required this.age,
  });

  Player5.createBluePlayer({required String name, required int age})
    : this.age = age,
      this.name = name,
      this.team = 'blue',
      this.xp = 0;

  Player5.createRedPlayer(String name, int age)
    : this.age = age,
      this.name = name,
      this.team = 'red',
      this.xp = 0;

  void sayHello() {
    print("Hi my name is $name");
  }
}

void main() {
  // Your First Data Class
  var player = Player();
  player.sayHello();

  // Constructors
  var player2 = Player2('haeum', 1500);
  player2.sayHello();

  var player3 = Player3('haeum', 1500);
  player3.sayHello();

  // Named Constructors Parameters
  var player4 = Player4(name: 'haeum', xp: 2500, team: 'blue', age: 21);
  player4.sayHello();

  // Named Constructors
  var bluePlayer = Player5.createBluePlayer(name: 'haeum', age: 21);
  var redPlayer = Player5.createRedPlayer('haeum', 23);
}
