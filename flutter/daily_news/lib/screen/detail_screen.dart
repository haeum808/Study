import 'package:flutter/material.dart';

class DetailScreen extends StatelessWidget {
  dynamic newsItem;

  DetailScreen({super.key, required this.newsItem});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: TextButton(
          child: Text(
            '뒤로가기',
            style: TextStyle(
                color: Colors.black, fontSize: 24, fontWeight: FontWeight.bold),
          ),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        automaticallyImplyLeading: false,
        backgroundColor: Colors.white,
      ),
      body: SingleChildScrollView(
        child: Container(
          margin: EdgeInsets.all(16),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              // 이미지
              Container(
                  width: double.infinity,
                  height: 245,
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
              // 제목
              Container(
                margin: EdgeInsets.only(top: 32),
                child: Text(
                  newsItem['title'],
                  style: TextStyle(fontSize: 16, fontWeight: FontWeight.bold),
                ),
              ),
              Align(
                child: // 일시
                    Text(
                  newsItem['publishedAt'],
                  style: TextStyle(fontSize: 12),
                ),
                alignment: Alignment.centerRight,
              ),

              SizedBox(height: 32,),
              // 설명
              newsItem['description'] != null
                  ? Text(newsItem['description'])
                  : Text('내용 없음')
            ],
          ),
        ),
      ),
    );
  }
}
