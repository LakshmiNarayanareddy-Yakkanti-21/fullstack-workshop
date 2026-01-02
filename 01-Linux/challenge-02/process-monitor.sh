#!/bin/bash

set -e
set -u
if [ $# -ne 2 ]; 
then
    echo "Usage: $0 <process-name> <interval-seconds>"
    exit 1
fi

PROCESS_NAME=$1
INTERVAL=$2

echo "Monitoring process: $PROCESS_NAME"
echo "Checking every $INTERVAL seconds..."
echo "-----------------------------------"

while true
do
    TIMESTAMP=$(date "+%Y-%m-%d %H:%M:%S")

    if pgrep "$PROCESS_NAME" > /dev/null
    then
        echo "[$TIMESTAMP] $PROCESS_NAME is running"
    else
        echo "[$TIMESTAMP] ALERT: $PROCESS_NAME is NOT running"
        echo "Process stopped. Exiting monitor."
        exit 1
    fi

    sleep $INTERVAL
done
