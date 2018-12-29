#!/usr/bin/env bash
PRG="$0"
BIN=`cd $(dirname "$PRG"); pwd`
HOME=`dirname "$BIN"`
PORT=9000

LIB=`find ${HOME}/lib/ -name "*.jar"`
LOG=${HOME}/log
CONF=${HOME}/conf
PIDFILE=${HOME}/pidfile
WEBAPP=${HOME}/webapp

PIDFILE=${HOME}/pidfile_$PORT

echo $HOME
echo $PIDFILE

classpath="."
classpath=$classpath:$CONF:$WEBAPP

for item in $LIB
do
    classpath=$classpath:$item
done
echo $classpath


JVM_OPTS="-server -Xms200m -Xmx500m -XX:MaxPermSize=100M -XX:PermSize=50M -Xloggc:$LOG/gc_$PORT.log -XX:NewRatio=4 -XX:SurvivorRatio=2 -XX:PretenureSizeThreshold=5M -XX:CMSFullGCsBeforeCompaction=3 -XX:+UseParNewGC -XX:+PrintClassHistogram -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+PrintPromotionFailure  -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSDumpAtPromotionFailure -XX:+UseCMSCompactAtFullCollection -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG/dump.log"
echo $JVM_OPTS

if [ -f $PIDFILE ];then
   PID=`cat $PIDFILE`
   tr=`jps -v | grep $PID | grep $PORT | grep $HOME`
   echo "tr:"$tr
   if [ "$tr" != "" ] ; then
      echo "kill $PID"
      kill $PID
   fi
fi

sleep 5
java $JVM_OPTS -cp $classpath com.chengzi.art.school.oa.Launch > ${LOG}/t1 2>${LOG}/t2 &
PID=$!
echo $PID > $PIDFILE