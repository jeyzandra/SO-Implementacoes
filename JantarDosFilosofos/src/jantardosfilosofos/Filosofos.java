
package jantardosfilosofos;

import java.util.Random; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jeyza
 */
public class Filosofos {
    
    public class Garfos extends Thread {
        
        private final int garfoEsquerda;
        private final int garfoDireita;
        
        public Garfos(int garfoEsquerda, int garfoDireita) {
            this.garfoEsquerda = garfoEsquerda;
            this.garfoDireita = garfoDireita;
        }
        
        @Override
        public void run() {
            while (true) {
                try {
                    sorteioDireita();
                    sorteioEsquerda();
                    Thread.sleep(1000);
                    
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
            }
        }
        
        public void sorteioDireita() {
            int garfoDireita;
            Random d = new Random();
            garfoDireita = d.nextInt(5);
            
            System.out.println("Garfo da direita sorteado " + garfoDireita);
        }
        
        public void sorteioEsquerda() {
            int garfoEsquerda;
            Random e = new Random();
            garfoEsquerda = e.nextInt(5);
            
            System.out.println("Garfo da esquerda sorteado " + garfoEsquerda);
        }    
    }
    
    public class Filosofo extends Thread {
        
        String nome;
        Garfos garfo;
        int cantoNaMesa;
      
        
        public Filosofo(String nome, Garfos garfo, int cantoNaMesa) {
            this.nome = nome;
            this.garfo = garfo;
            this.cantoNaMesa = cantoNaMesa;
          
            
            System.out.println(" O " + nome + " sentou na  mesa");
        }

        
        
        public void Pensar() throws InterruptedException {
            System.out.println(" " + nome + " ta pensando");
            Thread.sleep(1000);
        }
        
        @Override
        public void run() {
            
            while (true) {
                
                if(garfo.garfoDireita == 5){
                    System.out.println("O " + nome + " pegou o garfo " + garfo.garfoDireita);
                    if (garfo.garfoEsquerda == 1) {
                        System.out.println("O " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                        System.out.println(" " + nome + " ta comendo");
                        System.out.println("O " + nome + " soltou o garfo da direita");
                        System.out.println("O " + nome + " soltou o gardo da esquerda");
                    } else {
                        System.out.println("O " + nome + "soltou o garfo" + garfo.garfoDireita);
                    }
                } else {
                
                        try {
                            Pensar ();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                }
           
                    if (garfo.garfoDireita == 1) {
                        
                        System.out.println("O " + nome + " pegou o garfo " + garfo.garfoDireita);
                        if (garfo.garfoEsquerda == 2) {
                            
                            System.out.println("O " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                            System.out.println(" " + nome + " ta comendo");
                            System.out.println("O " + nome + " soltou o garfo da direita");
                            System.out.println("O " + nome + " soltou o garfo da esquerda");
                        } else {
                            System.out.println("O " + nome + " soltou o garfo " + garfo.garfoDireita);
                        }
                    } else {
                        try {
                            Pensar();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                    
                    if (garfo.garfoDireita == 2) {
                        
                        System.out.println("O " + nome + " pegou o garfo " + garfo.garfoDireita);
                        if (garfo.garfoEsquerda == 3) {
                            
                            System.out.println("O " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                            System.out.println(" " + nome + " ta comendo");
                            System.out.println("O " + nome + " soltou o garfo da direita");
                            System.out.println("O " + nome + " soltou o garfo da esquerda");
                        } else {
                            System.out.println("O " + nome + " soltou o garfo " + garfo.garfoDireita);
                        }    
                    } else {
                        try {
                            Pensar();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                    if (garfo.garfoDireita == 3) {
                        
                        System.out.println("O " + nome + " pegou o garfo " + garfo.garfoDireita);
                        if (garfo.garfoEsquerda == 4) {
                            
                            System.out.println("O " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                            System.out.println(" " + nome + " ta comendo");
                            System.out.println("O " + nome + " soltou o garfo da direita");
                            System.out.println("O " + nome + " soltou o garfo da esquerda");
                        } else {
                            System.out.println("O " + nome + " soltou o garfo " + garfo.garfoDireita);
                        }    
                    } else {
                        try {
                            Pensar();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                    
                    if (garfo.garfoDireita == 4) {
                        
                        System.out.println("O " + nome + " pegou o garfo " + garfo.garfoDireita);
                        if (garfo.garfoEsquerda == 5) {
                            
                            System.out.println("O " + nome + " pegou o garfo " + garfo.garfoEsquerda);
                            System.out.println(" " + nome + " ta comendo");
                            System.out.println("O " + nome + " soltou o garfo da direita");
                            System.out.println("O " + nome + " soltou o garfo da esquerda");
                        } else {
                            System.out.println("O " + nome + " soltou o garfo " + garfo.garfoDireita);
                        }    
                    } else {
                        try {
                            Pensar();
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                    }
                }
            }
            
        }
    
    
    public void test() {
        
        Garfos g1 = new Garfos(1, 5);
        Garfos g2 = new Garfos(2, 1);
        Garfos g3 = new Garfos(3, 2);
        Garfos g4 = new Garfos(4, 3);
        Garfos g5 = new Garfos(5, 4);
        
        
        Filosofo filosofo1 = new Filosofo("filosofo 1", g1, 1);
        Filosofo filosofo2 = new Filosofo("filosofo 2 ", g2, 2);
        Filosofo filosofo3 = new Filosofo("filosofo 3 ", g3, 3);
        Filosofo filosofo4 = new Filosofo("filosofo 4 ", g4, 4);
        Filosofo filosofo5 = new Filosofo("filosofo 5 ", g5, 5);
        
        
        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
    }
    
}
