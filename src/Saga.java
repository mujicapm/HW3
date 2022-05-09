import java.util.ArrayList;

// Represents an entire distributed transaction. Consists of one or more
// SagaActivitys.
public class Saga {
    private int id;
    private ArrayList<SagaActivity> sagaActivities = new ArrayList<SagaActivity>();

    // Any constructors you deem appropriate


// Executes the entire Saga by running each activity one-by-one. If
// any SagaActivity in the Saga fails, undoes all previously executed
// activties by running their compensating actions. Compensating actions
// must run in reverse order of their original application. Returns
// true if the entire Saga completed successfully or false otherwise.
    public boolean run () {
        //arraylist that gets populated with successfully executed activities.
        // Should an exception occur during the loop, the activities will be "walked back" using "runCompensatingAction()"//
        ArrayList<SagaActivity> successfulActivities = new ArrayList<SagaActivity>();
        for (SagaActivity activity : sagaActivities) {
            try {
                activity.runAction();
            } catch (Exception e) {
                //walking back the previous activities
                for (SagaActivity successActivity : successfulActivities) {
                    successActivity.runCompensatingAction();
                }
                e.printStackTrace();
                return false;
            }
            //adding the successfully completed activity to the ArrayList in case of an exception "down range"
            successfulActivities.add(activity);
        }
        return true;
    }

    public ArrayList<SagaActivity> getSagaActivities() {
        return sagaActivities;
    }

    public void setSagaActivities(ArrayList<SagaActivity> sagaActivities) {
        this.sagaActivities = sagaActivities;
    }

    public void setId(int id) {
        this.id = id;
    }
}
