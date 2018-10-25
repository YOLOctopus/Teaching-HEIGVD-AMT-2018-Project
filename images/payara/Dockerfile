FROM payara/server-full:5.183

MAINTAINER YOLOctopus <https://github.com/YOLOctopus>

COPY gamification.war $DEPLOY_DIR

ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && echo 'create-jdbc-connection-pool \ --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource \ --restype javax.sql.DataSource \ --property user=root:password=root:DatabaseName=amtdb:ServerName=db:port=3306 mypool \ create-jdbc-resource --connectionpoolid mypool jdbc/myressource \ stop-domain domain1 \' > mycommands.asadmin && cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && ${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}'
