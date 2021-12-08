#!/bin/sh
# ps -eo pid,command | grep karaf | grep backend-distrib-biz | awk '{system("kill -6 " $1)}'
ssh leguide@192.168.4.191  pkill -f backend-distrib-biz 
scp /var/lib/jenkins/jobs/backend-distrib-biz/workspace/distrib/backend-biz/target/backend-distrib-biz*.tar.gz leguide@192.168.4.191:transfer/business

ssh leguide@192.168.4.191 rm -rf jenkins-deployment/business/*
ssh leguide@192.168.4.191 mv transfer/business/backend-distrib-biz*.tar.gz jenkins-deployment/business

ssh leguide@192.168.4.191 "cd jenkins-deployment/business && tar zxf backend-distrib-biz*.tar.gz"

echo "karaf backend-biz will start ..."
ssh leguide@192.168.4.191 jenkins-deployment/business/data1/backend/backend-distrib-biz*/bin/start
echo "karaf backend-biz should have started"
