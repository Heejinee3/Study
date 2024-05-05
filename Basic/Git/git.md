<br />

## Start (Local repo를 만들고 Remote repo에 Add 하기)

    git init                                              // .git 파일 생성

    git config --global user.email "test@naver.com"       // user email 등록
    git config --global user.name "HongGildong"           // user name 등록
    git config --global core.editor "code --wait"         // 기본 에디터를 visual studio code로 등록

    git remote add origin https://github.com/.../test.git // remote repository(origin) 등록
    git remote -v                                         // remote repository 확인
    git push -u origin master                             // remote repository(origin)에 local branch(master) 올리기


<br />

## Start (Remote repo를 생성하고 Local에 Clone 하기)

    git clone https://github.com/.../test.git . // remote repository를 local로 받아옴, 하위 폴더를 생성하고 싶으면 .대신 폴더명을 입력하거나 생략

<br />

## Status (상태 보기)

    git status    // 상태를 보여줌
    git status -s // 요약

    /* untracked (not staged)        : stage에 없는 파일 
       staged                        : stage에 있지만 commit이 되기 전 상태 
       modified/deleted (not staged) : 과거에 commit을 했지만 수정이 되어 다시 stage에 올려야하는 상태
       unmodified (commit)           : stage에 있고 commit이 된 상태                                */
    
<br />

##  Config (환경 설정하기)

    git config --<global|local|system> <option>         // 전역/지역/시스템 옵션 보기
    git config --<global|local|system> <option> <value> // 전역/지역/시스템 옵션 설정
    git config --<global|local|system> --unset <option> // 전역/지역/시스템 옵션 삭제
    git config --list                                   // 모든 옵션 보기

<br />

## Status Change (Status 이동하기)

    git restore <file1> <file2> ... // stage에 올라와 있지 않은 파일 그전 상태로 되돌리기
    git restore .                   // stage에 올라와 있지 않은 모든 파일 그전 상태로 되돌리기

    git add <file1> <file2> ...     // stage에 file 올리기
    git add .                       // 모든 파일 stage에 올리기

    git reset <file1> <file2> ...   // file을 stage에서 내리기
    git reset .                     // 모든 파일 stage에서 내리기

    git commit -a                   // add 명령을 생략하고 commit하기 (untracked 파일은 커밋되지 않음)
    git commit -m <explanation>     // 설명과 함께 commit 하기
    git commit                      // stage에 있는 파일 commit 하기, 에디터가 열리면서 제목과 설명 입력 가능 (첫째줄에 제목, 3번째 줄에 설명)

<br />

## Fetch (Remote repo를 Local repo에 update)

    git fetch <remoteName> // 원격 저장소의 상태를 로컬에 업데이트 하기

<br />

## Push (Local repo를 Remote repo에 반영하기)

    git remote add <remoteName> <remoteUrl> // 원격 저장소 지정
    git remote -v                           // 원격 저장소 확인

    git push <remoteName> <localBranch>     // 원격 저장소에 local branch 올리기 
    git push -u <remoteName> <localBranch>  // local branch에 원격 저장소의 branch를 연결하면서 올리기
    git push                                // local branch가 원격 저장소에 연결되어있다면 git push만 입력해도 됨

<br />

## Pull (Remote repo를 Local repo에 반영하기)
  
    git clone <remoteUrl>               // 원격 저장소 이름의 폴더가 생성하면서 소스 다운받기
    git clone <remoteUrl> .             // 현재 폴더에 소스 다운받기
    git clone <remoteUrl> <folder>      // folder를 생성하면서 소스 다운받기

    git pull <remoteName> <localBranch> // 원격 저장소의 새로운 커밋들을 로컬로 받기
    git pull                            // local branch가 원격 저장소에 연결되어있다면 git pull만 입력해도 됨

<br />

