#!/bin/bash

PID=$(pgrep -f 'aivle_4th_MiniProject')

if [ -z "$PID" ]; then
  echo "No application process found. Skipping stop."
  exit 0
fi

echo "Stopping application with PID: $PID"
kill -15 $PID
sleep 5

exit 0
