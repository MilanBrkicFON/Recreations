/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.mb;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Milan
 */
@Named(value = "mbPopunjenostTreningaPita")
@ViewScoped
public class mbPopunjenostTreningaPita implements Serializable {

    private PieChartModel model;

    @Inject
    private MBTrenings trening;

    /**
     * Creates a new instance of mbPopunjenostTreningaPita
     */
    public mbPopunjenostTreningaPita() {
    }

    @PostConstruct
    public void init() {
        if (trening.getSelektovanTrening() != null) {

            model = new PieChartModel();

            System.out.println("--- TRENING: " + trening.getSelektovanTrening());

            model.set("Slobodno", trening.getSelektovanTrening().getSport().getMaxBrClanova() - trening.getSelektovanTrening().getClanovi().size());
            model.set("Zauzeto", trening.getSelektovanTrening().getClanovi().size());

            model.setTitle("Informacija o treningu");
            model.setShowDataLabels(true);
        }
    }

    public PieChartModel getModel() {
        return model;
    }
}
