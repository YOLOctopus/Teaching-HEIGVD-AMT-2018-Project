FROM payara/server-full:5.183

MAINTAINER YOLOctopus <https://github.com/YOLOctopus>

COPY create_pool_and_ressource.sh ${PAYARA_PATH}

COPY gamification.war ${DEPLOY_DIR}

ADD drivers/mysql-connector-java-5.1.39-bin.jar /opt/payara/glassfish/domains/domain1/lib/

ENTRYPOINT ${PAYARA_PATH}/generate_deploy_commands.sh && \
${PAYARA_PATH}/create_pool_and_ressource.sh && \
cat ${POSTBOOT_COMMANDS} >> mycommands.asadmin && \
${PAYARA_PATH}/bin/asadmin start-domain -v --postbootcommandfile mycommands.asadmin ${PAYARA_DOMAIN}

