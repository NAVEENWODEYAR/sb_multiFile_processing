#!/bin/bash

# Function to stop the Java application
stop_application() {
    # Check if the PID file exists
    if [ -f /projects/pid.file ]; then
        # Get the PID from the file
        PID=$(cat /projects/pid.file)

        # Check if the process is running
        if kill -0 "$PID" 2>/dev/null; then
            # Send the TERM signal to gracefully stop the process
            kill "$PID"
            echo "Java application with PID $PID has been stopped."
            # Optionally, remove the PID file after stopping
            rm -f /projects/pid.file
        else
            echo "Process with PID $PID is not running."
        fi
    else
        echo "PID file does not exist. Application may not be running."
    fi
}

# Call the stop function
stop_application
