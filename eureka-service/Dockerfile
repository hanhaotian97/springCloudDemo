FROM java

ENV TZ="Asia/Shanghai"
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone && dpkg-reconfigure -f noninteractive tzdata
ENV WORK_PATH /data/docker-project/

# --------APP---------
# 项目jar名称
ENV APP_NAME "eureka-service-0.0.1-SNAPSHOT"

# 项目参数
ENV APP_PARAMS ""

# 项目所采用配置
ENV APP_PROFILES "eureka"

# 上下文路径
ENV CONTEXT_PATH "/"

# 暴露端口
ENV APP_PORT "8761"

ENV APP_JAR $APP_NAME.jar

# -------JVM----------
ENV JVM_OPT "-Xmx1500m"


# -------LOG----------
ENV LOG_DIR $WORK_PATH/log


# -------EXPOSE-------
EXPOSE 8761

WORKDIR $WORK_PATH
COPY ./build/libs/*.jar $WORK_PATH
ADD run.sh $WORK_PATH


CMD ["/bin/bash", "run.sh"]