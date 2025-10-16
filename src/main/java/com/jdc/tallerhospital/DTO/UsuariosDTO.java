package com.jdc.tallerhospital.DTO;

public class UsuariosDTO {

    private Long idusuario;
    private String username;
    private String password;
    private String estado;

    public UsuariosDTO() {}

    public UsuariosDTO(Long idusuario, String username, String password, String estado) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
        this.estado = estado;
    }

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
