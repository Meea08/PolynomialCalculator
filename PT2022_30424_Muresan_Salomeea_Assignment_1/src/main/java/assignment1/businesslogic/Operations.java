package assignment1.businesslogic;

import assignment1.datamodels.Monomial;
import assignment1.datamodels.Polynomial;
import java.text.ParseException;

public class Operations {

    public static String add(Polynomial first, Polynomial second) throws ParseException {

        for(Monomial m1 : first.getMonomials()){
            boolean thereIs = false;
            for (Monomial m2: second.getMonomials()) {
                if(m1.getPower()==m2.getPower()){
                    thereIs = true;
                    m2.setCoefficient(m2.getCoefficient().intValue()+m1.getCoefficient().intValue());
                }
            }
            if(!thereIs){
                second.addMonomial(m1);
            }
        }
        second.simplify();
        return second.polynomialToString();
    }

    public String subtract(Polynomial first, Polynomial second) throws ParseException {
        for(Monomial m2 : second.getMonomials()){
            m2.setCoefficient((-1)*m2.getCoefficient().doubleValue());
        }
        return add(first, second);
    }

    public String multiply(Polynomial first, Polynomial second) throws ParseException {
        Polynomial result = new Polynomial("");
        for(Monomial m1 : first.getMonomials()){
            for (Monomial m2: second.getMonomials()) {
                Monomial mResult = new Monomial("");
                mResult.setPower((m1.getPower()+m2.getPower()));
                mResult.setCoefficient(m1.getCoefficient().intValue()*m2.getCoefficient().intValue());
                result.getMonomials().add(mResult);
            }
        }
        result.simplify();
        return result.polynomialToString();
    }

    public String differentiate(Polynomial polynomial) throws ParseException {
        for(Monomial m : polynomial.getMonomials()){
            m.setCoefficient(m.getCoefficient().intValue()*m.getPower());
            m.setPower((m.getPower()-1));
        }
        polynomial.simplify();
        return polynomial.polynomialToString();
    }

    public String integrate(Polynomial polynomial) throws ParseException {
        for(Monomial m : polynomial.getMonomials()){
            m.setCoefficient((m.getCoefficient().doubleValue()*(1.0/(m.getPower()+1))));
            m.setPower((m.getPower()+1));
        }
        polynomial.simplify();
        return polynomial.polynomialToString();
    }
}