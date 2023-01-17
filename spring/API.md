# Make Spring Project

    Spring Initializr
    https://start.spring.io/

    |ㅈㅈㅈ|ㅈㅈㅈ|ㅈㅈㅈ|
    |-----------|-------|------------------|
    |Project    | Gradle - Groovy| ㄷㄷㄷ |



    |Language    : Java
    |Spring Boot   : (SNAPSHOT)이 안써진 가장 최신 버전
    |Project Metadata
    |Group: 프로젝트 집합: com.companyName
    |Artifact: 프로젝트 이름: App
    |Name
    |Description: 설정 안해도됨
    |Package name: 애플리케이션 id 문구: com.companyName.App
    |Packaging: Jar
    |Java: 17
    |Dependencies:
    |Spring Boot Dev Tools: 소스파일의 변화를 감지하여 자동으로 빌드해주는 라이브러리
    |Spring Web: 기본적인 웹 애플리케이션을 만들때 사용하는 라이브러리

# build.gradle

#### plugins

    plugins {
        id 'java'
        id 'org.springframework.boot' version '2.7.7'
        id 'io.spring.dependency-management' version '1.0.15.RELEASE'
    }

#### group

    group = 'com.study' // 프로젝트의 집합
    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = '17'

#### configurations

    configurations {
        compileOnly {
        extendsFrom annotationProcessor
        }
    }

#### repositories

    repositories {
        mavenCentral()
    }

#### dependencies

    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-web'
        compileOnly 'org.projectlombok:lombok'
        developmentOnly 'org.springframework.boot:spring-boot-devtools'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }

#### tasks

    tasks.named('test') {
    useJUnitPlatform()
    }
