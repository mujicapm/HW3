public class BookHotelSagaActivity implements SagaActivity {
    @Override
    public void runAction() throws Exception {
        System.out.println("Booked a hotel!");
    }

    @Override
    public void runCompensatingAction() {
        System.out.println("Cancelled the hotel reservation!");
    }
}
