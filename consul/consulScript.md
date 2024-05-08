```yaml
atguigu:
  info: welcome to consul world dev config version = 1
logging:
  pattern:
    dateformat: yyyy-MM-dd HH:mm:ss.SSS
```

docker安装consul并运行容器

```json
https://developer.hashicorp.com/consul/tutorials/docker
```

拉取consul镜像
```json
docker pull hashicorp/consul:latest
```

查看镜像
```json
docker images -f 'reference=consul'
```

级联创建数据文件夹
```json
mkdir -p /home/husp/consul
```

创建并运行consul容器，通过数据卷维护配置数据
```json
docker run \
-d \
--name=consul \
-p 8500:8500 \
-v /home/husp/consul/data:/consul/data \
hashicorp/consul:latest agent \
-server \
-bootstrap \
-ui \
-client=0.0.0.0
```

进入consul容器

```json
docker exec -it consul /bin/sh
```