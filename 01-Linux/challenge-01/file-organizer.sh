#!/bin/bash

set -e
set -u
if [ $# -ne 1 ]; 
then
  echo "Usage: $0 <directory-path>"
  exit 1
fi

FOLDER=$1

if [ ! -d "$FOLDER" ]; 
then
  echo "Directory does not exist"
  exit 1
fi

cd "$FOLDER"

for FILE in *
do
  if [ -f "$FILE" ]; 
then
    EXTENSION="${FILE##*.}"

    if [ ! -d "$EXTENSION" ]; 
    then
      mkdir "$EXTENSION"
    fi

    mv "$FILE" "$EXTENSION/"
  fi
done

echo "Files organized successfully"
