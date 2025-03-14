import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyWidgetState();
}

class _MyWidgetState extends State<MyApp> {
  List<int> numbers = [];

  void onClicked() {
    setState(() {
      numbers.add(numbers.length);
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: const Color(0xFFF4EDDB),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text('Click Count', style: TextStyle(fontSize: 30)),
              for (var n in numbers) Text('$n'),
              IconButton(
                iconSize: 40,
                onPressed: onClicked,
                icon: Icon(Icons.add_box_rounded),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
