# Online Chat Application  

This project demonstrates the use of socket programming, client-server communication, and text-based user interface design in creating a simple online chat application using Java.  

---

## Features  

1. **Server**:  
   - Manages multiple client connections.  
   - Assigns unique user IDs to connected clients.  
   - Broadcasts messages to all connected clients.  

2. **Client**:  
   - Connects to the server.  
   - Sends messages to the server for broadcasting.  
   - Receives messages from other clients.  

3. **User Interface**:  
   - Simple text-based interface for message input and display.  

---

## How to Run the Application  

### Prerequisites  
- Java JDK installed on your machine.  
- Terminal or command prompt for running the application.  

### Steps  

1. **Compile the Java Files**:  
   Navigate to the `src` directory and compile the files using:  
   ```bash
   javac ChatServer.java ChatClient.java

	2.	Start the Server:
Run the server to accept client connections:

java ChatServer


	3.	Start the Client:
Open another terminal and run the client. You can start multiple clients:

java ChatClient


	4.	Chat:
	•	Type messages in the client terminal.
	•	Messages will be sent to the server and broadcasted to all connected clients.

Folder Structure

ChatApplication/
├── src/
│   ├── ChatServer.java      # Server implementation
│   ├── ChatClient.java      # Client implementation
├── README.md                # Documentation
├── screenshots/             # Output screenshots
│   ├── server_console.png   # Screenshot of server console
│   ├── client_console.png   # Screenshot of client console

Screenshots

Server Console

Client Console

Future Improvements
	•	Add a GUI for better user experience.
	•	Implement message encryption for enhanced security.
	•	Add user authentication and login system.

