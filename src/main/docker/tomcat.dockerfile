FROM tomcat:8.5.29-jre8
MAINTAINER jealcazars <jealcazars@gmail.com>

COPY maven/helloworld.war 						/usr/local/tomcat/webapps/