## Branch (Branch 생성/삭제/이동)

    git branch                                // 로걸 저장소의 브랜치 보기
    git branch -v                             // 마지막 커밋과 함께 표시
    git branch <branch>                       // HEAD로부터 브랜치 만들기 
    git branch -f <branch> <checksum>         // 이미 있는 브랜치 옮기기
    git branch <branch> <checksum>            // checksum에 위치한 브랜치 만들기
    git branch -r                             // 원격 저장소의 브랜치 보기

    git branch -d <branch>                    // 브랜치 지우기 (HEAD와 병함되지 않은 브랜치는 삭제 불가능)
    git branch -D <branch>                    // 브랜치 지우기 (-d로 지우지 못한 브랜치까지 가능)
    
    git checkout <branch>                     // 해당 브랜치로 HEAD 옮기기
    git checkout -b <branch> <checksum>       // checksum(or branch)에 위치한 브랜치를 만들고 checkout 하기

    /* checkout = switch(branch 전환) + restore(작업 디렉토리의 파일 내용 복구) */

<br />

## Reset (Branch를 특정 커밋으로 이동, 사용 주의)

    git reset --hard <checksum>  // 현재 브랜치를 지정 커밋으로 이동(repository, stage, working directory)
    git reset --mixed <checksum> // 현재 브랜치를 지정 커밋으로 이동(repository, stage)
    git reset --soft <checksum>  // 현재 브랜치를 지정 커밋으로 이동(repository)

    /* HEAD~<number>: number번째 조상
       HEAD^<number>: number번째 부모(ex. 병합 커밋) */

<br />

## Revert (Branch를 특정 커밋 이전의 상태로 commit)

    git revert HEAD       // 현재 커밋의 이전 상태로 복구
    git revert <checksum> // 지정 커밋 이전 상태로 복구

<br />

## Merge (Branch 병합하기)

    git merge <branch> // 병합
    git status         // 충돌 파일 확인
    git merge --abort  // 병합 취소

    /* merge 중 conflict가 발생했을 경우
       파일에서 충돌을 해결하고, add로 stage에 올린 후 commit한다 */

<br />

## Rebase (공통 조상을 찾아 재배치하기)

    git rebase <branch> // 재배치
    git rebase --continue

    /* rebase 중 conflict가 발생했을 경우
       파일에서 충돌을 해결하고, add로 stage에 올린후 rebase continue를 한다
       이전 기록을 다시 고치므로 강제 푸시를 해야할 수도 있다
       git push <remoteName> <localBranch> --force */

<br />

## Tag (태그 붙이기)

    git tag -a -m <message> <tagName> <checksum> // tag 붙이기
    git push <remoteName> <tagName>              // 원격 저장소에 tag 반영하기

<br />

## Log (기록 살펴보기)

    git log			   // 이전 commit 보기
    git log -n<number> // 최신 n개의 커밋을 보여줌
    git log --oneline  // 한 줄로 요약
    git log --graph    // 그래프 흐름을 보여줌
    git log --decorate // 브랜치와 태그 등의 참조를 간결히 표시
    git log --all      // HEAD와 관계없는 옵션도 보여줌

<br />

## Help (도움말 보기)

    git help <command>

<br />

## 그외

- Amend: 마지막 커밋 수정하기
- Cherry-Pick: 과거 커밋을 하나 떼서 지금 브랜치에 붙이기
- Stash: 변경사항 다른 곳에 저장하기
- Fork: 다른 사람의 원격 저장소를 복사해서 내 원격 저장소를 만드는 것 (branch와 비슷)
- Pull Request(PR): 여러 개발자가 동시에 작업할 때, 각자의 로컬 환경에서 작업한 내용을 중앙 리포지토리에 통합하기 위해 pull 요청을 보내는 것 

<br />
<br />
<br />

[출처: 정호영, 진유림, 「팀 개발을 위한 Git, GitHub 시작하기」, 한빛미디어](https://m.hanbit.co.kr/store/books/book_view.html?p_code=B5159933380)

<br />

