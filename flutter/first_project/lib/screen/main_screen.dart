import 'package:flutter/material.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  List lstHello = ['이준경', '김영인', '이로하', '카리나'];
  TextEditingController idController = TextEditingController();
  String msg = '이 곳에 입력 값이 업데이트 됩니다!';
  ValueNotifier<int> counter = ValueNotifier<int>(0);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('메인화면'),
      ),
      // body: Column(
      //   children: [
      //     const Text('반갑습니다.'),
      //     const Text('저는 명지대학교 학생입니다.'),
      //     const Text('저는 이준경 입니다.'),
      //     const Row(
      //       mainAxisAlignment: MainAxisAlignment.center,
      //       // 가로로 위젯을 쌓아서 정렬하는 위젯
      //       children: [
      //         Text('안녕'),
      //         Text('반가워'),
      //         Text('오랜만이야'),
      //       ],
      //     ),
      //     const Row(
      //       children: [
      //         Expanded(flex: 2, child: Text('이준경')),
      //         Expanded(child: Text('이준경')),
      //         Expanded(child: Text('이준경')),
      //       ],
      //     ),
      //     Container(
      //       width: 300,
      //       height: 100,
      //       margin: const EdgeInsets.only(left: 16),
      //       alignment: Alignment.center,
      //       decoration: BoxDecoration(
      //           borderRadius: BorderRadius.circular(10), color: Colors.blue),
      //       child: const Text('이준경'),
      //     ),
      //     const SizedBox(
      //       width: 100,
      //       height: 50,
      //       child: Text('이준경2'),
      //     ),
      //     Container(
      //       margin: const EdgeInsets.all(4),
      //       width: 200,
      //       height: 70,
      //       child: ElevatedButton(
      //           onPressed: () {
      //             // 클릭 되었을때 동작하고 싶은 액션 정의
      //             print('버튼이 클릭되었습니다');
      //           },
      //           style: ElevatedButton.styleFrom(
      //               foregroundColor: Colors.yellow,
      //               backgroundColor: Colors.green,
      //               elevation: 0),
      //           child: const Text('눌러보세요!')),
      //     ),
      //     // image
      //     Row(
      //       children: [
      //         Image.asset(
      //           'assets/car.png',
      //           width: 100,
      //           height: 100,
      //         ),
      //         const Icon(
      //           Icons.home_filled,
      //           size: 100,
      //         )
      //       ],
      //     )
      //   ],
      // ),
      // body: ListView.builder(
      //   itemBuilder: (context, index) {
      //     return ListTile(
      //       title: Text('${lstHello[index]}'),
      //       subtitle: Text('서브타이틀'),
      //     );
      //   },
      //   itemCount: lstHello.length,
      // ),
      body: Column(
        children: [
          TextField(
            controller: idController,
            decoration: const InputDecoration(labelText: '아이디를 입력해주세요'),
          ),
          ElevatedButton(
              onPressed: () {
                // setState(() {
                //   // widget update
                //   msg = idController.text.toString();
                // });
                counter.value += 1;
              },
              child: const Text('아이디 입력 값 가져오기!')),
          ValueListenableBuilder(
            valueListenable: counter,
            builder: (context, value, child) {
              return Text('Count : $value');
            },
          ),
          Text(
            msg,
            style: const TextStyle(fontSize: 30),
          ),
        ],
      ),
    );
  }
}
