package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String input = in.readLine();
                    String output = "What";
                    if (input.contains("msg=Hello")) {
                        output = "Hello";
                    } else if (input.contains("msg=Exit")) {
                        output = "The server closed";
                        server.close();
                    }
                    out.write((output + "\n").getBytes());
                    out.flush();
                }
            }
        }
    }
}