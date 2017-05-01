/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensordatavirtualisation;

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author mikemarshall
 */
public class SensorDataVirtualisation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // A Swing component for file request dialog
        JFileChooser source=new JFileChooser();
        
        // Use FilenameExtensionFilter to limit what files we want to get (by file extension)
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Files", "csv");
        source.setFileFilter(filter);
        
        // Ask for a file, and check if the user actually selected one
        if (source.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            // Get the file the user selected
            File selectedFile = source.getSelectedFile();
            // System.out.println(selectedFile.getName());
            
            // Open the selected file
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            
            String text = null;
            
            try {
                // Read each line of text
                while ((text = reader.readLine()) != null)
                {
                    int errorFound = 0;
                    
                    Scanner scanner = new Scanner(text).useDelimiter(",");
                    while(scanner.hasNext())
                    {
                        System.out.println(text);
                        System.out.println("Test 1");
                        int time = Integer.parseInt(scanner.next().trim());
                        System.out.println("Test 2");
                        // Check for number of missed messages
                        // TODO
                        
                        // Check the device type is 0x20
                        int deviceType = scanner.nextByte();
                        System.out.println("Test 3");
                        if (deviceType != 0x20)
                        {
                            System.out.println("Invalid Device Type"); 
                            errorFound = 1;
                        }
                        System.out.println("Test 4");
                        
                        int deviceSoftwareVersion = scanner.nextByte(16);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(SensorDataVirtualisation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Draw Graph
            GraphComponent theGraph = new GraphComponent();
            
            
            
        }
        else
        {
            // Otherwise, complain that hte user didn't choose a file
            System.out.println("No file selected");
        }
        
        // Draw Graph
        JFrame frame = new JFrame("SensorDataVisualisation");
        frame.getContentPane().add(new GraphComponent(), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
       
    }
    
}
