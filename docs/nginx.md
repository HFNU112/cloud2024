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

## 创建启动nginx容器

```json
docker run \
-d \
--name myNginx \
-p 8080:80 \
-v html:/var/lib/docker/volumes/html \
-v conf:/var/lib/docker/volumes/conf \
-v logs:/var/lib/docker/volumes/logs \
nginx
```