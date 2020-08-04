
# YJ First Project
## 주제 : RESTful 기반의 자유게시판


프론트 : HTML, CSS, JAVA SCRIPT, BOOTSTRAP 4
         JQUERY, Ajax

백엔드 : JAVA EE(JSP, Servlet, JSTL)

빌드툴 : Maven

서버 인프라 구축(할 사람만) : AWS(아마존) Elastic Cloud Compute , Azure(마이크로소프트) Linux Virtual Marchine

공동 프로젝트 버젼관리 : Git , GitHub





1. 프로젝트 가져오기


     - git bash 설치 https://git-scm.com/book/ko/v2/%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0-Git-%EC%84%A4%EC%B9%98
     - git clone https://github.com/mokaim/YJ.git (clone 으로 가져온 프로젝트는 자신의 Local Repository 가 된다.)
     - 이클립스에서 import -> Existing Maven Project 클릭한 후 GitHub 원격 리파지토리에서 가져온 프로젝트 폴더를 클릭한 후 폴더열기 클릭
     - Next 누른 후 성공적으로 Import 시킴 
  
  
  
  
2. 자신의 Local Repository(아까 불러온 메이븐 프로젝트) 에서 원격 Repository로 Commit

     - git bash 를 이용하여 자신의 local repository 에 들어간다. ex) cd ......../YJ
     - git checkout -b "원하는 branch 이름"
     - git add * 로 프로젝트를 워킹트리에 추가한다.
     - git status 에서 상태확인 후
     - git commit -m "커밋 메시지"
     - git push origin "자신의 branch 이름" 으로 원격 Repository 에 커밋시킨다.






