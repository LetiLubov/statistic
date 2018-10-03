FROM openjdk:8-jre
WORKDIR /statistic
VOLUME ["/statistic"]
COPY maven/statistic.jar statistic.jar
COPY maven/start.sh start.sh
COPY maven/wait-for-it.sh wait-for-it.sh
RUN sh -c 'touch statistic.jar'
ENTRYPOINT ["./start.sh"]

