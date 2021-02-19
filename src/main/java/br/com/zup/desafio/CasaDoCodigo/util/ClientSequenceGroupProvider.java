package br.com.zup.desafio.CasaDoCodigo.util;

import br.com.zup.desafio.CasaDoCodigo.client.ClientDTO;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClientSequenceGroupProvider implements DefaultGroupSequenceProvider<ClientDTO> {

    @Override
    public List<Class<?>> getValidationGroups(ClientDTO object) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClientDTO.class);

        if(isPessoaSelectionada(object)) {
            groups.add(object.getTipoPessoa().getGroup());
        }

        return groups;
    }

    protected boolean isPessoaSelectionada(ClientDTO dto) {
        return dto != null && dto.getTipoPessoa() != null;
    }
}
