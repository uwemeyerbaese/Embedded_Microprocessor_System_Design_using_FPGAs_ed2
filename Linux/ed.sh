#!/bin/bash
ed $1 <<END
10,12d
5,7d
:2/20/Good Bye/g
w
q
END
