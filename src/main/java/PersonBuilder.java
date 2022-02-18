
public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Заполните поле \"Имя\"!");
        }
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname.isEmpty() || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Заполните поле \"Фамилия\"!");
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if ((age < 0) || (age > 80)) {
            throw new IllegalArgumentException("Недопустимое значение возраста!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || address.isEmpty() || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Заполните поле \"Адрес\"!");
        }
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalStateException("Не задано обязательное поле \"Имя\"!");
        }
        if (surname == null || surname.isEmpty() || surname.trim().isEmpty()) {
            throw new IllegalStateException("Не задано обязательное поле \"Фамилия\"!");
        }
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else
            person = new Person(name, surname, age);
        if (!address.isEmpty()) {
            person.setAddress(address);
        }
        return person;
    }
}
