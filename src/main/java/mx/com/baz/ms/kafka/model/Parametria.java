package mx.com.baz.ms.kafka.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parametria {
	private ArrayList<TcConciliacion> conciliacion;
	private ArrayList<TcParamConc> parametrosConciliacion;
	private ArrayList<TcOrigenes> origenes;
	private ArrayList<TctConexion> conexion;
}
