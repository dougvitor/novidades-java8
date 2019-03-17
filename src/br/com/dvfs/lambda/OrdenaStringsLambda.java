package br.com.dvfs.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsLambda {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("udemy");
		palavras.add("alura");
		palavras.add("devmedia");
		palavras.add("caelum");
		palavras.forEach(s -> System.out.println(s));
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.forEach(s -> System.out.print(s + " "));
		
		System.out.println();
		
		Consumer<String> impressao = s -> System.out.print(s + " "); 
		palavras.sort((s1, s2) -> s2.length() - s1.length());
		palavras.forEach(impressao);
		
		Runnable r = () -> System.out.println("Executando um Runnable");
		new Thread(r).start();
	}

}
