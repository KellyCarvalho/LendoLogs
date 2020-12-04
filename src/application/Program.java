package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.EntradaLog;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Informe o caminho do arquivo");
		String path ="src\\textos\\texto.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Set <EntradaLog> set = new HashSet<>();
			
			String line =br.readLine();
			
			while(line != null) {
				String[] campos = line.split(" ");
				String usuario = campos[0];
				Date momento = Date.from(Instant.parse(campos[1]));
				
				
				set.add(new EntradaLog(usuario,momento));
				line = br.readLine();
			}

			System.out.println("Total de usuários: "+set.size());
			
		}catch(IOException e) {
			System.out.println("Erro: "+e.getMessage());
		}finally {
			
		}
		sc.close();

	}

}
