package assignment1.gui;
import assignment1.businesslogic.Operations;
import assignment1.datamodels.Polynomial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Objects;
import static javax.swing.JOptionPane.showMessageDialog;

public class Controller implements ActionListener {

    private final View view;
    private final Operations operations = new Operations();

    public Controller(View v){
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        String firstInput = view.getFirstInputTextField().getText();
        String secondInput = view.getSecondInputTextField().getText();
        if(secondInput.equals("0") && command.equals("DIVIDE")){
            showMessageDialog(null, "Cannot divide by 0.");
            return;
        }

        Polynomial firstPolynomial = null;
        try {
            firstPolynomial = new Polynomial(firstInput);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        Polynomial secondPolynomial = null;
        try {
            secondPolynomial = new Polynomial(secondInput);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String result = "";

            switch (command){
                case "ADD":
                    try {
                        result = operations.add(Objects.requireNonNull(firstPolynomial),secondPolynomial);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "SUBTRACT":
                    try {
                        result = operations.subtract(Objects.requireNonNull(firstPolynomial), Objects.requireNonNull(secondPolynomial));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "MULTIPLY":
                    try {
                        result = operations.multiply(Objects.requireNonNull(firstPolynomial),secondPolynomial);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "DIVIDE":
                    showMessageDialog(null, "Operation not yet implemented.");
                    break;
                case "INTEGRATE":
                    try {
                        result = operations.integrate(Objects.requireNonNull(firstPolynomial));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "DIFFERENTIATE":
                    try {
                        result = operations.differentiate(Objects.requireNonNull(firstPolynomial));
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "HELP":
                    showMessageDialog(null, """
                            HOW TO USE THIS POLYNOMIAL CALCULATOR:
                            
                             1. Input polynomials have to be written in the following method:
                             (sign +/-) (integer coefficient) x^ (integer power)
                             example: +2x^2+1x^2-7x^0
                             
                             2. Always put the coefficients before x (even if the coefficient is 1),
                             otherwise the calculator will not work properly
                             
                             3. Do the same for powers (even if the power is 1 or 0)
                             
                             4. Integration and differentiation operations will be calculated on the first polynomial,
                             the second one will not be taken in consideration.""");
                    break;
                default: result = "something went wrong";
            }
            view.setResultValueLabel(result);
    }
}
