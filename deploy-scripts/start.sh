#!/bin/bash

APP_DIR=/home/ec2-user/app/build/libs
LOG_DIR=/home/ec2-user/logs

mkdir -p $LOG_DIR

JAR_NAME=$(ls $APP_DIR/*SNAPSHOT.jar | grep -v plain | head -n 1)

echo "Starting application: $JAR_NAME"

nohup java -jar $JAR_NAME > $LOG_DIR/app.log 2>&1 &
