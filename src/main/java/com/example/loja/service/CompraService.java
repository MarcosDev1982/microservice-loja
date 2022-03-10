package com.example.loja.service;

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
    private RestTemplate client;

    @Autowired
    private DiscoveryClient eurekaCliente;

    public void realizaCompra(CompraDTO compraDTO){

        ResponseEntity<InfoFonercedorDTO>  exchange = client.exchange("http://fornecedor/info/"+compraDTO.getEndereco().getEstado(),
                HttpMethod.GET, null, InfoFonercedorDTO.class);
        eurekaCliente.getInstances("fornecedor").stream()
                .forEach(fornecedor->{
                    System.out.println("localhoste:"+fornecedor.getPort());
                });
       // System.out.println(exchange.getBody().getEndereco());
    }
}
