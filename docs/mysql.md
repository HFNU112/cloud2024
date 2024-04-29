1、搜索docker中mysql镜像

```json
docker search mysql
```

2、拉取mysql镜像

```json
docker pull mysql:8.0
```

创建数据文件夹
```json
mkdir -p /home/husp/mysql/data
```

3、创建并运行mysql容器，通过数据卷维护配置数据

```json
docker run \
  -p 3306:3306 \
  --name mysql \
  -e MYSQL_ROOT_PASSWORD=123456 \
  -v /home/husp/mysql/data:/var/lib/mysql \
  -d \
  mysql:8.0 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```