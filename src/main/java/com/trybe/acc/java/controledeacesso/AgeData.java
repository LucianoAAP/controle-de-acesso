package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AgeData {
  private List<Integer> ages = new ArrayList<Integer>();
  private int minors;
  private int adults;
  private int elders;
  private int total;

  public List<Integer> getAges() {
    return ages;
  }

  public void setAges(List<Integer> ages) {
    this.ages = ages;
  }

  public int getMinors() {
    return minors;
  }

  public void setMinors(int minors) {
    this.minors = minors;
  }

  public int getAdults() {
    return adults;
  }

  public void setAdults(int adults) {
    this.adults = adults;
  }

  public int getElders() {
    return elders;
  }

  public void setElders(int elders) {
    this.elders = elders;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public void accessEstablishment(int age) {
    ages.add(age);
    this.total += 1;
    if (age < 18) {
      this.minors += 1;
    } else if (age >= 18 && age < 50) {
      this.adults += 1;
    } else {
      this.elders += 1;
    }
  }

  public String getPercentage(int numberOfPeople) {
    DecimalFormat oneDecimalFormat = new DecimalFormat("#.#");
    double percentage = (double) numberOfPeople / this.total * 100;
    return oneDecimalFormat.format(percentage) + "%";
  }
}
