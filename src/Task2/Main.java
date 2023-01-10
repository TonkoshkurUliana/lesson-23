package Task2;


import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        TreeSet<Student> st = new TreeSet<>(new AgeComparator());
        st.add(new Student("Vasul",32));
        st.add(new Student("Roman",30));
        st.add(new Student("John",12));
        st.add(new Student("Roman",10));
        st.add(new Student("Ura",89));

        Stream<Student> collection =  st.stream();

        System.out.println("Відсортований список");
        System.out.println(collection.sorted().collect(Collectors.toList()));

    }
}