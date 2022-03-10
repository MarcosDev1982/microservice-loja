package com.example.loja.client;

import com.example.loja.controllerDTO.InfoFonercedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @RequestMapping("/info/{estado}")
    InfoFonercedorDTO getInfoEstado(@PathVariable String estado);

}
