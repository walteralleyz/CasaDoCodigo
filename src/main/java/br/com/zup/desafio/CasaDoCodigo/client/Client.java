package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.state.State;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private final String name;

    private final String lastname;

    @Column(unique = true)
    private final String email;

    @Column(unique = true)
    private final String doc;

    private final String address;

    private final String addressComplement;

    private final String city;

    @ManyToOne(fetch = FetchType.EAGER)
    private final Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    private final State state;

    private final String phone;

    @Column(length = 9)
    private final String cep;

    public Client(String name,
                  String lastname,
                  String email,
                  String doc,
                  String address,
                  String addressComplement,
                  String city,
                  Country country,
                  State state,
                  String phone,
                  String cep) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.doc = doc;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.phone = phone;
        this.cep = cep;
    }

    public ClientResponseDTO toDTO() {
        return new ClientResponseDTO(
            id,
            name,
            lastname,
            email,
            doc,
            address,
            addressComplement,
            city,
            country,
            state,
            phone,
            cep
        );
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getDoc() {
        return doc;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public String getCity() {
        return city;
    }

    public Country getCountry() {
        return country;
    }

    public State getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }
}
