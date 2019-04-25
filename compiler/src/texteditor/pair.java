/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

/**
 *
 * @author amr-bahaa
 */
public class pair {
    private char[] key;
    private int len;

    public pair(char[] key, int len) {
        this.key = key;
        this.len = len;
    }

    public char[] getKey() {
        return key;
    }

    public void setKey(char[] key) {
        this.key = key;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
    
}
