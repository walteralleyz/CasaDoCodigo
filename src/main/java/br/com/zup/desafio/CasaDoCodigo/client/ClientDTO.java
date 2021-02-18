package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.interfaces.Exists;
import br.com.zup.desafio.CasaDoCodigo.interfaces.Singular;
import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.exception.MissingValueException;
import br.com.zup.desafio.CasaDoCodigo.state.State;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;

public class ClientDTO {
    @NotBlank
    private final String name;

    @NotBlank
    private final String lastname;

    @NotBlank
    @Email
    @Singular(domainClass = Client.class, fieldName = "email")
    private final String email;

    @NotBlank
    @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")
    @Singular(domainClass = Client.class, fieldName = "doc")
    private final String doc;

    @NotBlank
    private final String address;

    @NotBlank
    private final String addressComplement;

    @NotBlank
    private final String city;

    @NotBlank
    @Pattern(regexp = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}")
    private final String phone;

    @NotBlank
    @Pattern(regexp = "^\\d{5}-\\d{3}$")
    private final String cep;

    @NotNull
    @Exists(domainClass = Country.class, fieldName = "id")
    @Min(value = 1)
    private final Integer country_id;

    @Exists(domainClass = State.class, fieldName = "id")
    private Integer state_id;

    public ClientDTO(@NotBlank String name,
                     @NotBlank String lastname,
                     @NotBlank @Email String email,
                     @NotBlank @Pattern(regexp = "([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})") String doc,
                     @NotBlank String address,
                     @NotBlank String addressComplement,
                     @NotBlank String city,
                     @NotNull Integer country_id,
                     Integer state_id,
                     @NotBlank @Pattern(regexp = "\\(?\\d{2,}\\)?[ -]?\\d{4,}[\\-\\s]?\\d{4}") String phone,
                     @NotBlank @Pattern(regexp = "^\\d{5}-\\d{3}$") String cep) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.doc = doc;
        this.address = address;
        this.addressComplement = addressComplement;
        this.city = city;
        this.phone = phone;
        this.cep = cep;
        this.country_id = country_id;
        this.state_id = state_id;
    }

    public Client toModel(EntityManager em) throws MissingValueException {
        if(Country.hasStates(em, country_id) && state_id == 0)
            throw new MissingValueException("state");

        return new Client(
          name,
          lastname,
          email,
          doc,
          address,
          addressComplement,
          city,
          em.find(Country.class, country_id),
          em.find(State.class, state_id),
          phone,
          cep
        );
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
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

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public Integer getState_id() {
        return state_id;
    }
}
