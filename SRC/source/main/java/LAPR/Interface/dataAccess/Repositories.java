package LAPR.Interface.dataAccess;

public class Repositories {
    private static final Repositories instance = new Repositories();
    private OperationRepository operationRepository = null;

    private Repositories(){
        operationRepository = new OperationRepository();
    }
    public static Repositories getInstance(){
        return instance;
    }
    public OperationRepository getOperationRepository(){
        return operationRepository;
    }
}
