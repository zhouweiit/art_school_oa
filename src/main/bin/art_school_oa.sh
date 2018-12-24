#!/usr/bin/env bash
PRG="$0"
BIN=`cd $(dirname "$PRG"); pwd`
HOME=`dirname "$BIN"`
PORT="$1"

if [ ! $PORT  ];then
	PORT=8080
fi

if [ "$PORT" -gt 0 ] 2>/dev/null ;then 
   echo "port=$PORT"  
else
   echo "PORT must a num"
   exit
fi


LIB=`find ${HOME}/lib/ -name "*.jar"`
LOG=${HOME}/log/
CONF=${HOME}/conf/
PIDFILE=${HOME}/pidfile
WEBAPP=${HOME}/webapp

if [ "$PORT" -ne 8080  ];then
    PIDFILE=${HOME}/pidfile_$PORT
fi

echo $PIDFILE

classpath="."
classpath=$classpath:$CONF
for item in $LIB
do
    classpath=$classpath:$item:$WEBAPP
done
echo $classpath


JVM_OPTS="-server -Xms4G -Xmx4G -XX:MaxPermSize=250M -XX:PermSize=100M -Xloggc:$LOG/gc_$PORT.log -XX:NewRatio=4 -XX:SurvivorRatio=2 -XX:PretenureSizeThreshold=5M -XX:CMSFullGCsBeforeCompaction=3 -XX:+UseParNewGC -XX:+PrintClassHistogram -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -XX:+PrintGCDetails -XX:+PrintPromotionFailure  -XX:+PrintGCDateStamps -XX:+PrintGCApplicationStoppedTime -XX:+UseConcMarkSweepGC -XX:CMSInitiatingOccupancyFraction=70 -XX:+CMSDumpAtPromotionFailure -XX:+UseCMSCompactAtFullCollection -XX:+CMSParallelRemarkEnabled -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=$LOG/dump.log

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
java $JVM_OPTS $JVM_JMX -cp $classpath com.chengzi.art.school.oa.Launch > ${LOG}t1 2>${LOG}t2 &
PID=$!
echo $PID > $PIDFILE
