FROM k8s81.wqsp.test:8444/general/jdk-custom:11.0.9

WORKDIR /opt/service/

COPY ./PACKAGE_PATH .


ENTRYPOINT ["/bin/sh", "-c", "java  ${JAVA_OPTIONS} -jar PACKAGE_NAME ${JAVA_ARG}"]
