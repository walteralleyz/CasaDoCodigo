package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.state.State;

public class ClientResponseDTO {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String doc;
    private String address;
    private String addressComplement;
    private String city;
    private Country country;
    private State state;
    private String phone;
    private String cep;

    public ClientResponseDTO(Integer id,
                             String name,
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
        this.id = id;
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
