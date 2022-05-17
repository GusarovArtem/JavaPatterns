package patterns;

public class BridgeLesson {
    public static void main(String[] args) {
        ICar toyotaCar = new ToyotaCar(new CarBridge());
        toyotaCar.drive();
        ICar audiCar = new AudiCar(new CarBridge());
        audiCar.drive();

        ITrack toyotaTrack = new ToyotaTrack(new TrackBridge());
        toyotaTrack.drive();
        ITrack audiTrack = new AudiTrack(new TrackBridge());
        audiTrack.drive();
    }
}

abstract class ICar {
    IBridge iBridge;

    public ICar(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

abstract class ITrack {
    IBridge iBridge;

    public ITrack(IBridge iBridge) {
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

interface IBridge {
    void drive();
}

class CarBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive Car");
    }
}

class TrackBridge implements IBridge {
    @Override
    public void drive() {
        System.out.println("drive Track");
    }
}

class ToyotaCar extends ICar {
    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive ToyotaCar");
    }
}

class AudiCar extends ICar {
    public AudiCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive AudiCar");
    }
}

class ToyotaTrack extends ITrack {
    public ToyotaTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive ToyotaTrack");
    }
}

class AudiTrack extends ITrack {
    public AudiTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive AudiTrack");
    }
}













//interface ICar {
//    void drive();
//}
//
//interface ITrack {
//    void drive();
//}
//
//Пример плохой реализации иерархии:
//
//class ToyotaCar implements ICar {
//    @Override
//    public void drive() {
//
//    }
//}
//
//class AudiCar implements ICar {
//    @Override
//    public void drive() {
//
//    }
//}
//
//class ToyotaTrack implements ITrack {
//    @Override
//    public void drive() {
//
//    }
//}
//
//class AudiTrack implements ITrack {
//    @Override
//    public void drive() {
//
//    }
//}
//
