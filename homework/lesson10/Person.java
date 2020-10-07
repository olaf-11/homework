package lesson10;

public class Person {
    private String nick;
    private String password;

    public Person(String nameOfPerson, String passwordOfPerson) {
        nick = nameOfPerson;
        password = passwordOfPerson;
    }

    public Person() {
        nick = "No Name";
        password = "00000";
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nameOfPerson) {
        nick = nameOfPerson;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordOfPerson) {
        password = passwordOfPerson;
    }

    @Override
    public String toString() {
        return nick + "\t\t\t : " + password;
    }
}
