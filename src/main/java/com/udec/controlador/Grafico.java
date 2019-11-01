/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.controlador;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author dalej
 */
@Named(value = "grafico")
@SessionScoped
public class Grafico implements Serializable{

    private PieChartModel livePieModel;
    private int votosClaudia, votosGalan, votosMorris;
    /**
     * Creates a new instance of Grafico
     */
    @PostConstruct
    public void init() {
        createLivePieModel();
    }
    private void createLivePieModel() {
        livePieModel = new PieChartModel();
 
        livePieModel.set("Claudia Lopez", 0);
        livePieModel.set("Carlos Galan", 1);
        livePieModel.set("Hollman Morris", 0);
    }
 
    
    public Grafico() {
    }
    public void votarClaudia(){
        votosClaudia = votosClaudia+1;
    }
    public void votarGalan(){
        votosGalan = votosGalan+1;
    }
     public void votarMorris(){
        votosMorris = votosMorris+1;
    }
     public PieChartModel getLivePieModel() {
         livePieModel.getData().put("Claudia Lopez", votosClaudia);
         livePieModel.getData().put("Carlos Galan", votosGalan);
         livePieModel.getData().put("Hollman Morris", votosMorris);
 
        livePieModel.setTitle("Votaciones");
        livePieModel.setLegendPosition("ne");
 
        return livePieModel;
    }

    public int getVotosClaudia() {
        return votosClaudia;
    }

    public void setVotosClaudia(int votosClaudia) {
        this.votosClaudia = votosClaudia;
    }

    public int getVotosGalan() {
        return votosGalan;
    }

    public void setVotosGalan(int votosGalan) {
        this.votosGalan = votosGalan;
    }

    public int getVotosMorris() {
        return votosMorris;
    }

    public void setVotosMorris(int votosMorris) {
        this.votosMorris = votosMorris;
    }

}
