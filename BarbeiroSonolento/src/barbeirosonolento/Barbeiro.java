
package barbeirosonolento;

import java.util.Random;

/**
 *
 * @author jeyza
 */
public class Barbeiro implements Runnable {
    private String nome;
    private int cadeiraEspera;
    private int clientesNovos;
    int[] clientes;
    int numeroClientes = 0;
    boolean cadeiraOcupada = false;
    boolean barbeiroDorme = false;
    
   
   


    Barbeiro (String nome, int cadeiraEspera, int clientes) {
	clientesNovos = clientes;
	this.nome = nome;
	this.cadeiraEspera = cadeiraEspera;
	System.out.println("O barbeiro "+ nome + " está na barbearia");
}

    public void Clientes() {
	Random r = new Random();
	numeroClientes = r.nextInt(clientesNovos);
	clientes = new int[numeroClientes];

	for (int i = 0; numeroClientes < clientes.length; i++) {
            clientes[i] = i;
	}
    }    

    public void BarbeiroDorme() throws InterruptedException {
	System.out.println("Não existem clientes na barbearia do Barbeiro " + nome);
	System.out.println("O Barbeiro "+ nome+ " está dormindo");
            Thread.sleep(2000);
            System.out.println("A cadeira do Barbeiro "+ nome+ " está livre. ");
            Clientes();
}

    public void BarbeiroAtende() throws InterruptedException {
	if (numeroClientes != 0) {
		if (numeroClientes > 1 && cadeiraOcupada == false){
			System.out.println("Entrou " + numeroClientes + " cliente na barbearia");
		} else {
			System.out.println("Existe " + numeroClientes + " cliente esperando atendimento " + nome);
		}
		System.out.println("Um cliente ocupou a cadeira do barbeiro " + nome);
		numeroClientes--;
		System.out.println("O cliente está sendo atendido pelo Barbeiro " + nome);
		cadeiraOcupada = true;

	 	Thread.sleep(1000);
        
	if (numeroClientes > cadeiraEspera) {
		int cli = numeroClientes - cadeiraEspera;
		numeroClientes = numeroClientes - cli;
		for (int i = 0; i < clientes.length; i++) {
			clientes[i]= 0;
		}
		for (int j = 0; j < numeroClientes; j++) {
			clientes[j]= j + 1;
		}
		System.out.println( cli + "clientes foram embora");
		System.out.println(numeroClientes + "clientes estão esperando.");
	}
	System.out.println ("O cliente já foi atendido pelo Barbeiro "+ nome);


	} else if (numeroClientes == 1) {
		System.out.println("A cadeira do Barbeiro " + nome + "está livre.");
		System.out.println("A cadeira do Barbeiro" + nome + " está ocupada, não tem clientes esperando.");
		Thread.sleep(1000);
		numeroClientes--;

		System.out.println("Um cliente já foi atendido pelo Barbeiro " + nome);



	} else {
		System.out.println("A cadeira do Barbeiro " + nome + "está livre.");
		cadeiraOcupada = false;
	}
}

	@Override
	public void run() {
		while (true) {
			if (numeroClientes <=0) {
				try {
					BarbeiroDorme();
				} catch (InterruptedException ex) {
					System.out.println(ex);
				}


	}else{
		try{
			BarbeiroAtende();
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
              }
        }
    }
}

    

