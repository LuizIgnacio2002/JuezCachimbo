package hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EditorTextoController {
    @FXML
    private Label numPreg;
    @FXML
    private Button anadirPreg, finalizar;
    @FXML
    private ToggleButton opcA, opcB, opcC, opcD, opcE;
    @FXML
    private ToggleGroup opc;
    @FXML
    private TextArea texto, enunc, textOpcA, textOpcB, textOpcC, textOpcD, textOpcE, fund;

    private List<Pregunta> questions = new ArrayList<>();

    @FXML
    public void initialize() {
        // Set the initial number of the question
        numPreg.setText("Pregunta 1");
        anadirPreg.setOnAction(event -> handleAnadirPreg());
        finalizar.setOnAction(event -> {
            try {
                handleFinalizar();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void handleAnadirPreg() {
        // Create a map to associate each ToggleButton with a key letter
        Map<ToggleButton, String> buttonToKey = new HashMap<>();
        buttonToKey.put(opcA, "A");
        buttonToKey.put(opcB, "B");
        buttonToKey.put(opcC, "C");
        buttonToKey.put(opcD, "D");
        buttonToKey.put(opcE, "E");

        // Get the key letter of the selected toggle button
        String selectedKey = buttonToKey.get(opc.getSelectedToggle());

        // Create a new question object and store the current content
        Pregunta question = new Pregunta(enunc.getText(), textOpcA.getText(), textOpcB.getText(), textOpcC.getText(), textOpcD.getText(), textOpcE.getText(), selectedKey, fund.getText());
        questions.add(question);

        // Clear the text areas and unselect the toggle group
        enunc.clear();
        textOpcA.clear();
        textOpcB.clear();
        textOpcC.clear();
        textOpcD.clear();
        textOpcE.clear();
        fund.clear();
        opc.selectToggle(null);

        // Increment the number in the numPreg label
        String currentText = numPreg.getText();
        int currentNumber = Integer.parseInt(currentText.replaceAll("\\D", ""));
        numPreg.setText("Pregunta " + (currentNumber + 1));
    }

    @FXML
    private void handleFinalizar() throws Exception {
        PrintWriter writer = new PrintWriter(new File("output.txt"));

        writer.println("=====================TEXTO======================");
        writer.println(texto.getText());

        int questionNumber = 1;
        for (Pregunta question : questions) {
            writer.println("=====================PREGUNTA " + questionNumber + "======================");
            writer.println(question.getEnunc());
            writer.println("=====================ALTERNATIVAS======================");
            writer.println("A. " + question.getTextOpcA());
            writer.println("B. " + question.getTextOpcB());
            writer.println("C. " + question.getTextOpcC());
            writer.println("D. " + question.getTextOpcD());
            writer.println("E. " + question.getTextOpcE());
            writer.println("=====================ALTERNATIVA CORRECTA======================");
            writer.println(question.getCorrectOption());
            writer.println("=====================RAZONAMIENTO======================");
            writer.println(question.getFund());
            questionNumber++;
        }

        writer.close();
    }
}

