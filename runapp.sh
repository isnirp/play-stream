#!/usr/bin/env bash


mode1() {
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8012 1
}

mode2() {
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8013 2 &
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8013 2 &
}

mode3() {
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8012 2
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8012 2
}

#choose mode
mode1
