/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseno;

import diseno.Bodega.Bodega;
import java.io.FileNotFoundException;
import javafx.stage.Stage;

/**
 *
 * @author fanat
 */
public class DataBodega {
    private Stage stage;
    private Bodega bodega;
    
    

    public DataBodega(Stage stage) throws FileNotFoundException {
        this.stage = stage;
        this.bodega = new Bodega();
    }

    public Stage getStage() {
        return stage;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    
    
    
    
    
}
