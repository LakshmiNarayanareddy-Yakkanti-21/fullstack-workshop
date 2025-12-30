#!/bin/bash
set -e

if [ "$#" -eq 0 ]; then
    echo "Usage: ./log-analyzer.sh <log-file>"
    exit 1
fi

LOG_FILE="$1"

if [ ! -f "$LOG_FILE" ]; 
then
    echo "Error: File '$LOG_FILE' does not exist."
    exit 1
fi

TOTAL_LINES=$(wc -l < "$LOG_FILE")

INFO_COUNT=$(grep -c "INFO" "$LOG_FILE" || true)
WARNING_COUNT=$(grep -c "WARNING" "$LOG_FILE" || true)
ERROR_COUNT=$(grep -c "ERROR" "$LOG_FILE" || true)

# Extract unique IP addresses from log file
# --------------------------------------------
UNIQUE_IPS=$(grep -oE '[0-9]+\.[0-9]+\.[0-9]+\.[0-9]+' "$LOG_FILE" | sort -u)

# Display the analysis report
# --------------------------------------------
echo "========== LOG ANALYSIS REPORT =========="
echo "Log File       : $(pwd)/$LOG_FILE"
echo "File Operation : Read-only (No file created)"
echo "----------------------------------------"
echo "Total Lines    : $TOTAL_LINES"
echo "INFO Count     : $INFO_COUNT"
echo "WARNING Count  : $WARNING_COUNT"
echo "ERROR Count    : $ERROR_COUNT"
echo "----------------------------------------"
echo "Unique IP Addresses Found:"

if [ -z "$UNIQUE_IPS" ]; then
    echo "  None"
else
    for ip in $UNIQUE_IPS; do
        echo "  - $ip"
    done
fi

echo "========================================"