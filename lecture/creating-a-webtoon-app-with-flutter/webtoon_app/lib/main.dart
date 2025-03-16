import 'package:flutter/material.dart';
import 'package:webtoon_app/screens/home_screen.dart';
import 'package:webtoon_app/services/ApiService.dart';

void main() {
  Apiservice().getTodaysToons();
  runApp(const App());
}

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: HomeScreen());
  }
}
