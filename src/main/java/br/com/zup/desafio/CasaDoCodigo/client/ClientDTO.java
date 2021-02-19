package br.com.zup.desafio.CasaDoCodigo.client;

import br.com.zup.desafio.CasaDoCodigo.interfaces.*;
import br.com.zup.desafio.CasaDoCodigo.country.Country;
import br.com.zup.desafio.CasaDoCodigo.exception.MissingValueException;
import br.com.zup.desafio.CasaDoCodigo.state.State;
import br.com.zup.desafio.CasaDoCodigo.util.ClientSequenceGroupProvider;
import br.com.zup.desafio.CasaDoCodigo.util.TipoPessoa;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@GroupSequenceProvider(ClientSequenceGroupProvider.class)
public class ClientDTO {
    @NotBlank
    private final String name;

    @NotBlank
    private final String lastname;

    @NotBlank
    @Email
    @Singular(domainClass = Client.class, fieldName = "email")
    private final String email;

    @Enumerated(EnumType.STRING)
    @NotNull
    private final TipoPessoa tipoPessoa;

    @NotBlank
    @Singular(domainClass = Client.class, fieldName = "doc")
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private final String doc;

    @NotBlank
    private final String address;

    @NotBlank
    private final String addressComplement;

    @NotBlank
    private final String city;

    @NotBlank
    @BRTel
    private final String phone;

    @NotBlank
    @CEP
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
                     @NotNull TipoPessoa tipoPessoa,
                     @NotBlank String doc,
                     @NotBlank String address,
                     @NotBlank String addressComplement,
                     @NotBlank String city,
                     @NotNull Integer country_id,
                     Integer state_id,
                     @NotBlank String phone,
                     @NotBlank String cep) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.tipoPessoa = tipoPessoa;
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

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }
}
