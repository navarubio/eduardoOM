/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santos
 */
@Entity
@Table(name = "hc_detalle", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HcDetalle.findAll", query = "SELECT h FROM HcDetalle h"),
    @NamedQuery(name = "HcDetalle.findByIdRegistro", query = "SELECT h FROM HcDetalle h WHERE h.hcDetallePK.idRegistro = :idRegistro"),
    @NamedQuery(name = "HcDetalle.findByIdCampo", query = "SELECT h FROM HcDetalle h WHERE h.hcDetallePK.idCampo = :idCampo"),
    @NamedQuery(name = "HcDetalle.findByValor", query = "SELECT h FROM HcDetalle h WHERE h.valor = :valor")})
public class HcDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HcDetallePK hcDetallePK;
    @Column(name = "valor", length = 2147483647)
    private String valor;
    @JoinColumn(name = "id_registro", referencedColumnName = "id_registro", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HcRegistro hcRegistro;
    @JoinColumn(name = "id_campo", referencedColumnName = "id_campo", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HcCamposReg hcCamposReg;
       //Uso exclusivo para sincronizacion de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sincronizador", nullable = false)
    private Integer idSincronizador;

    
    @Transient
    private Long valorX;
    public HcDetalle() {
    }

    public HcDetalle(HcDetallePK hcDetallePK) {
        this.hcDetallePK = hcDetallePK;
    }

    public HcDetalle(int idRegistro, int idCampo, int idSede) {
        this.hcDetallePK = new HcDetallePK(idRegistro, idCampo, idSede);
    }

    public HcDetallePK getHcDetallePK() {
        return hcDetallePK;
    }

    public void setHcDetallePK(HcDetallePK hcDetallePK) {
        this.hcDetallePK = hcDetallePK;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public HcRegistro getHcRegistro() {
        return hcRegistro;
    }

    public void setHcRegistro(HcRegistro hcRegistro) {
        this.hcRegistro = hcRegistro;
    }

    public HcCamposReg getHcCamposReg() {
        return hcCamposReg;
    }

    public void setHcCamposReg(HcCamposReg hcCamposReg) {
        this.hcCamposReg = hcCamposReg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hcDetallePK != null ? hcDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HcDetalle)) {
            return false;
        }
        HcDetalle other = (HcDetalle) object;
        if ((this.hcDetallePK == null && other.hcDetallePK != null) || (this.hcDetallePK != null && !this.hcDetallePK.equals(other.hcDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades2.HcDetalle[ hcDetallePK=" + hcDetallePK + " ]";
    }

    public Integer getIdSincronizador() {
        return idSincronizador;
    }

    public void setIdSincronizador(Integer idSincronizador) {
        this.idSincronizador = idSincronizador;
    }

    public Long getValorX() {
        return valorX;
    }

    public void setValorX(Long valorX) {
        this.valorX = valorX;
    }

}
