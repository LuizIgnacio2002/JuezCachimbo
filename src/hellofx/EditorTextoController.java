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
import java.util.Map;

public class EditorTextoController {
    @FXML
    private Label numPreg;
    @FXML
    private Button anteriorPreg, anadirPreg, finalizar;
    @FXML
    private ToggleButton opcA, opcB, opcC, opcD, opcE;
    @FXML
    private ToggleGroup opc;
    @FXML
    private TextArea texto, enunc, textOpcA, textOpcB, textOpcC, textOpcD, textOpcE, fund;

    private CEjercicio ejercicio;

    @FXML
    public void initialize() {
        ejercicio = new CEjercicio("", new ArrayList<>());
        numPreg.setText("Pregunta 1");
        anteriorPreg.setDisable(true);
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
        Map<ToggleButton, Integer> buttonToKey = new HashMap<>();
        buttonToKey.put(opcA, 0);
        buttonToKey.put(opcB, 1);
        buttonToKey.put(opcC, 2);
        buttonToKey.put(opcD, 3);
        buttonToKey.put(opcE, 4);

        Integer selectedKey = buttonToKey.get(opc.getSelectedToggle());

        ArrayList<CAlternativa> alternativas = new ArrayList<>();
        alternativas.add(new CAlternativa(textOpcA.getText()));
        alternativas.add(new CAlternativa(textOpcB.getText()));
        alternativas.add(new CAlternativa(textOpcC.getText()));
        alternativas.add(new CAlternativa(textOpcD.getText()));
        alternativas.add(new CAlternativa(textOpcE.getText()));

        String razonamiento = fund.getText();

        CPregunta pregunta = new CPregunta(enunc.getText(), selectedKey, alternativas, razonamiento);
        ejercicio.getPreguntas().add(pregunta);

        enunc.clear();
        textOpcA.clear();
        textOpcB.clear();
        textOpcC.clear();
        textOpcD.clear();
        textOpcE.clear();
        fund.clear();
        opc.selectToggle(null);

        String currentText = numPreg.getText();
        int currentNumber = Integer.parseInt(currentText.replaceAll("\\D", ""));
        numPreg.setText("Pregunta " + (currentNumber + 1));
    }

    @FXML
    private void handleFinalizar() throws Exception {
        ejercicio.setTexto(texto.getText());
        PrintWriter writer = new PrintWriter(new File("output.txt"));

        writer.println("=====================TEXTO======================");
        writer.println(ejercicio.getTexto());

        int questionNumber = 1;
        for (CPregunta pregunta : ejercicio.getPreguntas()) {
            writer.println("=====================PREGUNTA " + questionNumber + "======================");
            writer.println(pregunta.getPregunta());
            writer.println("=====================ALTERNATIVAS======================");
            for (int i = 0; i < pregunta.getAlternativas().size(); i++) {
                writer.println((char)('A' + i) + ". " + pregunta.getAlternativas().get(i).getAlternativa());
            }
            writer.println("=====================ALTERNATIVA CORRECTA======================");
            writer.println((char)('A' + pregunta.getRespuesta()));
            writer.println("=====================RAZONAMIENTO======================");
            writer.println(pregunta.getRazonamiento());
            questionNumber++;
        }

        writer.close();
    }
}