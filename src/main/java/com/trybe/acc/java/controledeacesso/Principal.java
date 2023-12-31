package com.trybe.acc.java.controledeacesso;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    AgeData ageData = new AgeData();
    showMenu(scanner, ageData);
  }

  private static void showMainMenuMessage() {
    System.out.println("Entre com o número correspondente à opção desejada:");
    System.out.println("1 - Acessar o estabelecimento");
    System.out.println("2 - Finalizar sistema e mostrar relatório");
  }

  private static void showMenu(Scanner scanner, AgeData ageData) {
    try {
      showMainMenuMessage();
      int option = scanner.nextInt();
      if (option == 1) {
        System.out.print("Entre com a sua idade:");
        int age = scanner.nextInt();
        if (age < 18) {
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (age >= 18 && age < 50) {
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
        ageData.accessEstablishment(age);
        showMenu(scanner, ageData);
      } else if (option == 2) {
        System.out.println("----- Quantidade -----");
        System.out.println(String.format("menores: %s", ageData.getMinors()));
        System.out.println(String.format("adultas: %s", ageData.getAdults()));
        System.out.println(String.format("a partir de 50: %s", ageData.getElders()));
        System.out.println("");
        System.out.println("----- Percentual -----");
        System.out.println(String.format("menores: %s",
            ageData.getPercentage(ageData.getMinors())));
        System.out.println(String.format("adultas: %s",
            ageData.getPercentage(ageData.getAdults())));
        System.out.println(String.format("a partir de 50: %s",
            ageData.getPercentage(ageData.getElders())));
        scanner.close();
      } else {
        System.out.println("Entre com uma opção válida!");
        showMenu(scanner, ageData);
      }
    } catch (InputMismatchException e) {
      System.out.println("Entre com uma opção válida!");
      showMenu(scanner, ageData);
    }
  }
}