# From instruction is used to download whatever dependencies our application needs
# In this case, we need tomcat and JRE to run our Java Servlet Application
from tomcat:8.0-jre8

# Copy instruction is used to copy whatever is actually on your computer and paste it into the image
copy /target/rest.war /usr/local/tomcat/webapps

# expose instruction will determine what port this container will open to
expose 8080

# CMD instruction gives docker the default way of how to execute this image
# Tomcat documentation mentions to use catalina.sh to run this specific app
CMD ["catalina.sh", "run"]