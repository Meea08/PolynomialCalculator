package assignment1.datamodels;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.swing.JOptionPane.showMessageDialog;

public class Monomial implements Comparable<Monomial>{

    private Number coefficient;
    private int power;

    /* This constructor takes the input string and converts it to a monomial */
    public Monomial(String monomial){
        String COEFFICIENT_PATTERN = "([+-][0-9]+)";
        String POWER_PATTERN = "[\\^]([0-9]+)";

        Pattern coefficientPattern = Pattern.compile(COEFFICIENT_PATTERN);
        Pattern powerPattern = Pattern.compile(POWER_PATTERN);

        Matcher coefficientMatcher = coefficientPattern.matcher(monomial);
        Matcher powerMatcher = powerPattern.matcher(monomial);

        if(coefficientMatcher.find() && powerMatcher.find()){
            this.coefficient=Integer.parseInt(coefficientMatcher.group(1));
            this.power=Integer.parseInt(powerMatcher.group(1));
        }
    }

    public Number getCoefficient() {
        return coefficient;
    }
    public int getPower() {
        return power;
    }
    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int compareTo(Monomial o) {
        return o.getPower()-this.getPower();
    }
}
