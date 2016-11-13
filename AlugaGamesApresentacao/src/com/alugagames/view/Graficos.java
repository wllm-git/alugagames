package com.alugagames.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
 
@SuppressWarnings("serial")
@ManagedBean
public class Graficos implements Serializable {
 
	private PieChartModel pieModel1;
    private BarChartModel animatedModel2;
    
 
    @PostConstruct
    public void init() {
        createAnimatedModels();
        createPieModels();
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
    
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
     
    
    private void createPieModels() {
        createPieModel1();
    }
    
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("Aventura", 540);
        pieModel1.set("Ação", 325);
        pieModel1.set("Futebol", 702);
        pieModel1.set("Acarde", 421);
         
        pieModel1.setTitle("Gêneros mais alugados");
        pieModel1.setLegendPosition("w");
    }
    
 
    private void createAnimatedModels() {
     
        Axis yAxis;;
     
         
        animatedModel2 = initBarModel();
        animatedModel2.setTitle("Aluguel de Consoles por mês");
        animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
        yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries ps4 = new ChartSeries();
        ps4.setLabel("PS4");
        ps4.set("Maio", 45);
        ps4.set("Junho", 72);
        ps4.set("Julho", 35);
        ps4.set("Agosto", 56);
 
        ChartSeries xBoxOne = new ChartSeries();
        xBoxOne.setLabel("XBox One");
        xBoxOne.set("Maio", 32);
        xBoxOne.set("Junho", 85);
        xBoxOne.set("Julho", 30);
        xBoxOne.set("Agosto", 44);
        
        ChartSeries superNitendo = new ChartSeries();
        superNitendo.setLabel("Super Nitendo");
        superNitendo.set("Maio", 23);
        superNitendo.set("Junho", 47);
        superNitendo.set("Julho", 29);
        superNitendo.set("Agosto", 33);
        
        
        model.addSeries(ps4);
        model.addSeries(xBoxOne);
        model.addSeries(superNitendo);
         
        return model;
    }
    
    
     
   
    
}