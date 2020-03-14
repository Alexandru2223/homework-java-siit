package Tema3;

public class Novels extends Book {
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toStringList() {
        return "novel, " + this.getName() + ", " + this.getNumberOfPages() + ", " + this.getType();
    }
}
