// Future와 await를 활용한 비동기 프로그래밍

// Future (미래) - 비동기 작업의 결과 또는 완료 상태를 나타내는 객체
// 동기 vs 비동기
// 동기 - 작업이 순차적으로 실행
// 비동기 - 작업이 순차적으로 실행되지 않으며, 동시에 여러 작업을 처리할 수 있다.
void main() {
  playComputerGame();
}

Future<void> playComputerGame() async {
  startBoot(); // 1. 컴퓨터를 부팅한다.
  await startInternet(); // 2. 인터넷을 실행한다.
  startGame(); // 3. 게임을 실행한다.
}

void startBoot() {
  print('1. boot completed');
}

Future<void> startInternet() async {
  // sleep vs delay
  // await - 비동기 함수 내에서 사용되며, await 뒤에 나오는 결과 값이 완료될 때까지 실행을 일시적으로 중단시켜준다.
  await Future.delayed(Duration(seconds: 3), () {
    print('2. internet completed');
  });
  print('delay completed');
}

void startGame() {
  print('3. game completed');
}
