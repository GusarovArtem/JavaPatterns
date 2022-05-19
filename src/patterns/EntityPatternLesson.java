package patterns;

public class EntityPatternLesson {
    public static void main(String[] args) {
        CompositeEntity compositeEntity = new CompositeEntity();
        for (String s : compositeEntity.getData()) {
            System.out.println(s);
        }
    }
}

class DependedObject1 {
    String getData() {
        return "one";
    }
}

class DependedObject2 {
    String getData() {
        return "two";
    }
}

class CoarseGainedObject {
    DependedObject1 dependedObject1 = new DependedObject1();
    DependedObject2 dependedObject2 = new DependedObject2();

    public  String[] getData() {
        return new String[] {dependedObject1.getData(), dependedObject2.getData()};
    }
}

class CompositeEntity {
    CoarseGainedObject coarseGainedObject = new CoarseGainedObject();
    public String[] getData() {
        return coarseGainedObject.getData();
    }
}