package model;

public class ToDoItem {
    private int id;
    private String message;
    private boolean complete;

    public ToDoItem() {
        complete = false;
    }

    public ToDoItem(String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }

    public ToDoItem(int id, String message) {
        complete = false;
        this.id = id;
        this.message = message;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    /*
    This is a list of the 8 java primitive types and the wrapper classes that correspond to them. ~-2,140,000 - ~2,140,000
     */
//    public int i; //whole number value, 32-bits signed
//    public Integer integer;
//
//    private float f = 1.2f; //floating point type, decimal value
//    public Float fl;
//
//    public double d = 1.5; //increased precision and length over float
//    public Double dou;
//
//    public long l; //bigger than int
//    public Long lo;
//
//    public boolean b; //true or false
//    public Boolean bool;
//
//    public short s; //smaller than int - 16 bits? signed
//    public Short sh;
//
//    private char c;
//    public Character ch;
//
//    public byte by;
//    public Byte byt;





}