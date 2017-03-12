package pl.sda.model;

/**
 * Created by trot on 11.03.17.
 */
public class User {

    private String login;
    private String name;
    private String surname;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getAge() != user.getAge()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getSurname() != null ? getSurname().equals(user.getSurname()) : user.getSurname() == null;
    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + getAge();
        return result;
    }
}
