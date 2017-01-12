FROM registry.preview.openshift.com/td-demo/jboss-eap:6.4.0_8
ADD sample.api/target/sample.api-0.0.1-SNAPSHOT.war /opt/jboss/deployments/
