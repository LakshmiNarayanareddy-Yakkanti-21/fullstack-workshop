#!/bin/bash
set -e
<<<<<<< HEAD

if [ "$#" -eq 0 ]; then
=======
set -u

if [ $# -eq 0 ]; then
>>>>>>> 9eb5fd7683ec294d6992cdae6304cd7814878dd9
    echo "Usage: ./log-analyzer.sh <log-file>"
    exit 1
fi

<<<<<<< HEAD
LOG_FILE="$1"

if [ ! -f "$LOG_FILE" ]; 
then
=======
LOG_FILE=$1

if [ ! -f "$LOG_FILE" ]; then
>>>>>>> 9eb5fd7683ec294d6992cdae6304cd7814878dd9
    echo "Error: File '$LOG_FILE' does not exist."
    exit 1
fi

TOTAL_LINES=$(wc -l < "$LOG_FILE")

<<<<<<< HEAD
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
=======
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
>>>>>>> 9eb5fd7683ec294d6992cdae6304cd7814878dd9
        echo "  - $ip"
    done
fi

<<<<<<< HEAD
echo "========================================"
=======
echo "========================================="
>>>>>>> 9eb5fd7683ec294d6992cdae6304cd7814878dd9
