#!/usr/bin/env bash
if test ! -z $1
then
    echo "parameter couldn't found"
    exit -1
fi
OUTPUT=`activator playGenerateSecret | grep "Generated new secret: " | sed 's/.*: // '`
echo $OUTPUT
exit 0