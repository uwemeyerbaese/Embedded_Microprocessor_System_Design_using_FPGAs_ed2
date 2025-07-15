#!/bin/bash
FILENAME="/etc/passwd"
while IFS=: read -r username password userid groupid comment homedir cmdshell
do
  if [ $userid -ge 1000 ]; then
#  echo "$username, $userid, $comment $homedir"
    name=${comment//,/}
    echo "$username (UID:$userid) uses $cmdshell"
  fi
done < $FILENAME