package GUI;

import CodeFiles.Compress;
import CodeFiles.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class View extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;

    View(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        compressButton = new JButton("Select File to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 100, 200, 30);

        decompressButton = new JButton("Select File to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250, 100, 200, 30);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.BLACK);

        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){

        int function =-1;

        long original_Size_compress = 0;
        long original_Size_decompress = 0;
        long compress_Size = 0;
        long decompress_Size = 0;
        if(e.getSource() == compressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int responce  = fileChooser.showSaveDialog(null);

            if(responce == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                original_Size_compress = file.length();
                try
                {
                    Compress.method(file);
                    compress_Size = Compress.size(file);
                    function =1;
                }
                catch(Exception excp)
                {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        if(e.getSource() == decompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int responce  = fileChooser.showSaveDialog(null);

            if(responce == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                original_Size_decompress = file.length();
                try
                {
                    Decompress.method(file);
                    decompress_Size = Decompress.size(file);
                    function =0;
                }
                catch(Exception excp)
                {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        switch (function) {
            case 1 -> JOptionPane.showMessageDialog(this, "Compression of "+original_Size_compress+" KB file to "+compress_Size+" KB ZIP file is Completed " , "Information", JOptionPane.PLAIN_MESSAGE);
            case 0 -> JOptionPane.showMessageDialog(this, "Decompression of "+original_Size_decompress+" KB ZIP file to "+decompress_Size+" KB file is Completed ", "Information", JOptionPane.PLAIN_MESSAGE);
            default -> JOptionPane.showMessageDialog(this, "No File Selected", "Conformation", JOptionPane.PLAIN_MESSAGE);
        }
    }
    public static void main(String [] args){
        View view = new View();
        view.setVisible(true);
    }
}
