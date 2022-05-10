public class BookFlightSagaActivity implements SagaActivity {

    private Boolean throwException = false;

    //Boolean toggle to mock an exception being thrown
    public SagaActivity setThrowException(Boolean throwException) {
        this.throwException = throwException;
        return this;
    }

    @Override
    public void runAction() throws Exception {
        if (throwException == true) {
            throw new Exception();
        }
        System.out.println("Booked a flight!");
    }

    @Override
    public void runCompensatingAction() {
        System.out.println("Cancelled the flight reservation!");
    }
}


