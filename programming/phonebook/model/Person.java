package model;
import java.util.regex.*;


public class Person {
    private String first_name;
    private String last_name;
    private String phone;
    public Person(String first_name, String last_name, String phone) {
        setFirst_name(first_name);
        setLast_name(last_name);
        setPhone(phone);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        Pattern p = Pattern.compile("^09[0-9]{9}$");
        Matcher m = p.matcher(phone);
        boolean b = m.matches();
        if (b) {
            this.phone = phone;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return phone.equals(person.phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
