// Represents an individual step in a saga which can be rolled back.
interface SagaActivity
{
    // Attempts to perform the activity. Throws an Exception if the attempt
// fails for whatever reason (e.g. a network failure)
    void runAction() throws Exception;
    // Undoes a previously-successful activity. For example, if a saga
// runAction() created a file, runCompensatingAction() would delete
// the created file. For the purposes of this assignment, this
// compensating action is assumed to never fail.
    void runCompensatingAction();
}

