package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Professor {
	private String nome;
	private String disciplina;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public void salvaremArquivo(){
		ArrayList<String> linha = new ArrayList();
		try {
			Scanner in = new Scanner(new FileReader("Professor"));
			while (in.hasNextLine()) {
				linha.add(in.nextLine());
			}
			int n = linha.size();
		    for (int i=0; i<n; i++) {
		      System.out.printf("Posição %d- %s\n", i, linha.get(i));
		    }
			BufferedWriter buffWrite = new BufferedWriter(new FileWriter("Professor"));
			buffWrite.append(nome +" - "+ disciplina +" \n");
			n = linha.size();
			for (int i=0; i<n; i++) {
				buffWrite.append(linha.get(i)+"\n");
			    }
			buffWrite.close();
			JOptionPane.showMessageDialog(null, "Professor Cadastrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public ArrayList<String> carregarDados() {
		ArrayList<String> linha = new ArrayList();
		try {
			Scanner in = new Scanner(new FileReader("Professor"));
			while (in.hasNextLine()) {
				linha.add(in.nextLine());
			}
			JOptionPane.showMessageDialog(null, "Arquivo Carregado");
		} catch (IOException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Não foi possivel carregar o arquivo");
			}
		int n = linha.size();
	    /*for (int i=0; i<n; i++) {
	      System.out.printf("Posição %d - %s\n", i, linha.get(i));
	    }*/
	    //String[] saida = linha.toArray(new String[linha.size()]);
		return linha;
	}
}
