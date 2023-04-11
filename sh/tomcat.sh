#!/bin/bash
#tomcat启动、停止、重启脚本

#JDK安装路径
export JAVA_HOME=/opt/jdk1.8
export PATH=$JAVA_HOME/bin:$PATH

#Tomcat安装路径
export CATALINA_HOME=/home/lic/tomcat

#Tomcat安装路径
export CATALINA_BASE=/home/lic/tomcat

#Tomcat进程日志目录,方便启动好直接打印
logfile=/home/lic/tomcat/logs/catalina.out

#Tomcat的启动用户
export TOMCAT_USER=root

#如果在没有任何选项的情况下调用此脚本，则会显示TOMCAT_USAGE消息
TOMCAT_USAGE="Usage: $0 {\e[00;36mstart\e[00m|\e[00;31mstop\e[00m|\e[00;36mstatus\e[00m|\e[00;31mrestart\e[00m}"

#SHUTDOWN_WAIT is wait time in seconds for java proccess to stop
SHUTDOWN_WAIT=3

tomcat_pid() {
  echo `ps -fe | grep $CATALINA_BASE/conf | grep -v grep | tr -s " "|cut -d" " -f2`
}

start() {
  pid=$(tomcat_pid)
  if [ -n "$pid" ]
  then
    echo -e "\e[00;31mTomcat is already running (pid: $pid)\e[00m"
  else
    # Start tomcat
    echo -e "\e[00;36mStarting tomcat\e[00m"
    #if [ `user_exists $TOMCAT_USER` = "1" ];then
    #	su $TOMCAT_USER -c $CATALINA_HOME/bin/startup.sh
    #else
    #引用上面的变量启动脚本
      sh $CATALINA_HOME/bin/startup.sh
    #fi
    status
  fi
  	#引用上面变量名logfile 打印日志
  	tail -f  ${logfile}
  return 0
}

status(){
  pid=$(tomcat_pid)
  if [ -n "$pid" ]; then echo -e "\e[00;36mTomcat is running with pid: $pid\e[00m"
  else echo -e "\e[00;31mTomcat is not running\e[00m"
  fi
}

stop() {
  pid=$(tomcat_pid)
  if [ -n "$pid" ]
  then
    echo -e "\e[00;31mStoping Tomcat\e[00m"
    sh $CATALINA_HOME/bin/shutdown.sh

    let kwait=$SHUTDOWN_WAIT
    count=0;
    echo -n -e "\n\e[00;31mwaiting for processes to exit\e[00m";
    until [ `ps -p $pid | grep -c $pid` = '0' ] || [ $count -gt $kwait ]
    do
      sleep 1
      let count=$count+1;
    done

    if [ $count -gt $kwait ]; then
      kill -9 $pid
      echo -n -e "\n\e[00;31mtomcat stop success\e[00m"
    fi
  else
    echo -e "\e[00;31mTomcat is not running\e[00m"
  fi

  return 0
}

user_exists(){
    if id -u $1 >/dev/null 2>&1; then
      echo "1"
    else
      echo "0"
    fi
}

case $1 in
  start)
    start
  ;;

  stop)
    stop
  ;;

  restart)
    stop
    start
  ;;

  status)
    status
  ;;

  *)
    echo -e $TOMCAT_USAGE
  ;;
esac
exit 0


