import 'package:flutter/material.dart';

// 메인 화면
class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('메인화면'),
      ),
      body: Column(
        children: [
          TextButton(
            onPressed: () {
              // 서브 화면으로 이동 (생성하면서 이동!)
              // Navigator.pushNamed(context, '/sub');

              // 서브 화면으로 이동 (내 화면을 활용해서 교체하여 이동)
              Navigator.pushReplacementNamed(context, '/sub', arguments: 'hello');
            },
            child: Text('클릭하여 서브 화면으로 이동'),
          ),
        ],
      ),
    );
  }
}
