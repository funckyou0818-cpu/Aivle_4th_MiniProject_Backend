#!/bin/bash

APP_DIR=/home/ec2-user/app
JAR_NAME=$(ls $APP_DIR/*.jar)

cd $APP_DIR

nohup java -jar $JAR_NAME > app.log 2>&1 &
