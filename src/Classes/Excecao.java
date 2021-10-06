package Classes;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Excecao {
	private String data;
	private String motivo;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public void salvaremArquivo(){
		ArrayList<String> linha = new ArrayList();
		try {
			Scanner in = new Scanner(new FileReader("Excecoes"));
			while (in.hasNextLine()) {
				linha.add(in.nextLine());
			}
			int n = linha.size();
		    for (int i=0; i<n; i++) {
		      System.out.printf("Posição %d- %s\n", i, linha.get(i));
		    }
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Excecoes"));
			buffWrite.append(data +" - "+ motivo +" \n");
			n = linha.size();
			for (int i=0; i<n; i++) {
				buffWrite.append(linha.get(i)+"\n");
			    }
			buffWrite.close();
			JOptionPane.showMessageDialog(null, "Exceção Cadastrada");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<String> carregarDados() {
		ArrayList<String> linha = new ArrayList();
		try {
			Scanner in = new Scanner(new FileReader("Excecoes"));
			while (in.hasNextLine()) {
				linha.add(in.nextLine());
			}
			JOptionPane.showMessageDialog(null, "Arquivo Carregado");
		} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Não foi possivel carregar o arquivo");
			}
		int n = linha.size();
	    for (int i=0; i<n; i++) {
	      System.out.printf("Posição %d - %s\n", i, linha.get(i));
	    }
		return linha;
	}
}
