<br />

## ElasticSearch 설치 및 실행

1. ELKstack 폴더를 만든다.

2. 밑의 링크에서 엘라스틱서치를 다운로드 후 압축을 해제한다.

   https://www.elastic.co/kr/downloads/elasticsearch

3. elasticsearch 폴더를 ELKstack 폴더 밑으로 이동한다.

4. ELKstack/elasticsearch/config/elasticsearch.yml를 수정한다.

```yml
cluster.name: test-es
node.name: test-es-node01

path:
  data: ./data
  logs: ./logs

network.host: 127.0.0.1

discovery.type: "single-node"
xpack.security.enabled: false
```

5. ELKstack/elasticsearch/config/jvm.options를 수정한다.

```
## 주석 해제
-Xms4g
-Xmx4g
```

6. ELKstack/elasticsearch 경로에서 다음 명령어를 실행한다.

```cmd
bin\elasticsearch.bat
```

7. ctrl-C를 눌러 종료시키고, 다음 명령어를 실행한다.

```cmd
bin\elasticsearch-service.bat install
bin\elasticsearch-service.bat start
```

8. http://localhost:9200 에 접속한다.

9. 다음 명령어를 실행해, 종료한다.

```cmd
bin\elasticsearch-service.bat stop
```

10. 참고할 점

- 엘라스틱서치는 내장 JDK를 사용한다.
- 만약, 다른 버전의 JDK를 사용하려면 ES_JAVA_HOME 환경변수를 지정한다.
- 엘라스틱서치 버전이 7.12 미만이라면 JAVA_HOME 환경변수를 확인한다.
- 그래도 오류가 날경우 다음 명령어를 실행하여, 다시 실행해본다.

```cmd
bin\elasticsearch-service.bat remove
bin\elasticsearch-service.bat install
bin\elasticsearch-service.bat start
```

<br>

## Kibana 설치 및 실행

1. 밑의 링크에서 kibana를 다운로드 후 압축을 해제한다.

   이때, 압축 해제 시간이 오래 걸릴 수 있으므로 반디집이나 알집을 이용하여 압축 해제한다.

   https://www.elastic.co/kr/downloads/kibana

2. kibana 폴더를 ELKstack 폴더 밑으로 이동한다.

3. ELKstack/kibana/config/kibana.yml를 수정한다.

```yml
server.port: 5601
server.host: localhost
server.publicBaseUrl: "http://localhost:5601"
elasticsearch.hosts: ["http://localhost:9200"]
```

4. ELKstack/kibana 경로에서 다음 명령어를 실행한다.

```cmd
bin\kibana.bat
```

5. http://localhost:5601 에 접속한다.

   이때, 엘라스틱서치가 실행된 상태여야 한다.

6. 해당 페이지에서 try sample data 버튼을 통해 데이터를 넣을 수 있다.

<br>

## Cerebro 설치 및 실행

1. 밑의 링크에서 cerebro-0.9.4.zip를 다운로드 후 압축을 해제한다.

   https://github.com/lmenezes/cerebro/releases

2. cerebro 폴더를 ELKstack 폴더 밑으로 이동한다.

3. ELKstack/cerebro 경로에서 다음 명령어를 실행한다.

```cmd
bin\cerebro.bat
```

4. 만약 실행이 되지 않는다면, 다음과 같이 시스템 환경변수를 추가한다.

| 환경변수    | 값                                                                                                      |
| ----------- | ------------------------------------------------------------------------------------------------------- |
| bundled_jvm | [폴더 위치]\ELKstack\elasticsearch\jdk                                                                  |
| JAVA_OPTS   | --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/sun.net.www.protocol.file=ALL-UNNAMED |

5. 그런데도 실행이 되지 않는다면, cerebro를 다시 설치한다.

6. 실행이 성공한 뒤, http://localhost:9000 에 접속한다.

<br>

## .bat 파일 만들기

ELKstack/command.bat 파일을 만들어 다음 내용를 넣어준다.

```bat
@echo off

:menu
echo Select an option:
echo 1. elasticsearch-install
echo 2. elasticsearch-remove
echo 3. elasticsearch-start
echo 4. elasticsearch-stop
echo 5. kibana
echo 6. cebero
echo 7. exit

set /p choice=Enter your choice:

if "%choice%"=="1" (
    elasticsearch\bin\elasticsearch-service.bat install
    pause
    goto menu
)
if "%choice%"=="2" (
    elasticsearch\bin\elasticsearch-service.bat remove
    pause
    goto menu
)
if "%choice%"=="3" (
    elasticsearch\bin\elasticsearch-service.bat start
    pause
    goto menu
)
if "%choice%"=="4" (
    elasticsearch\bin\elasticsearch-service.bat stop
    pause
    goto menu
)
if "%choice%"=="5" (
    kibana\bin\kibana.bat
    pause
    goto menu
)
if "%choice%"=="6" (
    cerebro\bin\cerebro.bat
    pause
    goto menu
)
if "%choice%"=="7" (
    exit
)
else (
    echo Invalid choice. Please select a valid option.
    pause
    goto menu
)
```

<br />
<br />
<br />

[출처: 여동현, 「엘라스틱서치 바이블」, 위키북스](https://wikibook.co.kr/elasticsearch-bible/)

<br />
