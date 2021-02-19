package br.com.zup.desafio.CasaDoCodigo.util;

import br.com.zup.desafio.CasaDoCodigo.interfaces.CnpjGroup;
import br.com.zup.desafio.CasaDoCodigo.interfaces.CpfGroup;

public enum TipoPessoa {
    FISICA("Fisica", "CPF", "000.000.000-00", CpfGroup.class),
    JURIDICA("Juridica", "CNPJ", "00.000.000/0000-00", CnpjGroup.class);

    private final String descricao;
    private final String documento;
    private final String mascara;
    private final Class<?> group;

    TipoPessoa(String descricao, String documento, String mascara, Class<?> group) {
        this.descricao = descricao;
        this.documento = documento;
        this.mascara = mascara;
        this.group = group;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDocumento() {
        return documento;
    }

    public String getMascara() {
        return mascara;
    }

    public Class<?> getGroup() {
        return group;
    }
}
