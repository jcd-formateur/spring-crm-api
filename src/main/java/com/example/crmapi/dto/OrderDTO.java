package com.example.crmapi.dto;

import com.example.crmapi.model.Client;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderDTO {

    private Long id;
    private String typePresta;
    private String designation;
    private int nbDays;
    private float unitPrice;
    private String state; // option:1 cancelled:0 confirmed:2

    @JsonProperty("client")
    private ClientDTO clientDTO;

    public OrderDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO client) {
        this.clientDTO = client;
    }
}
