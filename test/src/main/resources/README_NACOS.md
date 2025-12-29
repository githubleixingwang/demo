# Nacos 配置说明

## 概述

项目已配置 Nacos 开关控制，默认情况下 Nacos 功能是**关闭**的，项目可以在没有 Nacos 服务的情况下正常启动。

## 配置方式

### 方式1：通过环境变量控制（推荐）

#### 启用 Nacos 服务发现
```bash
# Windows
set NACOS_DISCOVERY_ENABLED=true

# Linux/Mac
export NACOS_DISCOVERY_ENABLED=true
```

#### 启用 Nacos 配置中心
```bash
# Windows
set NACOS_CONFIG_ENABLED=true

# Linux/Mac
export NACOS_CONFIG_ENABLED=true
```

#### 同时启用服务发现和配置中心
```bash
# Windows
set NACOS_DISCOVERY_ENABLED=true
set NACOS_CONFIG_ENABLED=true

# Linux/Mac
export NACOS_DISCOVERY_ENABLED=true
export NACOS_CONFIG_ENABLED=true
```

### 方式2：通过启动参数控制

```bash
java -jar app.jar --spring.cloud.nacos.discovery.enabled=true --spring.cloud.nacos.config.enabled=true
```

### 方式3：修改配置文件

直接修改 `bootstrap.yml` 文件：

```yaml
spring:
  cloud:
    nacos:
      discovery:
        enabled: true  # 改为 true 启用服务发现
      config:
        enabled: true  # 改为 true 启用配置中心
```

## 环境变量说明

| 环境变量 | 说明 | 默认值 | 示例 |
|---------|------|--------|------|
| `NACOS_DISCOVERY_ENABLED` | Nacos 服务发现开关 | `false` | `true` / `false` |
| `NACOS_CONFIG_ENABLED` | Nacos 配置中心开关 | `false` | `true` / `false` |
| `NACOS_SERVER_ADDR` | Nacos 服务器地址 | `127.0.0.1:8848` | `192.168.1.100:8848` |
| `NACOS_NAMESPACE` | Nacos 命名空间 | `test` | `production` |
| `NACOS_GROUP` | Nacos 配置组 | `DEFAULT_GROUP` | `DEV_GROUP` |
| `NACOS_USER` | Nacos 用户名 | `nacos` | `admin` |
| `NACOS_PASSWORD` | Nacos 密码 | `nacos` | `password123` |

## 注意事项

1. **默认关闭**：为了确保项目在没有 Nacos 服务时也能正常启动，默认情况下 Nacos 功能是关闭的。

2. **独立控制**：服务发现和配置中心可以独立控制，可以根据实际需求选择启用其中一个或全部启用。

3. **启动顺序**：如果启用了 Nacos，请确保 Nacos 服务已经启动并可以访问，否则项目启动时可能会报错。

4. **生产环境**：在生产环境中，建议通过环境变量或配置中心来管理这些开关，而不是直接修改配置文件。

## 验证配置

启动项目后，可以通过以下方式验证 Nacos 是否启用：

1. 查看启动日志，如果看到 Nacos 相关的连接信息，说明已启用
2. 如果看到 "Nacos discovery is disabled" 或类似信息，说明已禁用
3. 检查应用是否能正常启动，如果禁用状态下启动成功，说明配置正确

