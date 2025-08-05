package com.company.Netology;

public class PersonBuilder implements IPersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;


    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Вы не указали имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if(surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Вы не указали фамилию");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным числом");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() throws IllegalArgumentException {

        if (name == null || surname == null) {
            throw new IllegalStateException("Имя и фамилия обязательны");
        }
        
        Person person;
        if (age != null) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        
        if (address != null) {
            person.setAddress(address);
        }
        
        return person;
    }
}
