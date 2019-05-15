package com.dood.ratpack.intro.ch6;

public class PersonImpl implements Person {
    private final String id;
    private final String status;
    private final String age;

    public PersonImpl(String id, String status, String age) {
        this.id = id;
        this.status = status;
        this.age = age;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getAge() {
        return age;
    }
}
