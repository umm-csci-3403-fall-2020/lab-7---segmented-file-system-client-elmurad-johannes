package segmentedfilesystem;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
// import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;

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
                byte[] initialPacketContent = new byte[256];
                InetAddress address = InetAddress.getByName(server);
                DatagramPacket requestFiles = new DatagramPacket(initialPacketContent, initialPacketContent.length, address, port);
                DatagramSocket socket = new DatagramSocket();
                socket.send(requestFiles);

                // Start receiving packets

                ArrayList<DatagramPacket> files = new ArrayList<>();


                HashMap<Integer, ArrayList<DatagramPacket>> map = new HashMap<>();

                // While the server is sending packets, make a new packet and receive that packet.
                while(!isDone()) {
                        System.out.println("Receiving new packet");
                        // Keep enough space for the data section (up to 1024 bytes) and the description (up to 4 bytes)
                        byte[] packetContents = new byte[1028]; 
                        DatagramPacket packet = new DatagramPacket(packetContents, packetContents.length);
                        socket.receive(packet);
                        
                        // addToMap(packet, map);
                }
                // writeToFile(map); 
                socket.close();
     
        }


//     public static void addToMap(DatagramPacket myPacket, HashMap<Integer, ArrayList<DatagramPacket>> map){
//         byte[] dataByte = myPacket.getData();
//         int fileID = dataByte[1];
// 	if (!myFileIDS.contains(fileID)) {
//             myFileIDS.add(fileID);
//         }
//         if(map.containsKey(fileID)) {
//             if(dataByte[0] % 2 == 0) {
//                 System.out.println("Found Header Packet");
//                 map.get(fileID).add(0, myPacket);
//             } else if (dataByte[0] % 4 == 3) {
//                 int counter = dataByte[2];
//                 count.add(counter);
//                 map.get(fileID).add(1, myPacket);
//             } else {
//                 map.get(fileID).add(myPacket);
//             }
//         } else {
//             ArrayList<DatagramPacket> myList = new ArrayList<>();
//             myList.add(myPacket);
//             map.put(fileID, myList);
//         }

//         if (dataByte[0] % 4 == 3) {
//             int counter = dataByte[2];
//             count.add(counter);
//         }

//        lastPackets();

}

