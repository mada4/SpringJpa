package com.example.SpringJpa;

import com.example.SpringJpa.Masini;
import com.example.SpringJpa.MasinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

	@Autowired
	MasiniSpringDataJPARepository repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaSpringDataJpa.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
        int opt;
		System.out.println("0.Exit!");
		System.out.println("1.Adăugarea unei mașini în BD!");
		System.out.println("2.Ștergerea unei mașini indicată prin numărul de înmatriculare!");
		System.out.println("3.Căutarea unei mașini după numărul de înmatriculare!");
		System.out.println("4.Extragerea unei liste care conţine toate mașinile din baza de date!");
		System.out.println("5.Determinarea numărului de mașini din BD care au o anumită marcă!");
		System.out.println("6.Determinarea numărului de mașini din BD care au sub 100 000 km!");
		System.out.println("7.Extragera unei liste care conţine maşinile mai noi de 5 ani!");
		do{
			System.out.println("Introduceti optiunea: ");
			opt=scanner.nextInt();
			scanner.nextLine();
			switch (opt)
			{
				case 0:
					exit(0);
					break;
				case 1:
					System.out.println("Masina: " + repo.insert(new Masini("CS23CMI", "BMW", 2003, "albastru", 1700)) + " a fost inserata");
					break;
				case 2:
					System.out.print("Nr_inmatriculare: ");
					String nr_inmatriculare = scanner.nextLine();
					repo.deleteByNr_inmatriculare(nr_inmatriculare);
					break;
				case 3:
					System.out.print("Nr_inmatriculare: ");
					nr_inmatriculare = scanner.nextLine();
					System.out.println(repo.findByNr_inmatriculare(nr_inmatriculare));
					break;
				case 4:
					repo.findAll().forEach(System.out::println);
					break;
				case 5:
					System.out.print("Marca: ");
					String marca = scanner.nextLine();
					System.out.println("Nr masini cu marca " + marca + ": " + repo.countByMarca(marca));
					break;
				case 6:
					System.out.println("Nr masini: " + repo.countByNr_kilometrii(100000));
					break;
				case 7:
					repo.findByAnFabricatieGreaterThan(LocalDate.now().getYear()-5).forEach(System.out::println);
					break;
			}
		}while(opt!=0);
	}
}
