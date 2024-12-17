import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:intl/intl.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  List<dynamic> lstNewsInfo = [];

  @override
  void initState() {
    super.initState();

    getNewsInfo();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xff424242),
        title: Text(
          '📰HeadLine News',
          style: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.bold,
            color: Colors.white,
          ),
        ),
      ),
      body: ListView.builder(
          itemCount: lstNewsInfo.length,
          itemBuilder: (context, index) {
            var newsItem = lstNewsInfo[index];
            return GestureDetector(
              child: Container(
                margin: EdgeInsets.all(16),
                child: Stack(
                  alignment: Alignment.bottomCenter,
                  children: [
                    // 이미지
                    Container(
                        width: double.infinity,
                        height: 170,
                        child: newsItem['urlToImage'] != null
                            ? ClipRRect(
                                borderRadius: BorderRadius.circular(10),
                                child: Image.network(
                                  newsItem['urlToImage'],
                                  fit: BoxFit.cover,
                                ))
                            : ClipRRect(
                                borderRadius: BorderRadius.circular(10),
                                child: Image.asset('assets/noimage.png'),
                              )),
                    // 반투명 검정 UI
                    Container(
                      width: double.infinity,
                      height: 57,
                      decoration: ShapeDecoration(
                          color: Colors.black.withOpacity(0.7),
                          shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.only(
                            bottomLeft: Radius.circular(10),
                            bottomRight: Radius.circular(10),
                          ))),
                      child: Container(
                        margin: EdgeInsets.all(8),
                        child: Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              newsItem['title'],
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 14,
                                  fontWeight: FontWeight.bold),
                              maxLines: 1,
                              overflow: TextOverflow.ellipsis,
                            ),
                            SizedBox(
                              height: 6,
                            ),
                            Align(
                              child: Text(
                                formatDate(newsItem['publishedAt']),
                                style: TextStyle(
                                    color: Colors.white, fontSize: 10),
                              ),
                              alignment: Alignment.bottomRight,
                            )
                          ],
                        ),
                      ),
                    )

                    // 하얀색 뉴스 제목, 일자 텍스트
                  ],
                ),
              ),
              onTap: () {
                Navigator.pushNamed(context, '/detail', arguments: newsItem);
              },
            );
          }),
    );
  }

  String formatDate(String dateString) {
    final dateTime = DateTime.parse(dateString);
    final formatter = DateFormat('yyyy.MM.dd HH:mm');
    return formatter.format(dateTime);
  }

  Future getNewsInfo() async {
    const apiKey = 'a4a6a4da08ed416e9ed3cb19c2834050';
    const apiUrl =
        'https://newsapi.org/v2/top-headlines?country=us&apiKey=$apiKey';

    try {
      final response = await http.get(Uri.parse(apiUrl));
      if (response.statusCode == 200) {
        final Map<String, dynamic> responseData = json.decode(response.body);

        setState(() {
          lstNewsInfo = responseData['articles'];
        });
      } else {
        throw Exception('Failed to load news');
      }
    } catch (error) {
      print(error);
    }
  }
}
