#!/usr/bin/env bash

mode1() {
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8011 &
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8011 &
}

mode2() {
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8011
  java -jar target/player-stream-1.0-SNAPSHOT.jar 8011
}

#choose mode
mode1

