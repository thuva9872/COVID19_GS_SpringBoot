package com.project.covid19.payload.response;

public class DashboardResponse {
  private int population;
  private int covid;
  private int vaccination;

  public DashboardResponse(int population, int covid, int vaccination) {

    this.population = population;
    this.covid = covid;
    this.vaccination = vaccination;
  }

  public int getPopulation() {

    return population;
  }

  public void setPopulation(int population) {

    this.population = population;
  }

  public int getCovid() {

    return covid;
  }

  public void setCovid(int covid) {

    this.covid = covid;
  }

  public int getVaccination() {

    return vaccination;
  }

  public void setVaccination(int vaccination) {

    this.vaccination = vaccination;
  }
}
