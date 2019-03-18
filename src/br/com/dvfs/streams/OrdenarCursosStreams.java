package br.com.dvfs.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdenarCursosStreams {
	
	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		cursos.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println();
		
		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
		streamDeCurso.forEach(c -> System.out.println(c.getNome()));
		
		System.out.println();
		
		// Autobox int to Integer
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .map(Curso::getAlunos)
		   .forEach(System.out::println);
		
		System.out.println();
		
		// evita Autobox
		cursos.stream()
		   .filter(c -> c.getAlunos() > 100)
		   .mapToInt(Curso::getAlunos)
		   .forEach(System.out::println);
		
		System.out.println();
		
		System.out.println(
			cursos
				.stream()
				.filter(c -> c.getAlunos() < 100)
				.mapToInt(c -> c.getAlunos()).sum()
		);
		
		System.out.println();
	
		cursos
			.stream()
			.map(Curso::getNome)
			.forEach(System.out::println);
		
		System.out.println();
		
		List<String> colecao = cursos
			.stream()
			.filter(c -> c.getAlunos() > 100)
			.map(Curso::getNome)
			.collect(Collectors.toList());
		
		colecao.forEach(System.out::println);
		
		System.out.println();
		
		Map<String, Integer> mapa = cursos 
				.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(Curso::getNome, c -> c.getAlunos()));
		
		System.out.println(mapa);
		
		System.out.println();
		
		System.out.println(cursos
			.stream()
			.filter(c -> c.getAlunos() < 0) 
			.mapToDouble(Curso::getAlunos)
			.average().orElseGet(() -> 10));
	}

}
