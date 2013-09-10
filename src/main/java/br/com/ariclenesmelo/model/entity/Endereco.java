
package br.com.ariclenesmelo.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="endereco")

public class Endereco implements Serializable{
    
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue
    @Column(name= "IdEndereco" , nullable = false )
    private Integer idEndereco;
    @Column(name="NomeLogradouro", nullable = false ,length = 80)
    private String nomeLogradouro;
    @Column(name="Numero", nullable = false)
    private Integer numero;
    @Column(name="Complemento" , nullable = false, length = 30)
    private String complemento;
    @Column(name="Bairro" , length = 20)
    private String bairro;
    @Column(name="CEP", nullable = false, length = 11)
    private String cep;
    
    @OneToOne(optional=true, fetch = FetchType.LAZY)
    @ForeignKey (name="EnderecoPessoa")
    @JoinColumn(name="IdPessoa" , referencedColumnName = "IdPessoa")
    private Pessoa pessoa;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey (name="EnderecoTipoLogradouro")
    @JoinColumn(name="IdTipoLogradouro", referencedColumnName = "IdTipoLogradouro")
    private TipoLogradouro tipoLogradouro;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey (name="EnderecoTipoEndereco")
    @JoinColumn(name="IdTipoEndereco", referencedColumnName = "IdTipoEndereco")
    private TipoEndereco tipoEndereco;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey (name="EnderecoEstado")
    @JoinColumn(name="IdEstado", referencedColumnName = "IdEstado")
    private Estado estado;
    
    @ManyToOne(optional=false, fetch = FetchType.LAZY)
    @ForeignKey (name="EnderecoCidade")
    @JoinColumn(name="IdCidade", referencedColumnName = "IdCidade")
    private Cidade cidade;

    public Endereco() {
        this.cidade = new Cidade();
        this.tipoEndereco = new TipoEndereco();
        this.tipoLogradouro = new TipoLogradouro();
        this.estado = new Estado();
        this.pessoa = new Pessoa();
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idEndereco != null ? this.idEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.idEndereco != other.idEndereco && (this.idEndereco == null || !this.idEndereco.equals(other.idEndereco))) {
            return false;
        }
        return true;
    }
    
    
}
