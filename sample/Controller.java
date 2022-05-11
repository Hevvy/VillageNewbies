package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.Optional;


public class Controller extends dbConnect{


    @FXML
    private TextField mokkiAlueField;

    @FXML
    private TextField postinumeroField;

    @FXML
    private TextField katuosoiteField;

    @FXML
    private TextField henkilomaaraField;

    @FXML
    private TextField vuokraField;

    @FXML
    private TextArea varusteluField;

    @FXML
    private TextField mokkiNimiField;
    @FXML
    private TextArea kuvausField;


    @FXML
    private TextField etunimiField;
    @FXML
    private TextField sukunimiField;
    @FXML
    private TextField asiakasOsoiteField;
    @FXML
    private TextField asiakasPostinumeroField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField puhField;


    @FXML
    void addMokkiPressed(ActionEvent event){
        try {

            createMökki(createID(), Integer.parseInt(mokkiAlueField.getText()), postinumeroField.getText(), mokkiNimiField.getText(), katuosoiteField.getText(), Double.parseDouble(vuokraField.getText()), kuvausField.getText(), Integer.parseInt(henkilomaaraField.getText()), varusteluField.getText());

        } catch (NumberFormatException e) {
            Dialog error = new Dialog();
            error.setContentText("Virhe Mökkiä lisätessä!");
            error.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            Node closeButton = error.getDialogPane().lookupButton(ButtonType.CLOSE);
            closeButton.managedProperty().bind(closeButton.visibleProperty());
            closeButton.setVisible(false);
            error.showAndWait();

            e.printStackTrace();
        }

    }

    @FXML
    void addAsiakasPressed(ActionEvent event){

        String password = null;

        TextInputDialog TxtDia = new TextInputDialog();
        TxtDia.setTitle("Search");
        TxtDia.getDialogPane().setContentText("Search");
        TxtDia.setHeaderText("Etsi nimellä - (asiakas_id)");
        TxtDia.setGraphic(null);

        Optional<String> result = TxtDia.showAndWait();
        TextField input = TxtDia.getEditor();
        if(input.getText() != null && input.getText().toString().length() != 0)
        // AND SOMETHING WAS FOUND IN SEARCH !!!!!!!!!
        {
            password = input.getText();
        }
        else System.out.println("null");

        try{
            createAsiakas(password, createID(), etunimiField.getText(), sukunimiField.getText(), asiakasOsoiteField.getText(), emailField.getText(), puhField.getText(), asiakasPostinumeroField.getText());
        } catch (Exception e) {
            Dialog error = new Dialog();
            error.setContentText("Virhe Asiakasta lisätessä!");
            error.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
            Node closeButton = error.getDialogPane().lookupButton(ButtonType.CLOSE);
            closeButton.managedProperty().bind(closeButton.visibleProperty());
            closeButton.setVisible(false);
            error.showAndWait();

        }


    }
    @FXML
    void addPalveluPressed(ActionEvent event){

    }
}

