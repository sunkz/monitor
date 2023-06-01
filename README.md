## monitor
> 定时截屏去除相似图片后上传至 GITHUB 仓库

### STEP.1
> 配置 application.properties
```properties
# GITHUB 用户名
monitor.user=
# GITHUB 仓库名
monitor.repo=
# GITHUB token
monitor.token=
# 监控频率 5000(每5秒)...
monitor.frequency=
```
### STEP.2
> 执行 ./init.sh

### STEP.3
> 进入 ~/.monitor 执行 monitor.sh(win 执行.bat)

### STEP.4 
> 配置自动启动 <br><br>
> MAC : 启动项添加 monitor.sh <br><br>
> WIN : 
> - 为monitor.bat 创建快捷方式 <br>
> - win + r  shell:startup 将快捷方式复制进去