import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  // 자기소개 값을 입력받는 컨트롤러
  TextEditingController introduceController = TextEditingController();

  // 자기소개 수정 모드 상태
  bool isEditMode = false;

  @override
  void initState() {
    super.initState();
    // 위젯이 처음 실행되었을 때 이곳을 호출한다.
    getIntroduceData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        leading: Icon(
          Icons.accessibility_new,
          color: Colors.black,
          size: 32,
        ),
        backgroundColor: Colors.white,
        elevation: 0,
        title: Text(
          '발전하는 개발자 이준경을 소개합니다',
          style: TextStyle(
            fontSize: 14,
            color: Colors.black,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
      body: SingleChildScrollView(
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Container(
              margin: EdgeInsets.all(16),
              width: double.infinity,
              height: 160,
              child: ClipRRect(
                  borderRadius: BorderRadius.circular(10),
                  child: Image.asset(
                    'assets/img_me.png',
                    fit: BoxFit.cover,
                  )),
            ),
            // 이름 섹션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      '이름',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    '이준경',
                  ),
                ],
              ),
            ),
            // 나이 섹션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      '나이',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    '27',
                  ),
                ],
              ),
            ),
            // 취미 섹션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      '취미',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    '클라이밍',
                  ),
                ],
              ),
            ),
            // 직업 세션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      '직업',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    '프로그래머',
                  ),
                ],
              ),
            ),
            // 학력 세션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      '학력',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    '명지대학교 졸업',
                  ),
                ],
              ),
            ),
            // MBTI 섹션
            Container(
              margin: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
              child: Row(
                children: [
                  Container(
                    width: 150,
                    child: Text(
                      'MBTI',
                      style: TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ),
                  Text(
                    'ISTP',
                  ),
                ],
              ),
            ),
            // 자기소개 입력필드
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Container(
                  margin: EdgeInsets.only(left: 16, top: 16),
                  child: Text(
                    '자기소개',
                    style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                  ),
                ),
                GestureDetector(
                  child: Container(
                    margin: EdgeInsets.only(right: 16, top: 16),
                    child: Icon(
                      Icons.mode_edit,
                      color:
                          isEditMode == true ? Colors.blueAccent : Colors.black,
                      size: 24,
                    ),
                  ),
                  onTap: () async {
                    if (isEditMode == false) {
                      setState(() {
                        // update widget
                        isEditMode = true;
                      });
                    } else {
                      if (introduceController.text.isEmpty) {
                        // snackbar 메시지를 사용자에게 안내하기
                        var snackBar = SnackBar(content: Text('자기소개 입력 값이 비어있습니다.'),
                        duration: Duration(seconds: 2),
                        );
                        ScaffoldMessenger.of(context).showSnackBar(snackBar);
                        return; // 하단의 로직들을 수행하지 않고, 여기서 메서드 종료
                      }

                      // 저장 로직 구현 !
                      var sharedPref = await SharedPreferences.getInstance();
                      sharedPref.setString('introduce', introduceController.text);

                      setState(() {
                        // update widget
                        isEditMode = false;
                      });
                    }
                  },
                ),
              ],
            ),
            Container(
              margin: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
              child: TextField(
                maxLines: 5,
                controller: introduceController,
                enabled: isEditMode,
                decoration: InputDecoration(
                    border: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(10),
                        borderSide: BorderSide(
                          color: Color(0xffd9d9d9),
                        ))),
              ),
            ),
          ],
        ),
      ),
    );
  }

  Future<void> getIntroduceData() async {
    // 기존에 저장된 자기소개 데이터가 있다면 로드해오기 !
    var sharedPref = await SharedPreferences.getInstance();
    String introduceMsg = sharedPref.getString('introduce') ?? "";
    introduceController.text = introduceMsg ?? "";
  }
}
