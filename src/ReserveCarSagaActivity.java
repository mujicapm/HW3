
public class ReserveCarSagaActivity implements SagaActivity {
    @Override
    public void runAction() throws Exception {
        System.out.println("Reserved a car!");
    }

    @Override
    public void runCompensatingAction() {
        System.out.println("Cancelled the car reservation!");
    }
}
