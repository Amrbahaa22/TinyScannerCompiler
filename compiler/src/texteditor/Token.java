/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.util.Arrays;

/**
 *
 * @author amr-bahaa
 */
final class Token {
    public int kind;
    public char[] spelling;
    public int len;
    public SourcePosition position;
    
    public Token(int kind,char[] spelling,int len, SourcePosition position) {
        this.kind = kind;
        this.spelling = spelling;
        this.position = position;
        this.len=len;
        if(kind == IDENTIFIER) {
            for(int k = firstReservedWord; k <= lastReservedWord; k++) 
            {
                boolean match=false;
                int    n=spellings[k].getLen();
                char[] x=spellings[k].getKey();
                if(n>len | n<len) continue;
                for(int i=0;i<n;++i)
                {
                    match=true;
                    if(spelling[i]!=x[i])
                    {
                        match=false;
                        break;
                    }
                }
                if(match)
                {
                    this.kind=k;
                    break;
                }
                
            }
        }
    }
    
    
    public static char[] spell(int kind) {
        return spellings[kind].getKey();
    }
    
    @Override
    public String toString() {
        return "Kind=" + kind + ", spelling=" + spelling +
        ", position=" + position;
    }     

    
    public static final int INTLITERAL = 0;
    public static final int IDENTIFIER = 1;
    public static final int OPERATOR   = 2;
        
    //key words
    public static final int CATEGORY = 3;
    public static final int DERIVE   = 4;
    public static final int TIK      = 5;
    public static final int FLIK     = 6;
    public static final int ILAP     = 7;
    public static final int SILAP    = 8;
    public static final int CLOP     = 9;
    public static final int SERIES   = 10;
    public static final int ILAPF    = 11;
    public static final int SILAPF   = 12;
    public static final int NONE     = 13;
    public static final int LOGICAL  = 14; 
    public static final int TERMINATETHIS =15;
    public static final int ROTATEWHEN =16;
    public static final int CONTINUEWHEN =17;
    public static final int REPLYWITH =18;
    public static final int SEOP = 19;
    public static final int CHECK =20;
    public static final int SITUATIONOF =21;
    public static final int PROGRAM =22;
    public static final int END =23;
    public static final int USING =24;
    
     // Operators
    public static final int GREATER    = 25;
    public static final int LESS       = 26;
    public static final int EQUAL      = 27;
    public static final int LEQUAL     = 28;
    public static final int GEQUAL     = 29;
    public static final int NOTEQUAL   = 30;
    public static final int AND        = 31;
    public static final int OR         = 32;
    public static final int NOT        = 33;
    public static final int PLUS       = 34;
    public static final int MINUS      = 35;
    public static final int TIMES      = 36;
    public static final int DIV        = 37;
    
    //Assign
    public static final int ASSIGN     = 38;
    
    // Punctuation
    public static final int DOT            = 39;
    public static final int COMMA          = 40;
    public static final int SEMICOLON      = 41;
    public static final int QUTATIONMARKS  = 42;
    public static final int QUTATIONMARK   = 43;
    // Brackets
    public static final int LPAREN     = 44;
    public static final int RPAREN     = 45;
    public static final int LBRACKET   = 46;
    public static final int RBRACKET   = 47;
    public static final int LCURLY     = 48;
    public static final int RCURLY     = 49;
    
    // Token classes

    
    // Special tokens
    public static final int EOT        = 50; // end of the input text
    public static final int EOL        = 51; // end of the line text
    public static final int ERROR      = 52;
    public static final int Hash       = 53;
    public static final int TRUE       = 54;
    public static final int FALSE      = 55;
    
    private static final pair[] spellings = {
       new pair(new char []{'<','c','o','n','s','t','>'},7 ),
       new pair(new char []{'<','i','d','e','n','t','i','f','i','e','r','>'},12),
       new pair(new char []{'<','o','p','e','r','a','t','o','r','>'},10),
       new pair(new char []{'C','a','t','e','g','o','r','y'},8),
       new pair(new char []{'D','e','r','i','v','e',},6),
       new pair(new char []{'T','i','k'},3),
       new pair(new char []{'F','l','i','k'},4),
       new pair(new char []{'I','l','a','p'},4),
       new pair(new char []{'S','i','l','a','p'},5),
       new pair(new char []{'C','l','o','p'},4),
       new pair(new char []{'S','e','r','i','e','s'},6),
       new pair(new char []{'I','l','a','p','f'},5),
       new pair(new char []{'S','i','l','a','p','f'},6),
       new pair(new char []{'N','o','n','e'},4),
       new pair(new char []{'L','o','g','i','c','a','l'},7),
       new pair(new char []{'t','e','r','m','i','n','a','t','e','t','h','i','s'},11),
       new pair(new char []{'R','o','t','a','t','e','w','h','e','n'},10),
       new pair(new char []{'C','o','n','t','i','n','u','e','w','h','e','n'},12),
       new pair(new char []{'R','e','p','l','y','w','i','t','h'},9),
       new pair(new char []{'S','e','o','p'},4),
       new pair(new char []{'C','h','e','c','k'},5),
       new pair(new char []{'s','i','t','u','a','t','i','o','n','o','f'},11),
       new pair(new char []{'P','r','o','g','r','a','m'},7),
       new pair(new char []{'E','n','d'},3),
       new pair(new char []{'U','s','i','n','g'},5),
       new pair(new char []{'>'},1),
       new pair(new char []{'<'},1),
       new pair(new char []{'=','='},2), 
       new pair(new char []{'<','='},2), 
       new pair(new char []{'>','='},2), 
       new pair(new char []{'!','='},2),
       new pair(new char []{'&','&'},2),
       new pair(new char []{'|','|'},2),
       new pair(new char []{'!'},1),
       new pair(new char []{'+'},1),
       new pair(new char []{'-'},1), 
       new pair(new char []{'*'},1),
       new pair(new char []{'/'},1),
       new pair(new char []{'='},1),
       new pair(new char []{'.'},1),
       new pair(new char []{','},1),
       new pair(new char []{';'},1),
       new pair(new char []{'\''},1),
       new pair(new char []{'\"'},1),
       new pair(new char []{'('},1), 
       new pair(new char []{')'},1),
       new pair(new char []{'['},1),
       new pair(new char []{']'},1),
       new pair(new char []{'{'},1),
       new pair(new char []{'}'},1),
       new pair(new char []{'^'},1),
       new pair(new char []{'\u0000'},0),
       new pair(new char []{'<','e','r','r','o','r','>'},7),
       new pair(new char[]{'#'},1),
       new pair(new char[]{'T','r','u','e'},4),
       new pair(new char[]{'F','a','l','s','e'},5),
   };
   private final static int firstReservedWord = Token.INTLITERAL;
   private final static int lastReservedWord  = Token.FALSE;
        
}
