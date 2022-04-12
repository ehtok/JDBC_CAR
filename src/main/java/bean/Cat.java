package bean;

import annotation.MyColumn;
import annotation.MyTable;

@MyTable("cat")
public class Cat {
    @MyColumn("id")
    int id;
    @MyColumn("name")
    String name;
    @MyColumn("surname")
    String surname;
    @MyColumn("color")
    String color;
    @MyColumn("age")
    int age;

}
