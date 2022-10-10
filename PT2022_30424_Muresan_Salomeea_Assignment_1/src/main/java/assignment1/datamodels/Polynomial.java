package assignment1.datamodels;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial{

    private ArrayList<Monomial> monomials;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    /* This constructor takes the input string and converts it to an array list of monomials */
    public Polynomial(String polynomial) throws ParseException {
        this.monomials= new ArrayList<>();
        Monomial monomial;
        String POLYNOMIAL_PATTERN = "([+-][^+-]+)";
        Pattern pattern = Pattern.compile(POLYNOMIAL_PATTERN);
        Matcher matcher = pattern.matcher(polynomial);
        while(matcher.find()){
            monomial=new Monomial(matcher.group(1));
            this.addMonomial(monomial);
        }
    }

    /* This method turns a polynomial to a String -- used for resultValueLabel */
    public String polynomialToString(){
        df.setRoundingMode(RoundingMode.DOWN);
        StringBuilder result = new StringBuilder();
        for (Monomial m: this.monomials) {
            if(m.getCoefficient().doubleValue()>0){
                if(m.getCoefficient().doubleValue()%1==0){
                    result.append(" + ").append(m.getCoefficient().intValue()).append(" * x^").append(m.getPower());
                }
                else{
                    result.append(" + ").append(df.format(m.getCoefficient().doubleValue())).append(" * x^").append(m.getPower());
                }
            }
            else{
                if(m.getCoefficient().doubleValue()%1==0){
                    result.append(" - ").append(Math.abs((m.getCoefficient()).intValue())).append(" * x^").append(m.getPower());
                }
                else{
                    result.append(" - ").append(df.format(Math.abs((m.getCoefficient()).doubleValue()))).append(" * x^").append(m.getPower());
                }
            }
        }
        if(this.monomials.size()==0) return "0";
        return result.toString();
    }

    /* This method finds the terms with the same power of the polynomial and adds the coefficients, in order to simplify it  */
    public void simplify() {
        //Polynomial newp = new Polynomial("");
        this.monomials.removeIf(m -> m.getCoefficient().doubleValue() == 0);
        int j=0;
        while(j< monomials.size()){
            Monomial m1 = this.monomials.get(j);
            int i=j+1;
            double newCoef = m1.getCoefficient().doubleValue();
            while(i<this.monomials.size()){
                if(m1.getPower()==this.monomials.get(i).getPower()){
                    newCoef+=monomials.get(i).getCoefficient().doubleValue();
                    this.monomials.get(i).setCoefficient(0);
                    this.monomials.remove(i);
                    i--;
                }
                i++;
            }
            m1.setCoefficient(newCoef);
            j++;
        }
        this.monomials.removeIf(m -> m.getCoefficient().doubleValue() == 0);
        Collections.sort(this.monomials,new Comp());
    }

    public ArrayList<Monomial> getMonomials() {
        return monomials;
    }

    public void addMonomial(Monomial monomial){
        this.monomials.add(monomial);
    }
}
