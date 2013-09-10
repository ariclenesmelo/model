
package br.com.ariclenesmelo.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;


@Entity
@Table(name="cidade")
        
public class Cidade implements Serializable{

    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue
    @Column(name="IdCidade", nullable = false)
    private Integer IdCidade;
    @Column(name="nome",nullable = false, length = 20)
    private String nome;

    @OneToMany()
    @ForeignKey (name="EnderecoCidade")
    private List<Endereco> enderecos;
    public Cidade() {
    }

    public Integer getIdCidade() {
        return IdCidade;
    }

    public void setIdCidade(Integer IdCidade) {
        this.IdCidade = IdCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.IdCidade != null ? this.IdCidade.hashCode() : 0);
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
        final Cidade other = (Cidade) obj;
        if (this.IdCidade != other.IdCidade && (this.IdCidade == null || !this.IdCidade.equals(other.IdCidade))) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
    
}
