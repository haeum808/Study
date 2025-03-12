// Your First Data Class
import '../functions/main.dart';

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

// Recap
class Player6 {
  final String name;
  int xp;
  String team;

  Player6.fromJson(Map<String, dynamic> playerJson)
    : name = playerJson['name'],
      xp = playerJson['xp'],
      team = playerJson['team'];

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Cascade Notation
class Player7 {
  String name;
  int xp;
  String team;

  Player7({required this.name, required this.xp, required this.team});

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Enums
enum Team { red, blue }

enum XPLevel { beginner, medium, pro }

class Player8 {
  String name;
  XPLevel xp;
  Team team;

  Player8({required this.name, required this.xp, required this.team});

  void sayHello() {
    print("Hi my name is $name");
  }
}

// Abstract Classes
abstract class Human {
  void walk();
}

class Player9 extends Human {
  String name;
  XPLevel xp;
  Team team;

  Player9({required this.name, required this.xp, required this.team});

  void sayHello() {
    print("Hi my name is $name");
  }

  void walk() {
    print('im walking');
  }
}

class Coach extends Human {
  void walk() {
    print('the coach is walking');
  }
}

// Inheritance
class Human2 {
  final String name;

  Human2({required this.name});

  void sayHello() {
    print("Hi my name is $name");
  }
}

enum Tema2 { red, blue }

class Player10 extends Human2 {
  final Tema2 team;

  Player10({required this.team, required String name}) : super(name: name);

  @override
  void sayHello() {
    super.sayHello();
    print('and I play for ${team}');
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

  // Recap
  var apiData = [
    {"name": "haeum1", "team": "red", "xp": 0},
    {"name": "haeum2", "team": "red", "xp": 0},
    {"name": "haeum3", "team": "red", "xp": 0},
  ];
  apiData.forEach((playerJson) {
    var player = Player6.fromJson(playerJson);
    player.sayHello();
  });

  // Cascade Notation
  var player7 = Player7(name: 'haeum', xp: 1200, team: 'red');
  var potato =
      player7
        ..name = 'las'
        ..xp = 1200000
        ..team = 'blue'
        ..sayHello();

  // Enums
  var player8 = Player8(name: 'haeum', xp: XPLevel.medium, team: Team.red);

  // Abstract Classes
  var coach = Coach();

  // Inheritance
  var player10 = Player10(team: Tema2.red, name: 'haeum');
  player10.sayHello();
}
