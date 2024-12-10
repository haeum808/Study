import 'package:flutter/material.dart';

// 시작 화면 (Splash Screen)
class SplashScreen extends StatelessWidget {
  const SplashScreen({super.key});

  @override
  Widget build(BuildContext context) {
    // 자동 정렬 -> command + option + L
    Future.delayed(
      const Duration(seconds: 2),
      () {
        // 화면 이동 (splash -> main)
        Navigator.pushNamed(context, '/main');
      },
    );

    return const Scaffold(
      body: Center(
        child: Text('시작 화면 입니다'),
      ),
    );
  }
}
