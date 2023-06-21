#!/bin/bash

if [ $DEBUG'' = "true" ]; then
    set -x
fi

set -e

jarPath="/app/app.jar"
# stop
echo "begin stop if exist. the process will be killed:"
echo `ps -ef | grep $jarPath | grep -v "grep"`
pid=`ps -ef | grep $jarPath | grep -v "grep" | awk '{print $1}'`
for id in $pid
do
  kill -9 $id
  echo "killed $id"
done

# start
echo "begin start.."
cmd="java $JAVA_OPTS "

cd /app # 如果不进入app执行启动命令, 配置文件的加载存在问题(app.jar 采用的是PropertiesLauncher启动的，具体参考: https://docs.spring.io/spring-boot/docs/current/reference/html/executable-jar.html#executable-jar.property-launcher)
cmd="$cmd -jar ${jarPath}"
echo "execute command: $cmd"
eval "$cmd"

exec "$@"
