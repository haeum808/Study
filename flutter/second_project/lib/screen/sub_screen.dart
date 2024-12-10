import 'package:flutter/material.dart';

// 서브 화면
class SubScreen extends StatelessWidget {
  String msg;

  SubScreen({super.key, required this.msg});

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.black,
            elevation: 0,
            automaticallyImplyLeading: false,
            leading: TextButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text(
                  '뒤로가기',
                  style: TextStyle(color: Colors.blue),
                )),
            title: const Text('서브 화면'),
            actions: const [
              Icon(Icons.ac_unit_outlined),
            ],
            bottom: const TabBar(tabs: [
              Tab(
                text: 'Tab 1',
              ),
              Tab(
                text: 'Tab 2',
              ),
              Tab(
                text: 'Tab 3',
              ),
            ]),
          ),
          body: const TabBarView(children: [
            Center(
              child: Text('Tab 1 Content'),
            ),
            Center(
              child: Text('Tab 2 Content'),
            ),
            Center(
              child: Text('Tab 3 Content'),
            ),
          ])),
    );
  }
}
