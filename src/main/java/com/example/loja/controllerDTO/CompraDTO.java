package com.example.loja.controllerDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CompraDTO {

    private List<IntemCompraDTO> intemCompraList = new ArrayList<>();

    private EnderecoDTO endereco;
}
