#!/bin/bash

if [ $# -eq 0 ]; then
    echo "Usage: ./log-analyzer.sh <log-file>"
    exit 1
fi

LOG_FILE=$1

if [ ! -f "$LOG_FILE" ]; then
    echo "Error: File '$LOG_FILE' does not exist."
    exit 1
fi

TOTAL_LINES=$(wc -l < "$LOG_FILE")

INFO_COUNT=$(grep -c "INFO" "$LOG_FILE")
WARNING_COUNT=$(grep -c "WARNING" "$LOG_FILE")
ERROR_COUNT=$(grep -c "ERROR" "$LOG_FILE")

IPS=$(grep -oE '[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+' "$LOG_FILE" | sort -u)

echo "========== LOG ANALYSIS REPORT =========="
echo "File: $(pwd)/$LOG_FILE"
echo "Total Lines: $TOTAL_LINES"
echo "-----------------------------------------"
echo "INFO:    $INFO_COUNT"
echo "WARNING: $WARNING_COUNT"
echo "ERROR:   $ERROR_COUNT"
echo "-----------------------------------------"
echo "Unique IP Addresses Found:"

if [ -z "$IPS" ]; then
    echo "  None"
else
    for ip in $IPS; do
        echo "  - $ip"
    done
fi

echo "========================================="
