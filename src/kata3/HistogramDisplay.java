/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata3;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author sauld
 */

public class HistogramDisplay extends ApplicationFrame{

    private final Histogram<String> histogram;  
    
    public HistogramDisplay(String title, Histogram<String> histogram){  
        super(title);
        this.histogram = histogram;       
        this.setContentPane(createPanel());
        this.pack();
    }
    
    private JPanel createPanel(){
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("JFreeChart Histogram",
                                                        "email domains",
                                                        "nº emails",
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for (String key : histogram.keySet()){        
            dataSet.addValue(histogram.get(key), "", key);
        }
        
        dataSet.addValue(20, "", "ulpgc.es");
        dataSet.addValue(30, "", "dis.ulpgc.es");
        dataSet.addValue(10, "", "ull.es");
        dataSet.addValue(25, "", "gmail.com");
        dataSet.addValue(45, "", "hotmail.com");
        dataSet.addValue(35, "", "yahoo.com");
        
        
        return dataSet;
    }
    
    public void execute(){
        this.setVisible(true);
    }
}
