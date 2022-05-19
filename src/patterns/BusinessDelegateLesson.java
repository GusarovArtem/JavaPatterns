package patterns;

public class BusinessDelegateLesson {
    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.doTask("ejb");
    }
}

interface BusinessService {
    void doJob();
}

class EJBService implements BusinessService {
    @Override
    public void doJob() {
        System.out.println("do ejb job");
    }
}

class JMSService implements BusinessService {
    @Override
    public void doJob() {
        System.out.println("do jms job");
    }
}

class LookupService {
    BusinessService getService(String serviceType) {
        if (serviceType.equals("ejb")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}

class BusinessDelegate  {
    LookupService lookupService = new LookupService();
    BusinessService businessService;

    void doTask(String serviceType) {
        businessService = lookupService.getService(serviceType);
        businessService.doJob();
    }
}

