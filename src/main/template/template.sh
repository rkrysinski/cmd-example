#!/bin/sh

this_script="./$0"
#this_script=`which "$0" 2>/dev/null`

[ $? -gt 0 -a -f "$0" ] && this_script="$0"

export CLASSPATH="$this_script"

java=java
if test -n "$JAVA_HOME"
then
        java="$JAVA_HOME/bin/java"
fi
exec "$java" -jar $this_script "$@"

exit 1
