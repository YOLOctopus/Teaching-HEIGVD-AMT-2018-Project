FROM payara/server-full:5.183

MAINTAINER YOLOctopus <https://github.com/YOLOctopus>

COPY init.sh ${PAYARA_PATH}

COPY gamification.war $DEPLOY_DIR

ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && \
${PAYARA_PATH}/init.sh && \
cat ${DEPLOY_COMMANDS} >> mycommands.asadmin && \
${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN} 
