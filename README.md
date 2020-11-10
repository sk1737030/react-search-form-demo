### lolchess.gg clone toy 프로젝트

> 평소에 가끔 TFT 온라인을하는데 평소 같이 lolchess.gg홈페이지를 켜놓고 게임을 하는편이다.
> 그러다보니 평소에 어떻게 LoL API를 땡겨 오는지 흥미도 있었고, 평소 사용하지 못한 기술 스택으로
> 공부겸 토이프로젝트를 만들어 볼려고 함.

### 구현할 기능 목록 
1. 사용자 통합 검색
2. 사용자 정보
3. ...

### 할일
1. Lol Api Data 긁어서 Maria에 집어넣기 scheduling으로 처리 예정 

###  기술 스택
1. React
2. SpringBoot
3. ElasticSearch
4. Mariadb
5. Java11
6. Junit4
7. Mybatis
8. Spring Security
9. LogBack

### CI/CD
Local  -(Push)> Github -(Webhooks)> Jenkins -(jar,ssh)> Api Server(Spring Boot) - Health 체크 할꺼임 -> Mariadb, Elasticsearch


### 목표
1. Java Code Cenvention을 최대한 지키면서 참고 https://kkangeva.tistory.com/39 
2. Tdd는 못해도 UnitTest


### 계기
박재성님의 목적의식 있는 연습을 통한 효과적인 학습을 읽고...https://brunch.co.kr/@javajigi/8 
