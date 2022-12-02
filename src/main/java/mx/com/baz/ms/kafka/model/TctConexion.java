package mx.com.baz.ms.kafka.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TctConexion {
	private Integer pkIdConexion;
	private String fcDescripcion;
	private String fcTipoBase;
	private String fcUsuario;
	private String fcContrasena;
	private String fcCadenaDeConexion;
	private String fcUsrModif;
	private Date fdFecModif;

}
