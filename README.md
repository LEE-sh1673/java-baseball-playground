## 기능목록 정의

- [ ] 컴퓨터는 1~9까지 서로 구분되는 3자리 수를 생성한다.
- [ ] 사용자의 입력값(3자리)으로부터 컴퓨터의 숫자값(3자리)을 비교한다.
  - [ ] 같은 수가 같은 자리에 있다면 `STRIKE`를 반환
  - [ ] 같은 수가 다른 자리에 있다면 `BALL`을 반환
  - [ ] 같은 수가 전혀 없다면 `NOTHING`을 반환하도록 한다.
- [ ] 비교한 결과를 사용자에게 보여준다.

---

## 구현 아이디어

### 숫자값 비교 기능 

- 사용자와 컴퓨터가 갖는 3가지 수 집합을 도메인 객체로 지정 
  - e.g. `Balls`
- 이때 각 객체를 비교할 때 자릿수와 숫자값을 모두 비교해야 함. 
  - e.g. compare `ball1` with `ball2` using `(값, 자릿수)`.
- 따라서 내부적으로 3개의 숫자에 대해 컨테이너 형식으로 저장한다고 가정.
  - e.g. `Balls` has `List<Ball>`

```java
PlayResult result = Balls.play(com, player);
// or
PlayResult result = com.play(player);
```
- 비교 결과로 내부적으로 스트라이크/볼/낫싱의 발생 횟수를 가지고 있는 객체를 반환.
- 내부적으로 하나의 `Balls` 객체에서 `play()` 메서드 호출 시 컨테이너 간 비교를 수행해야 함.
```java
// in context of play()..
for (Ball ball of Player::Balls) {
	for (Ball other_ball of Com::Balls) {
		// compare ball with other ball..
    }
}
```
- 메서드의 간소화를 위해 다음을 고려. 
  1. `Ball` 객체와 `Ball` 객체에 대한 비교 연산을 수행해여 상태값을 반환하는 메서드 추출.
  2. `Balls` 객체와 `Ball` 객체를 비교 연산하여 가장 많이 발생한 상태값을 반환하는 메서드를 추출 

```java
// In play() of Balls
// e.g. call `player.play(com)`
PlayResult play(final Balls other) {
	PlayResult result;
	for (Ball ball of otherBalls.getBalls()) {
        PlayStatus = player::compareWith(ball);
        result.report(status);
	}
	return result;
}

PlayStatus compareWith(final Ball otherBall) {
    Collection<PlayStatus> totalPlayStatus;
    ...
	for (Ball ball of player::Balls) {
	    playStatus = ball.compare(otherBall);	
        totalPlayStatus.add(playStatus);
	}	
	return MAX_OF(totalPlayStatus);
}
```

정리하자면:

1. `Balls` 객체는 `Ball` 객체를 1:3의 관계로 가짐.
2. `Ball` 객체는 `(숫자값, 위치값)`을 가짐.
3. `Balls`와 `Balls`를 비교하는 메서드는 각 요소 간의 비교 결과를 저장하고 있는 하나의 객체를 반환한다.
4. 이때 다른 `Balls` 객체의 요소들을 순회하면서 아래의 과정을 수행해야 함. 
   5. `Balls`와 `Ball`을 비교하는 메서드 호출 
      6. `Ball`와 `Ball`을 비교하는 메서드 호출

### 입출력 예시:: `Ball` / `Ball` 비교

| com | user     | return    |
| --- |----------|-----------|
| `(1, 1)` | `(3, 5)` | `NOTHING` |
| `(1, 1)` | `(1, 4)` | `BALL`    |
| `(1, 1)` | `(1, 1)` | `STRIKE`  |


## 요구사항 정리

- 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 ****얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
  > e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱 
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.****
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다. 
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.