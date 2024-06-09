package com.example.servicequanly.payload;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RespondData  {
    private int status;
    private String message;
    private Object data;
}
