package helloworld.behavioral.memento;

/**
 * @author luzhicheng
 * @date 2025/5/12 16:16
 */
public class MementoDemo {
    public static void main(String[] args) {
// program starts
        Calculator calculator = new CalculatorImp();
// assume user enters two numbers
        calculator.setFirstNumber(10);
        calculator.setSecondNumber(100);
// find result
        System.out.println(calculator.getCalculationResult());
// Store result of this calculation in case of error
        PreviousCalculationToCareTaker memento = calculator.backupLastCalculation();
// user enters a number
        calculator.setFirstNumber(17);
// user enters a wrong second number and calculates result
        calculator.setSecondNumber(-290);
// calculate result
        System.out.println(calculator.getCalculationResult());
// user hits CTRL + Z to undo last operation and see last result
        calculator.restorePreviousCalculation(memento);
// result restored
        System.out.println(calculator.getCalculationResult());
    }
}

interface Calculator {
    // Create Memento
    PreviousCalculationToCareTaker backupLastCalculation();

    // setMemento
    void restorePreviousCalculation(PreviousCalculationToCareTaker memento);

    int getCalculationResult();

    void setFirstNumber(int firstNumber);

    void setSecondNumber(int secondNumber);
}

class CalculatorImp implements Calculator {
    private int firstNumber;
    private int secondNumber;

    @Override
    public PreviousCalculationToCareTaker backupLastCalculation() {
// create a memento object used for restoring two numbers
        return new PreviousCalculationImp(firstNumber, secondNumber);
    }

    @Override
    public void restorePreviousCalculation(PreviousCalculationToCareTaker memento) {
        this.firstNumber = ((PreviousCalculationToOriginator) memento).getFirstNumber();
        this.secondNumber = ((PreviousCalculationToOriginator) memento).getSecondNumber();
    }

    @Override
    public int getCalculationResult() {
// result is adding two numbers
        return firstNumber + secondNumber;
    }

    @Override
    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    @Override
    public void setSecondNumber(int secondNumber) {
        this.secondNumber = secondNumber;
    }
}

interface PreviousCalculationToOriginator {
    int getFirstNumber();

    int getSecondNumber();
}

interface PreviousCalculationToCareTaker {
// no operations permitted for the caretaker
}

class PreviousCalculationImp implements PreviousCalculationToCareTaker,
        PreviousCalculationToOriginator {
    private int firstNumber;
    private int secondNumber;

    public PreviousCalculationImp(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public int getFirstNumber() {
        return firstNumber;
    }

    @Override
    public int getSecondNumber() {
        return secondNumber;
    }
}