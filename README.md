# Web-Server Implementation

This is a basic Java-based client-server communication project. It demonstrates how to use sockets for network communication, where the server listens for incoming client connections and sends responses.

------------------------------------------------------------------------------------------------------------------------------------------------------

## Features

- **Server:**

  - Listens for connections on a specified port.
  - Sends a welcome message to each connected client.
  - Reads messages from the client and logs them.

- **Client:**

  - Connects to the server on a specified port and IP address.
  - Sends a message to the server.
  - Receives and displays the server's response.

- **Server Implementations:**

  - **Single-Threaded:** Handles one client at a time.
  - **Multi-Threaded:** Creates a new thread for each client connection.
  - **Thread Pool:** Uses a fixed thread pool to handle multiple client connections efficiently.

------------------------------------------------------------------------------------------------------------------------------------------------------

## How It Works

1. **Server**:

   - The `Server` class initializes a `ServerSocket` on a specified port.
   - The server listens for client connections and accepts them.
   - Upon a successful connection, the server sends a message to the client.
   - The server can optionally read and log incoming messages from the client.

2. **Client**:

   - The `Client` class establishes a connection to the server using a `Socket`.
   - The client sends a message to the server and waits for a response.
   - It displays the server's response on the console.

------------------------------------------------------------------------------------------------------------------------------------------------------

## Performance Testing

- **JMeter:**
  - The server implementations (single-threaded, multi-threaded, and thread pool) were tested using JMeter to measure performance under various load           conditions.
------------------------------------------------------------------------------------------------------------------------------------------------------

## Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- Basic knowledge of Java I/O and Networking

------------------------------------------------------------------------------------------------------------------------------------------------------
