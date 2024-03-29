package hi.vidmot;

import hi.vinnsla.Askrifandi;
import hi.vinnsla.Lagalistar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class PlayerController {
    Askrifandi a = new Askrifandi();
    Lagalistar lagalistar = new Lagalistar();
    private String[] myndir = new String[2];

    @FXML
    private Label fxStatus;

    /**
     * Frumstillir forritið
     * Býr til fylki af myndum
     */
    public void initialize() {
        fxStatus.setText("Staða: Ekki skráður inn");
        myndir[0] = "media/sun.png";
        myndir[1] = "media/moon.png";
    }

    /**
     * Sér um að birta Dialog og fá nafn frá notanda
     */
    public void onLogin(){
        // Birtum Dialog og fáum nafn frá notanda og setjum í Askrifanda
        AskrifandiDialog d = new AskrifandiDialog(a);
        d.showAndWait();
        fxStatus.setText("Velkomin/n: " + a.get());
    }

    public void onVeljaLista(ActionEvent actionEvent){
        Button b = (Button) actionEvent.getSource();
        int i = GridPane.getColumnIndex(b);
        ViewSwitcher.switchTo(View.LISTI, lagalistar.get(i), myndir[i]);
    }
}