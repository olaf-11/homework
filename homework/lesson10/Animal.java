package lesson10;

public class Animal {
    private String nick;
    private Integer age;

    public Animal(){
        nick = "No Name";
        age = 0;
    }

    public Animal(String nickNameOfPet, Integer ageOfPet) {
        nick = nickNameOfPet;
        age = ageOfPet;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nickNameOfPet) {
        nick = nickNameOfPet;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer ageOfPet) {
        age = ageOfPet;
    }

    @Override
    public String toString() {
        return nick + " : " + age;
    }
}
