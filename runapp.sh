#!/usr/bin/env bash

java -jar target/player-stream-1.0-SNAPSHOT.jar &
java -jar target/player-stream-1.0-SNAPSHOT.jar &
read -n 1 -p “-” userinput
exit 1