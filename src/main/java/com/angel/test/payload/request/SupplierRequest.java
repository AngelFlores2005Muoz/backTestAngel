package com.angel.test.payload.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SupplierRequest {
  @NotBlank
  @NotEmpty
  @Size(min = 3, max = 20)
  private String name;

  @NotBlank
  @NotEmpty
  @Size(max = 50)
  private String razonSocial;

  @NotBlank
  @NotEmpty
  @Size(max = 100)
  private String direccion;

}
