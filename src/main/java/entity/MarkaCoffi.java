package entity;

import javax.persistence.*;

@Entity
@Table(name = "MarkaCoffi")
public class MarkaCoffi {

    private String name;
    private String proizvoditel;
    private Integer id;
private Type type;


    @Basic
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TYPE")
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Basic
    @Column(name = "Proizvoditel")
    public String getProizvoditel() {
        return proizvoditel;
    }

    public void setProizvoditel(String proizvoditel) {
        this.proizvoditel = proizvoditel;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Marka: id = " + id + ", Name = " + name + ", Proizvoditel = " + proizvoditel;


    }
}
