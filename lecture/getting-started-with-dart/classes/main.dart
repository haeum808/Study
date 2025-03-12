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

void main() {
  // Your First Data Class
  var player = Player();
  player.sayHello();

  // Constructors
  var player2 = Player2('haeum', 1500);
  player2.sayHello();

  var player3 = Player3('haeum', 1500);
  player3.sayHello();
}
