
public class ReserveCarSagaActivity implements SagaActivity {
    Boolean throwException = false;

    @Override
    public SagaActivity setThrowException(Boolean throwException) {
        this.throwException = throwException;
        return this;
    }

    @Override
    public void runAction() throws Exception {
        if (throwException == true) {
            throw new Exception();
        }
        System.out.println("Reserved a car!");
}


    @Override
    public void runCompensatingAction() {
        System.out.println("Cancelled the car reservation!");
    }
}
