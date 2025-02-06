#!/bin/bash

mvn clean package -DskipTest

if [ ! -d "$HOME/.monitor/" ]; then
  mkdir ~/.monitor
fi

case "$OSTYPE" in
  darwin*)  cp ./monitor.sh ~/.monitor ;;
  msys*)    cp ./monitor.bat ~/.monitor ;;
  *)        echo "unknown: $OSTYPE" ;;
esac

cp ./target/monitor-0.0.1-SNAPSHOT.jar ~/.monitor/monitor.jar

mvn clean
