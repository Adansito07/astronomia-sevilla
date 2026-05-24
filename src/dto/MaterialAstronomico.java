package dto;

import java.util.Objects;

public class MaterialAstronomico {

	private int codigo;
	private String nombre;
	private TipoMaterial tipo;
	private EstadoMaterial estado;

	public MaterialAstronomico() {}

	public MaterialAstronomico(int codigo, String nombre,
			TipoMaterial tipo, EstadoMaterial estado) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.estado = estado;
	}

	public int getCodigo() {return codigo;}
	public void setCodigo(int codigo) {this.codigo = codigo;}
	public String getNombre() {return nombre;}
	public void setNombre(String nombre) {this.nombre = nombre;}
	public TipoMaterial getTipo() {return tipo;}
	public void setTipo(TipoMaterial tipo) {this.tipo = tipo;}
	public EstadoMaterial getEstado() {return estado;}
	public void setEstado(EstadoMaterial estado) {this.estado = estado;}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, tipo, estado);
	}

	@Override
	public boolean equals(Object obj) {

		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;

		MaterialAstronomico other = (MaterialAstronomico) obj;

		return codigo == other.codigo
				&& Objects.equals(nombre, other.nombre)
				&& tipo == other.tipo
				&& estado == other.estado;
	}
}