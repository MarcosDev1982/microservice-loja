package com.example.loja.service;

import com.example.loja.client.FornecedorClient;
import com.example.loja.controllerDTO.CompraDTO;
import com.example.loja.controllerDTO.InfoFonercedorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraService {

    @Autowired
    private FornecedorClient fornecedorClient;

    public void realizaCompra(CompraDTO compraDTO) {

       InfoFonercedorDTO info = fornecedorClient.getInfoEstado(compraDTO.getEndereco().getEstado());
        System.out.println(info.getEndereco());
    }
}
