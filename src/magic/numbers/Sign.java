package magic.numbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Povilas on 2015.10.05.
 */
public class Sign {

    private String value;

    private List<Sign> signs;

    private List<String> previousValues;

    public List<String> getPreviousValues() {
        return previousValues;
    }

    public void setPreviousValues(List<String> previousValues) {
        this.previousValues = previousValues;
    }

    public Sign() {
        this.previousValues = new LinkedList<>();
        this.signs = new LinkedList<>();
    }

    public Sign(String value) {
        this.previousValues = new LinkedList<>();
        this.value = value;
    }

    public Sign(List<Sign> signs) {
        this.previousValues = new LinkedList<>();
        this.signs = signs;
    }

    public Sign(String value, List<Sign> signs) {
        this.previousValues = new LinkedList<>();
        this.value = value;
        this.signs = signs;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Sign> getSigns() {
        return signs;
    }

    public void setSigns(List<Sign> signs) {
        this.signs = signs;
    }
}
