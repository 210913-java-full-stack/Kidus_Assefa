package model;

public class TestModel {
    private int id;
    private String name;
    private String string;

    public TestModel() {
    }

    public TestModel(int id, String name, String string) {
        this.id = id;
        this.name = name;
        this.string = string;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.name + " - " + this.string;
    }
}