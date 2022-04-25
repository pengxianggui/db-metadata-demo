#!/bin/bash

#版本
version=$1

## 部署目标: code/doc
type=$(echo $2 | sed 's/\\n.*//g')

#前缀
prefix="registry.cn-hangzhou.aliyuncs.com/hthj_asoco/db-metadata:"

echo "type:${type}"
echo "version:${version}"
echo "prefix:${prefix}"

echo "构建server镜像..."
# build server
docker  build  -f server/Dockerfile  --rm=true  -t $prefix"server-"${version} ./server

echo "构建web镜像..."
# build web
docker  build -f web/Dockerfile --rm=true  -t $prefix"web-"${version} ./web ;

echo "登录镜像仓库..."
docker login -u "${PLUGIN_DOCKER_USERNAME}" -p "${PLUGIN_DOCKER_PASSWORD}" registry.cn-hangzhou.aliyuncs.com;

echo "推送server镜像..."
docker push $prefix"server-"${version} ;

echo "推送web镜像..."
docker push $prefix"web-"${version} ;

# 清理镜像
echo "清理本地server镜像..."
docker rmi $prefix"server-"${version} ;
echo "清理本地web镜像..."
docker rmi $prefix"web-"${version} ;

#清理空间
docker system prune -f;

exit 0;
