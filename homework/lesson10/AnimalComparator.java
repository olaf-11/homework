package lesson10;

import java.util.Comparator;

public class AnimalComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        if(o1.getAge() != o2.getAge()){
            return o1.getAge() - o2.getAge();
        } else {
            return o1.getNick().compareTo(o2.getNick());
        }
    }
}
