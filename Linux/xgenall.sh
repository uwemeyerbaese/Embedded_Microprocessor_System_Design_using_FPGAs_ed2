#!/bin/bash
groupadd -f students
useradd -d/home/alice -g students -m -s/bin/bash alice
passwd alice <<ENDA
password
password
ENDA
useradd -d/home/bob   -g students -m -s/bin/dash bob
passwd alice <<ENDB
temppwd
temppwd
ENDB
useradd -d/home/carol -g students -m -s/bin/bash carol
passwd alice <<ENDC
carol234
carol234
ENDC
useradd -d/home/dave  -g students -m -s/bin/sh dave
passwd alice <<ENDD
DavE3#
DavE3#
ENDD
useradd -d/home/eve   -g students -m -s/bin/dash eve
passwd alice <<ENDE
xu9Kv@W&^fHhH
xu9Kv@W&^fHhH
ENDE
