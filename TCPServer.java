import java.io.*;
import java.net.*;

class TCPServer {

	public static void main(String argv[]) throws Exception {
		String clientSentence;
		String capitalizedSentence;

		ServerSocket welcomeSocket = new ServerSocket(6789);   //Create socket

		while(true) {
			Socket connectionSocket = welcomeSocket.accept();   //Accept from socket

			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));  //get input from client
			clientSentence = inFromClient.readLine();

			System.out.println("Recieved: " + clientSentence);
			capitalizedSentence = clientSentence.toUpperCase() + '\n';

			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());   // send result to client
			outToClient.writeBytes(capitalizedSentence);

			connectionSocket.close();
		}
	}
}