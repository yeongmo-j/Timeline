# Timeline (What is it?)
This is an application that is kind of SNS, which contains the feature of make a friend relationship, share my post, gathering friends' posts, and react with it through comment it or like it.  

This project is mainly consist of some open source framework 
* Spring boot
* React
* DBMS (in my case, I use MySQL)
* S2Graph

And this will be sumbmitted to `D2 CAMPUS FEST mini (7th)`  

# Introduce Document
[PDF slide](https://github.com/yeongmo-j/Timeline/blob/master/Timeline.pdf)

# Why this?
1. fast  
It does not use relational database for gathering posts which posted from friends but use graph database. Which means that It is much faster than join in SQL. So users do not have to wait much time in the timeline, and developers do not have to care about the waiting time that much.
2. intuitive  
UI of this application is very intuitive so that users do not have to reading about how to use it or feeling confuse when they use it. 

# Getting started
To start this application, you have to launch 3 seperate 4 application which list is on the top, Spring boot: the back-end server, React: the front-end view, Mysql: RDBMS, S2Graph: the graph database  
  
This is the directory's desciption
```
/api : Spring boot back-end
/timeline : React front-end
/s2graph : S2graph graph database
```
And this is the way to start it
> **Back-end (Spring boot)**  
여기다가 스프링 부트 시작하는 법
  
> **Front-end (React)**  
(for development mode)  
`cd timeline`  
`npm start` or `yarn start`  

> **Graph database (S2Graph)**  
`cd s2graph/s2/apache-s2graph-0.2.0-incubating-src/target/apache-s2graph-0.2.0-incubating-bin`  
`sh bin/start-s2graph.sh`  

> **RDBMS**  
Any DBMS whatever you want 

# Settings
You can setting by your environment to each frameworks  
> **Back-end (Spring boot)**  
at `/api/src/main/resources/application.properties`  
spring.datasource.url - your dbms database url  
spring.datasource.username - your dbms account name  
spring.datasource.password - your dbms account password    
at `/api/src/main/java/com/timeline/api/graphEntity/HttpFactory.java`  
graphUrl - your s2graph url

> **Front-end (React)**  
at `/timeline/src/setting.js`  
serverUrl - your backend url
  
> **Graph database (S2Graph)**  
at `/s2graph/s2/apache-s2graph-0.2.0-incubating-src/conf/application.conf`  
check [S2Graph official document](https://steamshon.gitbooks.io/s2graph-book/content/)  
  
# Demo video
[Youtube](https://youtu.be/90HdtBw2n_g)

# Demo Page
[Click!](http://yeongmoj.timeline.s3-website.ap-northeast-2.amazonaws.com)

# Licence
MIT
  
# Resources
* [Spring boot](https://github.com/spring-projects/spring-boot) - [Apache License 2.0](https://github.com/spring-projects/spring-boot/blob/master/LICENSE.txt)
* [React](https://github.com/facebook/react/) - [MIT License](https://github.com/facebook/react/blob/master/LICENSE)
* [S2Graph](https://github.com/apache/incubator-s2graph) - [Apache License 2.0](https://github.com/apache/incubator-s2graph/blob/master/LICENSE)
* [Ant Design](https://github.com/ant-design/ant-design/) - [MIT License](https://github.com/ant-design/ant-design/blob/master/LICENSE)
* [react-fb-image-grid](https://github.com/Expertizo/react-fb-image-grid) - [MIT License](https://github.com/Expertizo/react-fb-image-grid/blob/master/LICENSE)  

배포하기  
신청하기    