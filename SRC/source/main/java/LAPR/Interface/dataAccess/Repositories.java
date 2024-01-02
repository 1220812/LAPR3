package LAPR.Interface.dataAccess;

public class Repositories {
    private static final Repositories instance = new Repositories();
    private OperationRepository operationRepository = null;
    private IrrigationProgramRepository irrigationProgramRepository = null;

    private Repositories(){
        operationRepository = new OperationRepository();
        irrigationProgramRepository = new IrrigationProgramRepository();
    }
    public static Repositories getInstance(){
        return instance;
    }
    public OperationRepository getOperationRepository(){
        return operationRepository;
    }

    public IrrigationProgramRepository getIrrigationProgramRepository() {
        return irrigationProgramRepository;
    }
}
