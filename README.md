# Timeline (What is it?)
This is an application which is kind of SNS, which contains the feature of make a friend relationship, share my post, gathering friends' posts, and react with it through comment it or like it.  

This project is mainly consist of some open source framework 
* Spring boot
* React
* Mysql (or you can use other DBMS)
* S2Graph

And this is for sumbmit to `D2 CAMPUS FEST mini (7th)`

# Getting started
To start this application, you have to launch 3 seperate 4 application which list is on the top, Spring boot: the back-end server, React: the front-end view, Mysql: RDBMS, S2Graph: the graph database  
  
This is the directory's desciption
```
api - Spring boot back-end
timeline - React front-end
s2graph - S2graph graph database
```
And this is the way to start it
> Back-end (Spring boot)  
여기다가 스프링 부트 시작하는 법
  
> Front-end (React)  
여기다가 리액트 시작하는 법

> Graph database (S2Graph)  
여기다가 S2Graph 시작하는 법

> RDBMS  
너가 원하는 아무거나 

# Settings
You can setting by your environment to each frameworks  
> Back-end (Spring boot)  
at `/api/src/main/resources/application.properties`  
spring.datasource.url - your dbms database url
spring.datasource.username - your dbms account name
spring.datasource.password - your dbms account password  
at `/api/src/main/java/com/timeline/api/graphEntity/HttpFactory.java`  
graphUrl - your s2graph url

> Front-end (React)  
at `/timeline/src/setting.js`  
serverUrl - your backend url
  

> Graph database (S2Graph)  
at `/s2graph/s2/apache-s2graph-0.2.0-incubating-src/conf/application.conf`  
check [S2Graph official document](https://steamshon.gitbooks.io/s2graph-book/content/)  
  
# Licence
MIT
  
# Resources
* [Spring boot](https://github.com/spring-projects/spring-boot) - [Apache License 2.0](https://github.com/spring-projects/spring-boot/blob/master/LICENSE.txt)
* [React](https://github.com/facebook/react/) - [MIT License](https://github.com/facebook/react/blob/master/LICENSE)
* [S2Graph](https://github.com/apache/incubator-s2graph) - [Apache License 2.0](https://github.com/apache/incubator-s2graph/blob/master/LICENSE)
* [MySQL](이것도 해야하나?)
* [Ant Design](https://github.com/ant-design/ant-design/) - [MIT License](https://github.com/ant-design/ant-design/blob/master/LICENSE)
* [react-fb-image-grid](https://github.com/Expertizo/react-fb-image-grid) - [MIT License](https://github.com/Expertizo/react-fb-image-grid/blob/master/LICENSE)