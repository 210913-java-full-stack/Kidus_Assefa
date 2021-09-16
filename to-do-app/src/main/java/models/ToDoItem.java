package models;

public class ToDoItem {
    private String toDoText;
    private boolean complete;

    public ToDoItem() {

    }

    public ToDoItem(String toDoText) {
        this.toDoText = toDoText;
    }

    public String getToDoText() {
        return toDoText;
    }

    public void setToDoText(String toDoText) {
        this.toDoText = toDoText;
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