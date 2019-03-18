package br.com.dvfs.methodreference;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenaStringsMethodReference {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("udemy");
		palavras.add("alura");
		palavras.add("devmedia");
		palavras.add("caelum");
		
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.forEach(System.out::println);
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		System.out.println();
		
		palavras.forEach(System.out::println);
	}

}
