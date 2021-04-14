# spring security篇章
## 前言
在此部分,你将看到我学习security的一些代码,注释不是很多，后续慢慢补充
欢迎大家下载参考，记得给我star!!
### 自我推荐个人主页 

### [zerotower的技术小屋](https://www.zerotower.cn)

## springboot版本号说明

此代码示例均为springboot **2.3.7**版本下测试通过

对应的spring cloud版本为 **HoxtonSR.9**

springboot和spirng cloud的版本匹配问题

## 数据库说明
请配置自己的MySQL\Redis数据库
安装数据库的教程请查看菜鸟教程
[安装MySQL](https://www.runoob.com/mysql/mysql-install.html)
[安装REdis](https://www.runoob.com/redis/redis-install.html)

## 关于nacos的说明
安装请参考官网
[nacos官网]()
nacos的配置文件为bootstrap.yaml
如果不使用配置和服务注册功能请 将enable设置为false

## 参考资料说明
### 有精力总是要看看[官方的文档](https://docs.spring.io/spring-security/site/docs/5.4.2/reference/html5/#introduction)

### 博客很大部分借鉴了大佬

[参考的博客汇总](https://blog.csdn.net/yuanlaijike/category_9283872.html)

### 小部分参考了人民邮电出版社的spring”三剑客“
三剑客书名
**《深入浅出Spring Boot2.X》（杨开振）**

[异步社区](https://www.epubit.com/bookDetails?id=N27915)

**《Spring实战（第5版）》（Craig Walls）**

[异步社区](https://www.epubit.com/bookDetails?id=UB6cb48474abc65)

**《SpringBoot微服务实战》（John Carnell)**

[异步社区](https://www.epubit.com/bookDetails?id=N35285)

同时,你还可以在[ePUBee](http://cn.epubee.com/books/)找到电子版的资料

如果实在需要电子书资料和我已经下载好的配套代码请邮箱联系

我的个人邮箱为：zero@zerotower.xyz

邮件发送请注明邮件主题，谢谢！

## 一些建议

由于数据库或者配置nacos在windows环境下一些神奇的玄学问题，有条件请使用云服务器（推荐CentOS)或者虚拟机的Linux环境(推荐Ubuntu),虚拟机的使用以及服务器的资料请百度、csdn、简书、菜鸟教程。依然无法解决问题，请参考上面说到的邮箱联系我。

## 模块说明

### security-simple
简单上手spring security  了解角色控制和权限控制

### secuirty-simple-good

对security-simple更加优化，权限配置更加颗粒化
