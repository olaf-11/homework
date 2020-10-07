package lesson10;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.getPassword().length() != o2.getPassword().length()){
            return o1.getPassword().length() - o2.getPassword().length();
        } else {
            return o1.getNick().compareTo(o2.getNick());
        }
    }
}
