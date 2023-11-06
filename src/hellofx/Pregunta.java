package hellofx;

public class Pregunta {
    private String enunc;
    private String textOpcA;
    private String textOpcB;
    private String textOpcC;
    private String textOpcD;
    private String textOpcE;
    private String correctOption;
    private String fund;

    public Pregunta(String enunc, String textOpcA, String textOpcB, String textOpcC, String textOpcD, String textOpcE, String correctOption, String fund) {
        this.enunc = enunc;
        this.textOpcA = textOpcA;
        this.textOpcB = textOpcB;
        this.textOpcC = textOpcC;
        this.textOpcD = textOpcD;
        this.textOpcE = textOpcE;
        this.correctOption = correctOption;
        this.fund = fund;
    }

    public String getEnunc() {
        return enunc;
    }

    public String getTextOpcA() {
        return textOpcA;
    }

    public String getTextOpcB() {
        return textOpcB;
    }

    public String getTextOpcC() {
        return textOpcC;
    }

    public String getTextOpcD() {
        return textOpcD;
    }

    public String getTextOpcE() {
        return textOpcE;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public String getFund() {
        return fund;
    }
}