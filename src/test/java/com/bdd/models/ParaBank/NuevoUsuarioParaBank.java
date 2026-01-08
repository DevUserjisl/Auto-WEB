package com.bdd.models.ParaBank;

import com.github.javafaker.Faker;

import java.util.Map;

public class NuevoUsuarioParaBank {

    private static final Faker faker = new Faker();

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String city;
    private final String state;
    private final String zipCode;
    private final String phone;
    private final String ssn;
    private final String username;
    private final String password;

    // Constructor que genera valores fake aleatorios
    public NuevoUsuarioParaBank() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.address = faker.address().streetAddress();
        this.city = faker.address().city();
        this.state = faker.address().state();
        this.zipCode = faker.address().zipCode().substring(0, 5);
        this.phone = faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "").substring(0, 9);
        this.ssn = faker.idNumber().ssnValid().replaceAll("[^\\d]", "");
        this.username = faker.name().username();
        this.password = faker.internet().password(8, 12);
    }

    // Constructor que acepta un Map y genera Faker si se detecta el texto "faker"
    public NuevoUsuarioParaBank(Map<String, String> datos) {
        this.firstName = usarFakerSiNecesario(datos.get("firstName"), faker.name()::firstName);
        this.lastName = usarFakerSiNecesario(datos.get("lastName"), faker.name()::lastName);
        this.address = usarFakerSiNecesario(datos.get("address"), faker.address()::streetAddress);
        this.city = usarFakerSiNecesario(datos.get("city"), faker.address()::city);
        this.state = usarFakerSiNecesario(datos.get("state"), faker.address()::state);
        this.zipCode = usarFakerSiNecesario(datos.get("zipCode"), () -> faker.address().zipCode().substring(0, 5));
        this.phone = usarFakerSiNecesario(datos.get("phone"), () -> faker.phoneNumber().cellPhone().replaceAll("[^\\d]", "").substring(0, 9));
        this.ssn = usarFakerSiNecesario(datos.get("ssn"), () -> faker.idNumber().ssnValid().replaceAll("[^\\d]", ""));
        this.username = usarFakerSiNecesario(datos.get("username"), faker.name()::username);
        this.password = usarFakerSiNecesario(datos.get("password"), () -> faker.internet().password(8, 12));
    }

    // Método utilitario: si el valor es "faker", usa el generador de Faker
    private String usarFakerSiNecesario(String valor, java.util.function.Supplier<String> generador) {
        return valor == null || valor.trim().equalsIgnoreCase("faker") ? generador.get() : valor;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }
    public String getPhone() { return phone; }
    public String getSsn() { return ssn; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    // toString
    @Override
    public String toString() {
        return "NuevoUsuarioParaBank{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}