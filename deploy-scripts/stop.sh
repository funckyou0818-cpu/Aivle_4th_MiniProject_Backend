#!/bin/bash

PID=$(pgrep -f 'aivle_4th_MiniProject')

if [ -z "$PID" ]; then
  echo "No process found. Skip stopping."
  exit 0
fi

kill -15 $PID || true
sleep 5
exit 0
