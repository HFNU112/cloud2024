## 拉取nginx镜像

```json
docker pull nginx
```

## 创建数据卷

```json
docker volume create html
```

## 查看数据卷位置

```json
docker volume inspect html
```

创建文件夹以及配置文件
```json
mkdir -p /home/hu-sp/nginx/html
mkdir -p /home/hu-sp/nginx/conf/conf.d ; touch nginx.conf
mkdir -p /home/hu-sp/nginx/conf ; touch default.conf
mkdir -p /home/hu-sp/nginx/log
```

## 创建启动nginx容器

```json
docker run \
-d \
--name nginx \
-p 8080:80 \
-v /home/hu-sp/nginx/html:/usr/share/nginx/html \
-v /home/hu-sp/nginx/conf/nginx.conf:/etc/nginx/nginx.conf \
-v /home/hu-sp/nginx/conf/conf.d/:/etc/nginx/conf.d/ \  # conf.d/文件夹下的文件 default.conf
-v /home/hu-sp/nginx/log:/var/log/nginx \
nginx
```