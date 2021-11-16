#!/bin/bash

echo 'Latest tag'
echo '------'
cat currenttag
echo '------'
echo 'enter docker tag :'

read dockerTag
echo $dockerTag > currenttag

echo 'building native image'
./buildNative.sh  #Native build

echo 'building docker image'
docker build -t kdkanishka/todo-service:$dockerTag .
