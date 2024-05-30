package com.example.sevicedatve.dto;

import java.util.List;

public class ListMaGheDaDatDTO {
    private List<String> listMaGheDaDat;

    public ListMaGheDaDatDTO() {
    }

    public ListMaGheDaDatDTO(List<String> listMaGheDaDat) {
        this.listMaGheDaDat = listMaGheDaDat;
    }

    public List<String> getListMaGheDaDat() {
        return listMaGheDaDat;
    }

    public void setListMaGheDaDat(List<String> listMaGheDaDat) {
        this.listMaGheDaDat = listMaGheDaDat;
    }
}
