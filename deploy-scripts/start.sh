#!/bin/bash

APP_DIR=/home/ec2-user/app/build/libs
LOG_DIR=/home/ec2-user/logs

mkdir -p $LOG_DIR
chown -R ec2-user:ec2-user $LOG_DIR

JAR_NAME=$(ls $APP_DIR/*SNAPSHOT.jar | grep -v plain | head -n 1)

if [ -z "$JAR_NAME" ]; then
  echo "❌ JAR not found in $APP_DIR"
  exit 1
fi

nohup java -jar $JAR_NAME > $LOG_DIR/app.log 2>&1 &

exit 0
