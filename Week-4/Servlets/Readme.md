# Tomcat

Tomcat is a server that serves http responses to http requests sent to it. It also serves another functionality as a servlet container. As a servlet container it's in charge of creating servlet objects meant to handle requests.

## Getting tomcat to work

To get a working webapp you need to configure a tomcat server. The version we'll be using is tomcat 8.5.

**?** Why this specific version???

**A** Because it's the version compatible with our JDK and servlet API version.

To get tomcat to work with our webapp we need to download the zip and extract it.

[Tomcat 8.5 zip](https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.82/bin/apache-tomcat-8.5.82.zip)

To add tomcat as a server:

1. In sts under the file tab select New>Other
2. In the wizard type out Server
3. Expand the server folder and select the server
4. In defining a new server, select Apache and tomcat 8.5 under the apache folder
5. Set the installation file path to be where you extracted the tomcat zip you downloaded, make sure the folder you select is the direct parent of the bin folder
6. Click finish

Configuring your tomcat server:

1. In the server section of your project explorer, right click the server folder you want to configure
2. Select run as> run configurations
3. In the run configuration select Apache
4. Right click apache and add a new configuration
5. IN the new configuration, go to your classpath tab
6. Select user entries
7. Select add external jars
8. Add the boostrap and tomcat juli jar files from the bin folder of your extracted tomcat zip
9. Go to the environment tab, add CATALINA_HOME variable and set the value to be the filepath to the bin folder of your extracted tomcat zip
10. Remove the C: in the beginning of the filepath (tomcat uses : as a delimeter and not removing it in your filepath would result to an error)
11. Click on apply

Running your tomcat server:

1. Go under the window tab of your sts
2. Select show view>other
3. Search for servers
4. Expand the server folder and select the server view and click open
5. In the server view, click on the tomcat server and the play button
