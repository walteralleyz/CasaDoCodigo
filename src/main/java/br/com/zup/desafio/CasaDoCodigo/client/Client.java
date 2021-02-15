package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.state.State;

import javax.persistence.*;
import javax.validation.constraints.*;

import static java.util.regex.Pattern.compile;

@Entity
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    @Column(unique = true)
    private String doc;

    @NotBlank
    private String address;

    @NotBlank
    private String addressComplement;

    @NotBlank
    private String city;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Country country;

    @ManyToOne(fetch = FetchType.EAGER)
    private State state;

    @NotBlank
    @Pattern(regexp = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}")
    private String phone;

    @NotBlank
    @Size(max = 9)
    private String cep;

    public Client() {}

    public Client(@NotBlank String name,
                  @NotBlank String lastname,
                  @NotBlank @Email String email,
                  @NotBlank @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})") String doc,
                  @NotBlank String address,
                  @NotBlank String addressComplement,
                  @NotBlank String city,
                  @NotNull Country country,
                  State state,
                  @NotBlank @Pattern(regexp = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}") String phone,
                  @NotBlank @Size(max = 9) String cep) {
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
