
package texteditor;

public class Lexer {
   
    private final int N=(int)1e7+9;
    private final SourceFile sourceFile;
    
    private char currentChar;
    private char[] currentSpelling;
    
    private int divStart;        // Used on the special case when token is comment
    private int divFinish;      
    private int idx;             //for accessing array of char
    
    private boolean currentlyScanningToken;
    public Lexer(SourceFile source)
    {
        currentSpelling=null;
        idx=0;
        sourceFile=source;
        currentChar = sourceFile.getSource();
    }
    private void Getnext()
    {
        if(currentlyScanningToken) {
            currentSpelling[idx++]=currentChar;
        }
        currentChar = sourceFile.getSource();
    }
    private boolean IsChar(char x)
    {
        return (x>='A' && x<='Z')||(x>='a'&&x<='z');
    }
    private boolean IsDigit(char x)
    {
        return (x>='0' && x<='9');
    }
    private boolean IsSymbol(char x)
    {
        System.out.println((int)x);
        switch(x)
        {
            case '>': case '<':
            case '=': case '&':
            case '|': case '!':
            case '+': case '-':
            case '*': case '/':
            case '.': case ',':
            case ';':case '(':
            case ')':case '[':
            case ']':case '{':
            case '}':case '\n':
            case '^':case ' ':                                                                                                                                                                                                                                                                                                                                                                                   
            case '\t':case'\r':
            case '\u0000':
                return false;
            default :
            return true;
        }
            
    }
    private int scanToken() {
        switch(currentChar)
        {
             //[A-Za-z][A-Za-z0-9_]*
            case 'a':  case 'b':  case 'c':  case 'd':  case 'e':
            case 'f':  case 'g':  case 'h':  case 'i':  case 'j':
            case 'k':  case 'l':  case 'm':  case 'n':  case 'o':
            case 'p':  case 'q':  case 'r':  case 's':  case 't':
            case 'u':  case 'v':  case 'w':  case 'x':  case 'y':
            case 'z':
            case 'A':  case 'B':  case 'C':  case 'D':  case 'E':
            case 'F':  case 'G':  case 'H':  case 'I':  case 'J':
            case 'K':  case 'L':  case 'M':  case 'N':  case 'O':
            case 'P':  case 'Q':  case 'R':  case 'S':  case 'T':
            case 'U':  case 'V':  case 'W':  case 'X':  case 'Y':
            case 'Z':
                
                Getnext();
                while(IsChar(currentChar)||IsDigit(currentChar)||currentChar=='_') Getnext();
                if(IsSymbol(currentChar)) return Token.ERROR;
                return Token.IDENTIFIER;   
                
                
            //[1-9][0-9]*
            case '1':  case '2':  case '3':  case '4':  case '5':
            case '6':  case '7':  case '8':  case '9':  
                
                Getnext();
                while(IsDigit(currentChar)) Getnext();
                if(IsChar(currentChar)||IsSymbol(currentChar)) return Token.ERROR;
                return Token.INTLITERAL;
                
            //Operators
            case '>':
            Getnext();
            if(currentChar == '=') {
                Getnext();
                return Token.GEQUAL;
            }
            return Token.GREATER;

            case '<':
            Getnext();
            if(currentChar == '=') {
                Getnext();
                return Token.LEQUAL;
            }
            return Token.LESS;

            case '=':
            Getnext();
            if(currentChar == '=') {
                Getnext();
                return Token.EQUAL;
            }
            return Token.ASSIGN;

            case '&':
            Getnext();
            if(currentChar != '&') {
                System.exit(4);
            }
            Getnext();
            return Token.AND;

            case '|':
            Getnext();
            if(currentChar != '|')
                System.exit(4);
            Getnext();
            return Token.OR;

            case '!':
            Getnext();
            if(currentChar == '=') {
                Getnext();
                return Token.NOTEQUAL;
            }
            return Token.NOT;

            case '+':
            Getnext();
            return Token.PLUS;

            case '-':
            Getnext();
            return Token.MINUS;

            case '*':
            Getnext();
            return Token.TIMES;

            case '/':
            Getnext();
            return Token.DIV;

            case '.':
            Getnext();
            return Token.DOT;

            case ',':
            Getnext();
            return Token.COMMA;

            case ';':
            Getnext();
            return Token.SEMICOLON;

            case '(':
            Getnext();
            return Token.LPAREN;

            case ')':
            Getnext();
            return Token.RPAREN;

            case '[':
            Getnext();
            return Token.LBRACKET;

            case ']':
            Getnext();
            return Token.RBRACKET;

            case '{':
            Getnext();
            return Token.LCURLY;

            case '}':
            Getnext();
            return Token.RCURLY;   
            
            case '\n':
                Getnext();
            return Token.EOL;
            
            case '^':
                Getnext();
            return Token.EOL;  
            
            case '\u0000':

            return Token.EOT;
            
                
            default:
            Getnext();
            return Token.ERROR;

        }

    }
    
    // scanSeparator skips a single separator.
    private boolean ScanSeparator() {
        switch(currentChar) {
        case '-':
            divStart = sourceFile.getCurrentLine();
            Getnext();
            divFinish = sourceFile.getCurrentLine();
            if(currentChar == '-') singleLineComment();
            else return true;  // is minus operator
            break;
        case'#':
            divStart=sourceFile.getCurrentLine();
            Getnext();
            divFinish=sourceFile.getCurrentLine();
            if(currentChar == '*') multiLineComment();
            else return true;  // is hash operator
            break;
        case ' ': case '\n': case '\r': case '\t':
            Getnext();
            break;
        }
        return false;
    }

    private void singleLineComment() {
        while(currentChar != '\n'&& currentChar != '\r'&&currentChar != SourceFile.eot) Getnext();
        Getnext();
    }

    private void multiLineComment() {
        currentChar = sourceFile.getSource();
        char nextChar = sourceFile.getSource();
        
        while(currentChar != '*' || nextChar != '#') {
            if(currentChar == SourceFile.eot) {
                System.exit(4);
            }
            currentChar = nextChar;
            nextChar = sourceFile.getSource();
        }
        currentChar = sourceFile.getSource();
    }
    public Token Scan() {
        
        Token tok;
        SourcePosition pos;
        int kind;

        boolean notcom;

        currentlyScanningToken = false;                    
        while(currentChar == '-'|| currentChar == ' '|| currentChar == '\n'|| currentChar == '\r'||currentChar == '\t') 
        {
            notcom = ScanSeparator();
            if(notcom) {
                pos = new SourcePosition();
                pos.start = divStart;
                pos.finish = divFinish;
                tok = new Token(Token.MINUS,new char[]{'-'},1,pos);
                return tok;
            }
        }
        while(currentChar == '#'|| currentChar == ' '|| currentChar == '\n'|| currentChar == '\r'||currentChar == '\t') 
        {
            notcom = ScanSeparator();
            if(notcom) {
                pos = new SourcePosition();
                pos.start = divStart;
                pos.finish = divFinish;
                tok = new Token(Token.Hash,new char[]{'#'},1,pos);
                return tok;
            }
        } 

        currentlyScanningToken = true;
        idx=0;
        currentSpelling = new char[N];
        pos = new SourcePosition();
        pos.start = sourceFile.getCurrentLine();

        kind = scanToken();

        pos.finish = sourceFile.getCurrentLine();
        tok = new Token(kind,currentSpelling,idx,pos);

        return tok;
    }
    
}
