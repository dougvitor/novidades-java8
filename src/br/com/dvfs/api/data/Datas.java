package br.com.dvfs.api.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Datas {

	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		System.out.println(hoje.minusYears(1));
		System.out.println(hoje.minusMonths(4));
		System.out.println(hoje.minusDays(2));

		System.out.println(hoje.plusYears(1));
		System.out.println(hoje.plusMonths(4));
		System.out.println(hoje.plusDays(2));
		
		LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
		System.out.println(olimpiadasRio);
		
		System.out.println(hoje.getYear() - olimpiadasRio.getYear());
		
		Period periodo = Period.between(olimpiadasRio, hoje);
		System.out.println(periodo);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		LocalDate proximasOlimpiadas = olimpiadasRio.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String valorFormatado = proximasOlimpiadas.format(formatador);
		System.out.println(valorFormatado);
		
		DateTimeFormatter formatadorPorExtenso = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
		String valorFormatadoPorExtenso = proximasOlimpiadas.format(formatadorPorExtenso);
		System.out.println(valorFormatadoPorExtenso);
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		
		DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		System.out.println(agora.format(formatadorComHoras));
		
		YearMonth anoEMes = YearMonth.of(agora.getYear(), agora.getMonth());
		System.out.println(anoEMes.format(DateTimeFormatter.ofPattern("MM/yyyy")));
		
		LocalTime intervalo = LocalTime.of(11, 50);
		System.out.println(intervalo);
		
		LocalDate birthday = LocalDate.of(1982, 03, 24);
		LocalDate base = LocalDate.now();
		System.out.println(ChronoUnit.YEARS.between(birthday, base)); 
		System.out.println(ChronoUnit.MONTHS.between(birthday, base)); 
		System.out.println(ChronoUnit.DAYS.between(birthday, base));
	}

}
