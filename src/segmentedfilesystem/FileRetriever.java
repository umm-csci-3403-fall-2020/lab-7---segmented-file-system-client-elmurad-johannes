package segmentedfilesystem;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class FileRetriever {

        private String server;
        private int port;

        public FileRetriever(String server, int port) {
                // Save the server and port for use in `downloadFiles()`
                this.server = server;
                this.port = port;

        }

        public void downloadFiles() throws IOException {
                // Do all the heavy lifting here.
                // This should
                // * Connect to the server
                // * Download packets in some sort of loop
                // * Handle the packets as they come in by, e.g.,
                // handing them to some PacketManager class
                // Your loop will need to be able to ask someone
                // if you've received all the packets, and can thus
                // terminate. You might have a method like
                // PacketManager.allPacketsReceived() that you could
                // call for that, but there are a bunch of possible
                // ways.
                byte[] data = new byte[256];
                InetAddress address = InetAddress.getByName(server);
                DatagramPacket requestFiles = new DatagramPacket(data, data.length, address, port);
                DatagramSocket socket = new DatagramSocket();
                socket.send(requestFiles);
     
	}

}
