package br.com.dvfs.defaultmethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStringsDefaultMethods {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("udemy");
		palavras.add("alura");
		palavras.add("devmedia");
		palavras.add("caelum");
		
		/*		Antes JAVA 8
		 * ----------------------------------------------------------------------------------
		 */
		Collections.sort(palavras);
		System.out.println(palavras);
		
		Comparator<String> comparadorDeTamanho = new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
		        if(s1.length() < s2.length()) 
		            return -1;
		        if(s1.length() > s2.length()) 
		            return 1;
		        return 0;
		    }
		};
		Collections.sort(palavras, comparadorDeTamanho);
		System.out.println(palavras);
		
		/*
		 * ----------------------------------------------------------------------------------------
		 * 	JAVA 8
		 */

		palavras.sort(comparadorDeTamanho);
		System.out.println(palavras);

		Consumer<String> consumidorDeString = new Consumer<String>(){

			@Override
			public void accept(String s) {
				System.out.println(s);
				
			}
		};
		
		palavras.forEach(consumidorDeString);
	}

}
