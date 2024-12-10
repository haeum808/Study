import 'package:flutter/material.dart';

// 서브 화면
class SubScreen extends StatelessWidget {
  String msg;

  SubScreen({super.key, required this.msg});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('서브 화면'),
      ),
      body: Column(
        children: [
          Center(
            child: Text('서브화면 입니다. $msg'),
          ),
          TextButton(
              onPressed: () {
                // 현재 화면 스택 제거
                Navigator.pop(context);
              },
              child: Text('뒤로가기'))
        ],
      ),
    );
  }
}
