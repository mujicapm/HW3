public class BookHotelSagaActivity implements SagaActivity {
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
        System.out.println("Booked a hotel!");
    }

    @Override
    public void runCompensatingAction() {
        System.out.println("Cancelled the hotel reservation!");
    }
}
