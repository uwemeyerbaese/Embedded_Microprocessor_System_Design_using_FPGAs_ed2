#!/bin/bash
vi $1 <<END
10,12d
5,7d
w
q
END
