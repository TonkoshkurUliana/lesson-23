package Task2;

import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age  +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.getName());
    }


}
class AgeComparator implements Comparator<Student> {

    public int compare(Student a, Student b){
        if (a.getName().compareTo(b.getName()) > 0) {
            return 1;
        } else if (a.getName().compareTo(b.getName()) < 0) {
            return -1;
        } else {
            if(a.getAge()> b.getAge())
                return 1;
            else if(a.getAge()< b.getAge())
                return -1;
        }

        return 0;
    }

}