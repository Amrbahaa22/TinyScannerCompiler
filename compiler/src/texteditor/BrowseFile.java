
package texteditor;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

/*
 * FileChooserDemo.java uses these files:
 *   images/Open16.gif
 *   images/Save16.gif
 */
public class BrowseFile extends javax.swing.JFrame {
    static private final String newline = "\n";
    JButton openButton;
    JTextArea log;
    JFileChooser fc;
    public BrowseFile()
    {
         createAndShowGUI();
    }
    private void createAndShowGUI() {
        
        
        this.setPreferredSize(new Dimension(500,500));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);

        
        fc = new JFileChooser();

        
        openButton = new JButton("Open a File...");
                                 
        openButton.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(logScrollPane, BorderLayout.CENTER);
        this.pack();
    }
    
    public void openActionPerformed(ActionEvent e) {

        
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(BrowseFile.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                
                log.append("Opening: " + file.getName() + "." + newline);
                if(scanProgram(file.getPath())) JOptionPane.showMessageDialog(null,"Scanned Successfully","Scanning",JOptionPane.INFORMATION_MESSAGE);
            } else {
                log.append("Open command cancelled by user." + newline);
            }
            log.setCaretPosition(log.getDocument().getLength());
            
        //Handle save button action.
        }
    }
    
     public boolean scanProgram(String file) {
       SourceFile source = new SourceFile(file);
       Lexer scanner=new Lexer(source);
       while(true)
        {
            Token x = scanner.Scan();
            if(x.kind==Token.EOT) return true;
            String tok=new String(x.spell(x.kind));
            String val=new String();
            val="";
            for(int i=0;i<x.len;++i) val+=x.spelling[i];
            if(x.kind==Token.ERROR)
            {
                JOptionPane.showMessageDialog(null,"Error at line "+x.position.start,"Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else if(x.kind==Token.USING)
            {
               String path=new String("C:\\Users\\amr-bahaa\\Desktop\\compiler\\");
               System.out.println("Token is "+tok);
               x=scanner.Scan();
               StringBuilder filename=new StringBuilder();
               for(int i=0;i<x.len;++i) filename.append(x.spelling[i]);
               path+=filename.toString().trim();
               path+=".txt";
               System.out.println(path);

               if(scanProgram(path.toString())==false) return false;
            }
            else System.out.println("Token it "+tok+" Val is "+val);
            
            
            
        }
    }

    public static void main(String[] args) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BrowseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowseFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                new BrowseFile().setVisible(true);
            }
        });
    }
}
