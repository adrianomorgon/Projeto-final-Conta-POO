package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		
		long numConta = 111;
		int codigoCliente = 1;
		int opc = 0;
		Cliente temp = null;
		
		while(opc != 6) {
			System.out.println("MENU");
			System.out.println("1 Cadastrar Cliente");
			System.out.println("2 Cadastrar Conta");
			System.out.println("3 Depositar");
			System.out.println("4 Sacar");
			System.out.println("5 Listar");
			System.out.println("6 Sair");
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite sua opcao");
			opc = sc.nextInt();
			
			switch(opc) {
			case 1:
				System.out.println();
				System.out.println("Digite nome do cliente: ");
				String nome = sc.next();
				clientes.add(new Cliente(codigoCliente, nome));
				codigoCliente++;
				System.out.println("Cliente cadastrado com sucesso!");
				System.out.println();
				break;
			case 2:
				if(clientes == null) {
					System.out.println();
					System.out.println("Cadastre um cliente para poder cadastrar uma conta!");
					break;
				}
				System.out.println();
				System.out.println("Digite qual cliente deseja cadastrar uma conta: ");
				for(Cliente cliente : clientes) {
					System.out.println(cliente.getIdCliente() + ". " + cliente.getNomeCliente());
				}
				int opcCliente = sc.nextInt();
				for (Cliente cliente : clientes) {
					if (opcCliente == cliente.getIdCliente()) {
						temp = cliente;
					}
				}
				contas.add(new Conta(numConta, temp));
				System.out.println("Conta criada com sucesso!");
				numConta++;
				System.out.println();
				break;
			case 3:
				System.out.println();
				for(Cliente cliente : clientes) {
					System.out.println(cliente.toString());
					for (Conta conta : contas) {
						if (conta.getCliente() == cliente) {
							System.out.println("	" + conta.toString());
						}
					}
				}
				System.out.println("Digite o id da conta que deseja depositar");
				long id = sc.nextInt();
				for (Conta conta : contas) {
					if (id == conta.getNumeroConta()) {
						System.out.println("Digite o valor do deposito");
						double valor = sc.nextDouble();
						conta.depositar(valor);
					}
				}
				System.out.println();
				break;
			case 4:
				System.out.println();
				for(Cliente cliente : clientes) {
					System.out.println(cliente.toString());
					for (Conta conta : contas) {
						if (conta.getCliente() == cliente) {
							System.out.println("	" + conta.toString());
						}
					}
				}
				System.out.println("Digite o id da conta que deseja sacar");
				id = sc.nextInt();
				for (Conta conta : contas) {
					if (id == conta.getNumeroConta()) {
						System.out.println("Digite o valor do saque");
						double valor = sc.nextDouble();
						conta.sacar(valor);
					}
				}
				System.out.println();
				break;
			case 5:
				System.out.println();
				for(Cliente cliente : clientes) {
					System.out.println(cliente.toString());
					for (Conta conta : contas) {
						if (conta.getCliente() == cliente) {
							System.out.println("	" + conta.toString());
						}
					}
				}
				System.out.println();
				break;
			case 6:
				System.out.println();
				System.out.println("Programa finalizado");
				break;
			default:
				System.out.println();
				System.out.println("Opcao invalida!");
			}
		}
	}
	
}
