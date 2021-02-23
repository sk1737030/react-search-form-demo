### lolchess.gg clone toy 프로젝트

> 평소에 가끔 TFT 온라인을하는데 평소 같이 lolchess.gg홈페이지를 켜놓고 게임을 하는편이다.
> 그러다보니 평소에 어떻게 LoL API를 땡겨 오는지 흥미도 있었고, 평소 사용하지 못한 기술 스택으로
> 공부겸 토이프로젝트를 할려고한다.



### 구현할 기능 목록
1. 사용자 통합 검색
2. 사용자 전적 확인
3. 사용자 전적 상세
z
### 할일
1. LoL Summoner Api Data 긁기 (Success)
2. 처음 조회한 사용자면 DB에 데이터 저장 (Success)
3. 조회한 사용자 MatchList 가져오기 (Success)
4. 가져온 MatchList 기준으로 Detail MatchList 부르기 (Success)
5. 처음 조회한 애들이면 DB에 저장 (Success)
6. 사용자 매치 정보 가져오기 (Success)
7. 사용자 기준 최근 매치 10개 가져오기 (Success)
8. 매치별 같이 매치한 사용자들가져오기 (Success)
9. DB에 없는 사용자면 메세지 큐에 담기 
10. 메세지 큐에 담고 consume 해서 디비에 값 넣기 
11. 전적 갱신시 데이터 최신화 기능


### 사용할 기술 스택
1. Vue
2. SpringBoot
3. ElasticSearch
4. Mariadb
5. Java11
6. Junit5
7. Mybatis
8. Spring Security
9. LogBack
10, RabbitMq

### CI/CD
Local -(Push)> Github -(Webhooks)> Jenkins -(jar,ssh)> Api Server(Spring Boot) Health Check

### 진행하면서 목표
1. Java Code Cenvention을 최대한 지키면서 참고 https://kkangeva.tistory.com/39
2. 중요로직 TestCase작성하기 

### 계기
박재성님의 목적의식 있는 연습을 통한 효과적인 학습을 읽고...https://brunch.co.kr/@javajigi/8 


요즘들어 기초 (O/S,DB, 네트워크 등등)가 많이 모자라는게 느껴져서 잠시 멈췄습니다.  
예를들어 근무 중에 일어난 일들 중 여러가지가 있지만
1.리눅스는 왜 메모리를 거의 다 잡아놓고있나?
2.os에서 스왑 메모리가 높으면 어떤게 문제일 수 있나?
3.Docker로 nginx를 실행하면 왜 nginx컨테이너에서는 pid가 1이 nginx로 물릴까? 
4.Slow쿼리들의 개선을 위한 explain 확인, 인덱스 설정, 올바른 쿼리 작성
5.어떻게 www.naver.com을 검색했을 때 찾아가나..
등등

이런 질문들이 발생하여 cs공부의 필요함을 느꼈습니다.
