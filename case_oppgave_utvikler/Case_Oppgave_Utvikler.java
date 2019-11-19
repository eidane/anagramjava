package case_oppgave_utvikler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author eivind
 */



public class Case_Oppgave_Utvikler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //innfo for user
        JOptionPane.showMessageDialog(null,"Hei først velger man tekst fil (ett ord per linje som beskrevet).");
        //choose the file
        JFileChooser fileselector = new JFileChooser();
        fileselector.setCurrentDirectory( new File( "." ) );//start from current dir
        int resultat = fileselector.showOpenDialog( fileselector );
        File file = fileselector.getSelectedFile();//get the file into file format
        //System.out.println(file);
        //file might still not be found so try to do so now
        try {
            Controller program = new Controller(file.getPath()); //start the prosess
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Case_Oppgave_Utvikler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Outputwindow window=new Outputwindow(text);         
    }
}
