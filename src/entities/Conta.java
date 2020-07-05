package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Conta {
	private long numeroConta;
	private Cliente cliente;
	private double saldo;
	static String output = "C:\\Users\\adria\\eclipse-workspace\\Projeto-final2\\log.txt";
	
	public Conta(long numeroConta, Cliente cliente) {
		this.numeroConta = numeroConta;
		this.cliente = cliente;
		this.saldo = 0.0;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(output , true))){
			bw.write("Nova conta cadastrada id: " + this.numeroConta + " para cliente " + cliente.getNomeCliente());
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void sacar(double valor) {
		if(valor > saldo) {
			System.out.println("Valor indisponivel para saque!");
		}
		else {
			saldo -= valor;
			System.out.println("Saque no valor de " + valor + " efetuado com sucesso!");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(output , true))){
				bw.write("Saque efetuado no valor de " + valor + " para a conta id " + this.numeroConta + " de titular " + cliente.getNomeCliente());
				bw.newLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void depositar(double valor) {
		if(valor > 0) {
			saldo += valor;
			System.out.println("Deposito efetuado com sucesso!");
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(output , true))){
				bw.write("Deposito efetuado no valor de " + valor + " para a conta id " + this.numeroConta + " de titular " + cliente.getNomeCliente());
				bw.newLine();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Nao e possivel depositar esse valor");
		}
		
	}

	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", cliente=" + cliente.getNomeCliente() + ", saldo=" + saldo + "]";
	}
	
	
}
