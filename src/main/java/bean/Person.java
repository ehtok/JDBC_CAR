package bean;

import annotation.MyColumn;
import annotation.MyTable;

@MyTable("people")
public class Person {
    @MyColumn("id")
    private int identify;
    @MyColumn("name")
    private String name;
    @MyColumn("surname")
    private String surname;
    @MyColumn("middlename")
    private String middlename;

    public Person(int identify, String name, String surname, String middlename) {
        this.identify = identify;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
    }

    @Override
    public String toString() {
        return identify +
                name +
                surname + middlename;
    }
}
