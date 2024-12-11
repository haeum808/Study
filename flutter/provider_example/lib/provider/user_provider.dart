import 'package:flutter/cupertino.dart';

class UserProvider extends ChangeNotifier {
  String _name = "이준경";
  int _age = 27;

  String get name => _name;
  int get age => _age;

  void updateName(String newName) {
    _name = newName;
    notifyListeners();
  }

  void updateAge(int newAge) {
    _age = newAge;
    notifyListeners();
  }
}