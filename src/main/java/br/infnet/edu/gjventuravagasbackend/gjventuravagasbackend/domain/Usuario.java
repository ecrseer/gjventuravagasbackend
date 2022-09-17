package br.infnet.edu.gjventuravagasbackend.gjventuravagasbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
public class Usuario implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUsuario;

    private String login;
    private String password;

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Usuario(String login, String password) {
        this(0, login, password);

    }

    public Usuario(long idUsuario, String login, String password) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
    }


    @Transient
    private Boolean enabled = true;
    @Transient
    private Boolean credentialsNonExpired = true;
    @Transient
    private Boolean accountNonExpired = true;
    @Transient
    private Boolean accountNonLocked = true;
    @Transient
    private String authorities = "USER";

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        var papeis = authorities.split(",");
        var papeisStream = Arrays.stream(papeis);
        var mapped = papeisStream
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return mapped;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return this.login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
