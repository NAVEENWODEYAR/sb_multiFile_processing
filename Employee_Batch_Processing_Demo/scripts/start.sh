#!/bin/bash

# Specify the path to the JAR file
JAR_PATH="/projects/Employee_Batch_Processing_Demo-1.0.jar"

# Specify the Spring profile to use
PROFILE="dev"

# Start the Java application in the background using nohup
# Redirect stdout and stderr to app.log
nohup java -jar "$JAR_PATH" --spring.profiles.active="$PROFILE" > /projects/app.log 2>&1 &

# Save the PID of the Java process to a file
echo $! > /projects/pid.file

# Print a message indicating the application has started
echo "Java application started with PID: $(cat /projects/pid.file)"
