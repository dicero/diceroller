#!/bin/sh
PROJECT=$1
PROFILE=$2
LOCATION='./../'
LOGS='/home/dev/logs'
#PORT=$4
echo '部署项目[ '${PROJECT}' ], 环境 '${PROFILE}
#mvn clean package -Dmaven.test.skip=true
ps aux | grep ${LOCATION}${PROJECT}/target | awk '{print $2}' >> ${LOCATION}${PROJECT}/tmp
cat ${LOCATION}${PROJECT}/tmp | head -2 | xargs kill -9
cat ${LOCATION}${PROJECT}/tmp | head -1 | xargs kill -9
rm ${LOCATION}${PROJECT}/tmp

#if [ -z $PORT ]; then
#   PORT="8080"
#fi

if [ ${LOCATION}${PROJECT}"/target/${PROJECT}-0.0.1-SNAPSHOT.jar" ]; then
	if [ ! -d ${LOGS} ]; then
		mkdir ${LOGS}
	fi
	if [ -f ${LOGS}"/"${PROJECT}"-nohup.out" ]; then
		rm ${LOGS}"/"${PROJECT}"-nohup.out"
	fi
	touch ${LOGS}"/"${PROJECT}"-nohup.out"
	echo '启动中...'
	nohup java -jar ${LOCATION}${PROJECT}/target/${PROJECT}-0.0.1-SNAPSHOT.jar --spring.profiles.active=${PROFILE}  >> ${LOGS}"/"${PROJECT}"-nohup.out" &    
	tail -f ${LOGS}"/"${PROJECT}"-nohup.out" | sed '/JVM running/ q'
fi
echo '部署完成.项目[ '${PROJECT}' ], 环境 '${PROFILE}
