/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloddbb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andresbailen93
 */
@Entity
@Table(name = "PARKZONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parkzone.findAll", query = "SELECT p FROM Parkzone p"),
    @NamedQuery(name = "Parkzone.findByIdUsuario", query = "SELECT p FROM Parkzone p WHERE p.idUsuario = :idUsuario"),
    @NamedQuery(name = "Parkzone.findByCentrocomercial", query = "SELECT p FROM Parkzone p WHERE p.centrocomercial = :centrocomercial AND p.ocupado = :ocupado"),
    @NamedQuery(name = "Parkzone.findByPlanta", query = "SELECT p FROM Parkzone p WHERE p.planta = :planta"),
    @NamedQuery(name = "Parkzone.findBySeccion", query = "SELECT p FROM Parkzone p WHERE p.seccion = :seccion"),
    @NamedQuery(name = "Parkzone.findByNumero", query = "SELECT p FROM Parkzone p WHERE p.numero = :numero"),
    @NamedQuery(name = "Parkzone.findByOcupado", query = "SELECT p FROM Parkzone p WHERE p.ocupado = :ocupado"),
    @NamedQuery(name = "Parkzone.findByIdPlaza", query = "SELECT p FROM Parkzone p WHERE p.idPlaza = :idPlaza")})
public class Parkzone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 240)
    @Column(name = "ID_USUARIO")
    private String idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CENTROCOMERCIAL")
    private String centrocomercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLANTA")
    private String planta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "SECCION")
    private String seccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO")
    private String numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OCUPADO")
    private short ocupado;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PLAZA")
    private Long idPlaza;

    public Parkzone() {
    }

    public Parkzone(Long idPlaza) {
        this.idPlaza = idPlaza;
    }

    public Parkzone(Long idPlaza, String centrocomercial, String planta, String seccion, String numero, short ocupado) {
        this.idPlaza = idPlaza;
        this.centrocomercial = centrocomercial;
        this.planta = planta;
        this.seccion = seccion;
        this.numero = numero;
        this.ocupado = ocupado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCentrocomercial() {
        return centrocomercial;
    }

    public void setCentrocomercial(String centrocomercial) {
        this.centrocomercial = centrocomercial;
    }

    public String getPlanta() {
        return planta;
    }

    public void setPlanta(String planta) {
        this.planta = planta;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public short getOcupado() {
        return ocupado;
    }

    public void setOcupado(short ocupado) {
        this.ocupado = ocupado;
    }

    public Long getIdPlaza() {
        return idPlaza;
    }

    public void setIdPlaza(Long idPlaza) {
        this.idPlaza = idPlaza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlaza != null ? idPlaza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parkzone)) {
            return false;
        }
        Parkzone other = (Parkzone) object;
        if ((this.idPlaza == null && other.idPlaza != null) || (this.idPlaza != null && !this.idPlaza.equals(other.idPlaza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modeloddbb.Parkzone[ idPlaza=" + idPlaza + " ]";
    }
    
}
