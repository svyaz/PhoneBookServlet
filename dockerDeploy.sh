#!/usr/bin/env bash
docker cp out/phonebook tomcat9:/usr/local/tomcat/webapps/
docker stop tomcat9
docker start tomcat9
