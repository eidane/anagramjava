package case_oppgave_utvikler;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author eivin
 */
class TextOutput extends JFrame
{
    private JTextArea output;
    public TextOutput()
    {
        super("Anagramer");
        output=new JTextArea();
        add(new JScrollPane(output));
        pack();
        setVisible(true);
    }
    public void addData( String e )
    {
        output.append(e);
    }
}
