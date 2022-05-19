package patterns;

public class DAOLesson {
    static FileSystem fileSystem = new FileSystem();
    public static void main(String[] args) {
        System.out.println(fileSystem.getDataFromFs());
    }
}

interface Data {
    String getData();
}

class Db implements Data{
    String getFromTable() {
        return "data from table";
    }

    @Override
    public String getData() {
        return getFromTable();
    }
}

class FileSystem implements Data{
    String getDataFromFs() {
        return "data from fs";
    }

    @Override
    public String getData() {
        return getDataFromFs();
    }
}