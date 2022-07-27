
# My JSP Board
 
- JAVA는 17, Tomcat은 v9.0을 이용했고, Dynamic web module은 v2.5를 사용했습니다.
- JSP와 Servlet을 학습하면서 만든 게시판입니다.
- [프로젝트 회고록](https://ddungi.github.io/project/2022/05/26/boardproject/)
- DB는 H2를 사용했습니다. 
> - JDBC Util을 이용해 H2 DB와 연결하였습니다. 
> - BoardDAO, UserDAO(Data Access Object)를 통해 데이터를 요청하고 응답하게 하였습니다.
- JSP로 요청값을 받아 DispatcherServlet을 통해 로직을 수행하고 반환하는 MVC 모델을 적용하였습니다. 
- JSP 내부에 EL(Expression Language) ,JSTL(JavaServer Pages Standard Tag Library)을 이용하였습니다.
- BoardVO, UserVO에는 lombok을 이용하여 코드를 간결하게 줄였습니다.
- Filter에 인코딩을 UTF-8로 이용해서 요청 처리의 한글이 깨지지 않게 했습니다. 

<br>

![main](https://user-images.githubusercontent.com/88040158/170431118-44bca109-ae93-4669-b34a-7b0c1682401d.png)

- 게시판 Main 화면입니다.
- 로그인을 해야 게시판에 들어갈 수 있습니다.
- DispatcherServlet(*.do)으로 우회해서 들어오는 것을 막았습니다.
- JSP 지시자 태그의 include를 이용해  header, footer를 매 화면마다 넣어주었습니다.

<br>

![signin](https://user-images.githubusercontent.com/88040158/170431542-ec2c8f92-80f1-4768-a2d3-54bdea5c4c7f.png)

- 회원가입 화면입니다.
- 아이디, 비밀번호, 이름, 권한 (관리자만 글 삭제 가능)을 택할 수 있습니다.

<br>

![login](https://user-images.githubusercontent.com/88040158/170431889-452f5d06-2da0-4f22-b86c-43c92b40ea0b.png)

![loginmain](https://user-images.githubusercontent.com/88040158/170431817-adb9541d-b9be-4ea4-828d-a6285ef6badd.png)

- 로그인하면 글 목록과 글 등록으로 이동이 가능해집니다.

<br>

![insertboard](https://user-images.githubusercontent.com/88040158/170432033-53e1832a-7a15-4f09-87d7-43eeb5956da8.png)

- 글 등록을 하면 제목과 내용을 입력하여 DB에 전달됩니다.

<br>

![boardlist](https://user-images.githubusercontent.com/88040158/170432183-54d6dd36-2312-4016-8070-9fa05eba33a8.png)

- 글 목록에 가면 올렸던 글 목록을 확인할 수 있습니다.
- 글을 클릭하면 조회수가 1씩 올라가게 만들었습니다.

<br>

![myboard](https://user-images.githubusercontent.com/88040158/170432437-376d409c-6caf-4a97-b7a4-25a7d8ac4577.png)

- 일반 회원이 본 자신의 글은 수정만 가능합니다.

![otherboard](https://user-images.githubusercontent.com/88040158/170432617-4dbbd5a2-8792-4747-a3b7-7ad14d176670.png)

- 일반 회원이 본 다른 회원의 글은 조회만 가능합니다.



![adminboard](https://user-images.githubusercontent.com/88040158/170432535-834ec35e-c8b7-4bb8-8431-2f65d827019e.png)

- 관리자가 본 다른 회원의 글은 글 수정은 불가하지만 글 삭제가 가능합니다.

![adminboard2](https://user-images.githubusercontent.com/88040158/170434629-2fe0f318-f6d3-4de6-9a78-16748ce332c6.png)

- 관리자가 본 자신의 글은 글 수정과 글 삭제가 모두 가능합니다.

<br>

![search1](https://user-images.githubusercontent.com/88040158/170435398-83a8298a-b18f-4b3b-adb8-9de0822021e0.png)


![search2](https://user-images.githubusercontent.com/88040158/170435407-f59db389-ec02-4161-83e8-afcc85b0ace6.png)

- 검색 기능은 제목과 내용에 포함된 문자열을 검색할 수 있습니다.
- 검색한 글을 조회하고 글 목록을 클릭하면 검색했던 글의 검색 목록을 유지하며 화면으로 돌아가게 구현했습니다. (조회수만 상승)

<br>

- 세션을 이용해 브라우저가 끊기거나, 로그아웃 버튼을 클릭하기 전까지 로그인 기록을 유지하게 했습니다. 


