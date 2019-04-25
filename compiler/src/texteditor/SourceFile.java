/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;




public class SourceFile {
    private java.io.File sourceFile;
    private java.io.FileInputStream source;
    
    private int currentLine;
    public static final char eol = '\n';
    public static final char eol2 = '^';
    public static final char eot = '\u0000';
   
    public SourceFile(String filename)
    {
         try {
            sourceFile = new File(filename);
            source     = new FileInputStream(sourceFile);
            currentLine = 1;
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
            sourceFile = null;
            source = null;
            currentLine = 0;

        }
    }
    char getSource() {
        try {
            int c = source.read();

            if (c == -1) {
                c = eot;
            } else if (c == eol) {
                currentLine++;
            }
            return (char) c;
        }
        catch (java.io.IOException s) {
            System.err.println(s);
            return eot;
        }
    }
    int getCurrentLine() {
        return currentLine;
    }       
}
