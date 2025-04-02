
## 프로젝트 소개
사용자들의 일정을 관리해주는 애플리케이션입니다. 
사용자들의 일정을 생성하고 생성된 일정을 저장하고 저장된 일정을 조회 및 수정 원하지 않는 일정을 삭제하는 앱을 제작해보았습니다.

## 개발 기간
- 2025.03.27(목) ~ 2025.04.04(금) (9일)
- Spring 숙련 강의 수강
- Readme 작성
- ERD 작성
- API 명세서 작성
- 개발 시작

## 개발자 소개
- **정한길** : Spring 6기 학생, 11조

## 개발환경
- **Version** : Java 17
- **IDE** : IntelliJ
- **Framework** : SpringBoot 3.4.4


## 기술 스택
- **DataBase** : JPA, MySQL

## 프로젝트 아키텍쳐

## 주요 기능
1. 일정 CRUD
- 일정 생성
    - `작성 유저명`, `할일 제목`, `할일 내용`, `작성일`, `수정일` 생성
    - 데이터 베이스에 저장
- 일정 조회
    - 전체 일정 조회
    - 선택 일정 조회 : Id를 통해 원하는 일정 조회
- 일정 수정
    - 선택한 일정 수정 : Id를 통해 원하는 일정 조회 후 조회된 일정 정보를 수정
- 일정 삭제
    - 선택한 일정 삭제 : Id를 통해 원하는 일정 정보를 삭제

2. 유저 CRUD
- 유저 생성
  - `유저명`, `이메일`, `작성일`, `수정일` 생성
  - 데이터 베이스에 저장
- 유저 조회
  - 선택 유저 조회 : Id를 통해 원하는 유저 정보 조회
- 유저 수정
  - 선택한 유저 수정 : Id를 통해 원하는 유저 조회 후 조회된 유저 정보(`비밀번호`)를 수정
- 유저 삭제
  - 선택한 유저 삭제 : Id를 통해 원하는 유저 정보를 삭제

3. 회원가입
- 유저에 `비밀번호`필드 추가

4. 로그인
- Cookie/Session을 활용해 로그인 기능을 구현
  - 필터를 활용해 인증 처리
- 이메일과 비밀번호를 활용해 로그인 기능을 구현
- 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환

## ERD
![schedule-develop_ERD](https://github.com/HanGil-Jeong/schedule-develop/blob/main/schedule-develop_ERD.png?raw=true)

## ✒️ API 명세서
- Schedule

| 기능       | method   | URL | requset                                                                                                                                                                                                   | response | 상태 코드      |
|----------|----------|--|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|------------|
| 일정 생성    | `POST`   | localhost:8080/schedules | 요청 body <br/>{ <br/>"writerUsername" : "작성자 이름", <br/>"scheduleTtile" : "할일 제목", <br/>"scheduleContents" : "할일 내용", <br/>"createdAt" : YYYY-MM-DD HH:MM:SS, <br/>"modifiedAt" : YYYY-MM-DD HH:MM:SS<br/>} | 등록 정보    | 201 : 정상등록 |
| 전체 일정 조회 | `GET`    | localhost:8080/schedules | 요청 param                                                                                                                                                                                                  | 전체 일정 정보 | 200 : 정상조회 | 
| 선택 일정 조회 | `GET`    | localhost:8080/schedules/{Id} | 요청 param                                                                                                                                                                                                  | 선택 일정 정보 | 200 : 정상조회 |
| 선택 일정 수정 | `PATCH`  | localhost:8080/schedules/{Id} | 요청 body                                                                                                                                                                                                   | 수정 정보    | 200 : 정상수정 |
| 선택 일정 삭제 | `DELETE` | localhost:8080/schedules/{Id} | 요청 param                                                                                                                                                                                                  | -        | 200 : 정상삭제 |

- User

| 기능       | method   | URL                           | requset                                                                                                                                                                           | response | 상태 코드      |
|----------|----------|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------|------------|
| 유저 생성    | `POST`   | localhost:8080/users          | 요청 body <br/>{ <br/>"username" : "유저이름", <br/>"email" : "유저 이메일", <br/>"password" : "비밀번호", <br/>"createdAt" : YYYY-MM-DD HH:MM:SS, <br/>"modifiedAt" : YYYY-MM-DD HH:MM:SS<br/>} | 등록 정보    | 200 : 정상등록 |
| 선택 유저 조회 | `GET`    | localhost:8080/users/{Id} | 요청 param                                                                                                                                                                          | 선택 일정 정보 | 200 : 정상조회 |
| 선택 유저 수정 | `PATCH`  | localhost:8080/users/{Id} | 요청 body                                                                                                                                                                           | 수정 정보    | 200 : 정상수정 |
| 선택 유저 삭제 | `DELETE` | localhost:8080/users/{Id} | 요청 param                                                                                                                                                                          | -        | 200 : 정상삭제 |