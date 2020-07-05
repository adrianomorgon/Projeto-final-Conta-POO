package entities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Cliente {
	private int idCliente;
	private String nomeCliente;
	static String output = "C:\\Users\\adria\\eclipse-workspace\\Projeto-final2\\log.txt";
	
	public Cliente(int id, String nome) {
		idCliente = id;
		nomeCliente = nome;
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(output , true))){
			bw.write("Novo cliente " + nomeCliente + " cadastrado");
			bw.newLine();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + "]";
	}
	
	
}
