
public class Main {

    public static void main(String[] args)
    {
        //Use ".setThrowException(true)" to set an exception on any activity

        //creating a new saga that will SUCCESSFULLY run using the Builder design pattern
        SagaBuilder sagaBuilder = new SagaBuilder().setId(1).activity(new ReserveCarSagaActivity());
        sagaBuilder.activity(new BookHotelSagaActivity());
        sagaBuilder.activity(new BookFlightSagaActivity());
        Saga saga = sagaBuilder.build();
        Boolean outcome = saga.run();
        System.out.println(outcome);

        //creating a new saga that will UNSUCCESSFULLY run using the Builder design pattern
        sagaBuilder = new SagaBuilder().setId(2).activity(new ReserveCarSagaActivity());
        sagaBuilder.activity(new BookHotelSagaActivity());

        //creating a new flight activity that will throw an exception. Exception is thrown based on a Boolean toggle
        sagaBuilder.activity(new BookFlightSagaActivity().setThrowException(true));
        saga = sagaBuilder.build();
        outcome = saga.run();
        System.out.println(outcome);


    }
}
