package fr;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.skin.RadioButtonSkin;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * JavaFX Radio Buttons
 */
public class RadioButtons extends Application {

    public boolean inputUser = true;

    public boolean backgroundColor = true;

    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Bouttons Radio");

        Label userInput = new Label("Entrée Utilisateur :");
        Label copyInput = new Label("COPY INPUT TEST");
        Label paneParam = new Label("PANEPARAM TEST :");
        Label paneBG = new Label("PANEBG TEST :");
        Label paneClr = new Label("PANECLR TEST :");
        Label paneCase = new Label("PANECASE TEST :");
        Label sRed = new Label("Rouge");
        Label sBlue = new Label("Blue");
        Label sGreen = new Label("Vert");

        CheckBox backgroundColor = new CheckBox("Couleur de fond");
        CheckBox characterColor = new CheckBox("Couleur des caractères");
        CheckBox letterParameter = new CheckBox("Paramètres de case");

        RadioButton redColor = new RadioButton("Red");
        RadioButton blueColor = new RadioButton("Blue");
        RadioButton greenColor = new RadioButton("Green");

        // new Slider (Premier chiffre valeur minimal, valeur max, valeur
        // d'initialisation)
        Slider redSlider = new Slider(0, 255, 0);
        Slider blueSlider = new Slider(0, 255, 0);
        Slider greenSlider = new Slider(0, 255, 0);

        TextArea inputField = new TextArea();

        TitledPane parametersPane = new TitledPane("Paramètres :", paneParam);
        parametersPane.setExpanded(true);
        parametersPane.setVisible(false);

        TitledPane backgroundParam = new TitledPane("Background :", paneBG);
        backgroundParam.setExpanded(false);
        backgroundParam.setVisible(false);

        TitledPane colorParam = new TitledPane("Coleur des caractères :", paneClr);
        colorParam.setExpanded(false);
        colorParam.setVisible(false);

        TitledPane caseParam = new TitledPane("Case :", paneCase);
        caseParam.setExpanded(false);
        caseParam.setVisible(false);

        GridPane radioButtonsMain = new GridPane();
        // radioButtonsMain.setAlignment(Pos.CENTER);
        radioButtonsMain.setGridLinesVisible(true);

        VBox vBGBox = new VBox(redColor, blueColor, greenColor);
        backgroundParam.setContent(vBGBox);

        VBox vCheckBox = new VBox(backgroundColor, characterColor, letterParameter);
        parametersPane.setContent(vCheckBox);

        VBox vSLDBox = new VBox(10, sRed, redSlider, sBlue, blueSlider, sGreen, greenSlider);
        colorParam.setContent(vSLDBox);

        radioButtonsMain.add(userInput, 1, 1);
        radioButtonsMain.add(inputField, 2, 1);
        radioButtonsMain.add(copyInput, 2, 2);
        radioButtonsMain.add(parametersPane, 3, 1);
        radioButtonsMain.add(backgroundParam, 1, 3);
        radioButtonsMain.add(colorParam, 2, 3);
        radioButtonsMain.add(caseParam, 3, 3);

        inputField.setOnKeyTyped(value -> {

            // inputField est vide > return false
            // inputFIeld n'est pas vide > return true
            // !negation (inverse)

            parametersPane.setVisible(!inputField.getText().isEmpty());

            // if (inputField.getText().isEmpty()) {
            // parametersPane.setVisible(false);
            // } else {
            // parametersPane.setVisible(true);
            // }
        });

        // Méthode pour faire apelle aux tableaux quand les Checkbox sont cochés.

        backgroundColor.setOnAction(value -> {

            backgroundParam.setVisible(backgroundColor.isSelected());
            backgroundParam.setExpanded(backgroundColor.isSelected());
        });

        characterColor.setOnAction(value -> {

            colorParam.setVisible(characterColor.isSelected());
            colorParam.setExpanded(characterColor.isSelected());

        });

        letterParameter.setOnAction(value -> {

            caseParam.setVisible(letterParameter.isSelected());
            caseParam.setExpanded(letterParameter.isSelected());

        });

        // Assignement de couleur au Label copyInput

        redColor.setOnAction(event -> {

            copyInput.setText(inputField.getText());
            copyInput.setStyle("-fx-background-color: red;");
        });

        greenColor.setOnAction(event -> {

            copyInput.setText(inputField.getText());
            copyInput.setStyle("-fx-background-color: green;");
        });

        blueColor.setOnAction(event -> {

            copyInput.setText(inputField.getText());
            copyInput.setStyle("-fx-background-color: blue;");
        });

        // Propriete des sliders

        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = newValue.intValue();
            int green = (int) greenSlider.getValue();
            int blue = (int) blueSlider.getValue();
            Color textColor = Color.rgb(red, green, blue);
            copyInput.setTextFill(textColor);
        });

        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = (int) redSlider.getValue();
            int green = newValue.intValue();
            int blue = (int) blueSlider.getValue();
            Color textColor = Color.rgb(red, green, blue);
            copyInput.setTextFill(textColor);
        });

        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            int red = (int) redSlider.getValue();
            int green = (int) greenSlider.getValue();
            int blue = newValue.intValue();
            Color textColor = Color.rgb(red, green, blue);
            copyInput.setTextFill(textColor);
        });

        // Affichage de cran pour le slider :

        redSlider.setShowTickLabels(true);
        greenSlider.setShowTickLabels(true);
        blueSlider.setShowTickLabels(true);

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        Scene scene = new Scene(radioButtonsMain, 500, 500);

        stage.setScene(scene);
        stage.show();
    }

}