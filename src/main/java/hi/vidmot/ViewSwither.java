package hi.vidmot;

import java.util.Map;

import hi.vinnsla.Lagalisti;

import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class ViewSwither {
    private static final Map<View, String> views = Map.of(
        View.HEIMA, "heima-view.fxml"
    );

    private static Scene scene;
    
    public static void setScene(Scene scene) {
        ViewSwither.scene = scene;
    }

    public static void swithTo(View view) {
        try {
            Parent root;
            if (views.containsKey(view)) {
                root = FXMLLoader.load(ViewSwither.class.getResource(views.get(view)));
            } else {
                root = FXMLLoader.load(ViewSwither.class.getResource(view.getFxml()));
            }
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void swithTo(View view, Lagalisti lagalisti) {
        try {
            Parent root;
            FXMLLoader loader = new FXMLLoader(ViewSwither.class.getResource(view.getFxml()));
            root = loader.load();
            ListiController listiController = loader.getController();
            listiController.setLagalisti(lagalisti);
            scene.setRoot(root);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
