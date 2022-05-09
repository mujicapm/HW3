import java.util.ArrayList;

// A utility class to make constructing sagas easier.
public class SagaBuilder {

    private int id;
    private ArrayList<SagaActivity> sagaActivities = new ArrayList<SagaActivity>();

    public SagaBuilder setId(int id) {
        this.id = id;
        return this;
    }

    // Add the specified activity to the to-be-built saga.
    public SagaBuilder activity(SagaActivity activity) {
        this.sagaActivities.add(activity);
        return this;
    }


    // Constructs and returns the saga.
    public Saga build() {
        Saga saga = new Saga();
        saga.setId(this.id);
        saga.setSagaActivities(this.sagaActivities);
        return saga;
    }

}

