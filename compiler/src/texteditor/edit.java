
package texteditor;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import sun.reflect.generics.tree.Tree;

public class edit extends javax.swing.JFrame {
    Set<String>s;
    private final String path="C:\\Users\\amr-bahaa\\Desktop\\compiler\\editor.txt";
    private final int N=(int)(1e7)+9;
    private javax.swing.JPanel jPanel1,jPanel2,jstatic;;
    private javax.swing.JScrollPane jScrollPane1,jScrollPane2;
    private javax.swing.JTextPane jTextpane;  
    private javax.swing.GroupLayout jPanel1Layout;
    private GroupLayout.ParallelGroup parallel;
    private GroupLayout.SequentialGroup sequential;
    private javax.swing.JButton jcompile,jparsing,jscann;
    private javax.swing.JLabel jCol,jColNo,jRow,jRowNo;
    private static int i=1;
    private int row,col;
    private javax.swing.JLabel[] labs=new javax.swing.JLabel[N];
    public edit() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {  
        s=new TreeSet<String>();
        s.add("Category");
        s.add("Clop");
        s.add("Continuewhen");
        s.add("Check");
        s.add("Derive");
        s.add("Tik");
        s.add("terminatethis");
        s.add("Ilap");
        s.add("Ilapf");
        s.add("Silap");
        s.add("Silapf");
        s.add("Series");
        s.add("Seop");
        s.add("situationof");
        s.add("None");
        s.add("Logical");
        s.add("Rotatewhen");
        s.add("Replywith");
        s.add("Program");
        s.add("End");
        s.add("Using");
        s.add("Flik");
        
        this.setTitle("Editor");
        setResizable(false);
        this.setPreferredSize(new Dimension(500,500));
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextpane = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jstatic = new javax.swing.JPanel();
        jcompile= new javax.swing.JButton();
        jparsing= new javax.swing.JButton();
        jscann  = new javax.swing.JButton();
        jCol    = new javax.swing.JLabel();
        jRow    = new javax.swing.JLabel();
        jColNo  = new javax.swing.JLabel();
        jRowNo  = new javax.swing.JLabel();
        
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setAutoscrolls(true);

        //jTextpane.setColumns(20);
        //jTextpane.setRows(5);
        
        jTextpane.addCaretListener(new javax.swing.event.CaretListener() {
            @Override
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jTextpane.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextpane);

        jLabel1.setText("1");
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        
        jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
       
       labs[0]=jLabel1;
       parallel = jPanel1Layout.createParallelGroup();
       sequential = jPanel1Layout.createSequentialGroup();
       jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createSequentialGroup().addGroup(parallel
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sequential
                .addComponent(jLabel1)
                .addGap(0, 0,7))
        );
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel2);
        jRow.setText("Row");

        jRowNo.setText("0");

        jCol.setText("Col");

        jColNo.setText("0");

        jcompile.setText("Compile");
        jcompile.addActionListener(new java.awt.event.ActionListener(){
        public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcompileActionPerformed(evt);
            }
        });
        jparsing.setText("parsing");
            jparsing.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jparsingActionPerformed(evt);
            }
        });
        jscann.setText("scanner");
            jscann.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            jscannerActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jstaticLayout = new javax.swing.GroupLayout(jstatic);
        jstatic.setLayout(jstaticLayout);
        jstaticLayout.setHorizontalGroup(
            jstaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jstaticLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRow, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRowNo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCol, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jColNo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jscann)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jparsing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcompile)
                .addContainerGap())
        );
        jstaticLayout.setVerticalGroup(
            jstaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jstaticLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jstaticLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRow)
                    .addComponent(jRowNo)
                    .addComponent(jCol)
                    .addComponent(jColNo)
                    .addComponent(jcompile)
                    .addComponent(jparsing)
                    .addComponent(jscann))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addComponent(jstatic, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jstatic, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
        );
        
        pack();
    }// </editor-fold>                        

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {   
        int len=jTextpane.getText().split("\n").length+1;
        System.out.println("Len is "+String.valueOf(len)+" len of i "+i);
        while(i>len)
        {
            --i;
            jPanel1.remove(labs[i]);
            jPanel1.validate();
            jPanel1.repaint();
            labs[i]=null;
        }      
        if ((evt.getKeyCode() == KeyEvent.VK_SPACE) && ((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
                    System.out.println("woot!");
            }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER )
        {
            try
            {
                javax.swing.text.Element map = jTextpane.getDocument().getDefaultRootElement();
                javax.swing.text.Element lineElem = map.getElement(row);
                System.out.println(col);
                String line =jTextpane.getDocument().getText(0,lineElem.getEndOffset());
                System.out.println(line);
            }catch(BadLocationException e)
            {
               System.err.println(e);
            }
            javax.swing.JLabel x=new javax.swing.JLabel();
            x.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            x.setText(Integer.toString(i+1));
            labs[i++]=x;
            
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createSequentialGroup().addGroup(parallel
                            .addComponent(x, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sequential
                                    .addComponent(x)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGap(0,0,0))
            );
        }
    }
    private void jcompileActionPerformed(java.awt.event.ActionEvent evt) {                                         
       
    }
    private void jscannerActionPerformed(java.awt.event.ActionEvent evt) {
        for(int j=0;j<i;++j)labs[j].setForeground(Color.black);

        String text =jTextpane.getText();
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                
                writer.close();
            } catch (Exception e) {
            }
        }
        if(scanProgram(path)) JOptionPane.showMessageDialog(null,"Scanned Successfully","Scanning",JOptionPane.INFORMATION_MESSAGE);
        
    }
    public void colorerror(int row)
    {
        JOptionPane.showMessageDialog(null,"Error"+row,"Scanning",JOptionPane.ERROR_MESSAGE);
        labs[row-1].setForeground(Color.red);
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
                System.out.println(val);
                colorerror(x.position.start);
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
    private void jparsingActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {                                       
        int pos = jTextpane.getCaretPosition();
        javax.swing.text.Element map = jTextpane.getDocument().getDefaultRootElement();
        row = map.getElementIndex(pos);
        javax.swing.text.Element lineElem = map.getElement(row);
        col = pos - lineElem.getStartOffset();
        jRowNo.setText(Integer.toString(row));
        jColNo.setText(Integer.toString(col));
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new edit().setVisible(true);
            }
        });
    }



}
