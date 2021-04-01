
package barbeirosonolento;

/**
 *
 * @author jeyza
 */
public class BarbeiroSonolento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Barbeiro barbeiro = new Barbeiro("Pedro",3,6);
                
                
        Thread threadBarbeiro1 = new Thread(barbeiro);

        threadBarbeiro1.start();
    }
    
}
