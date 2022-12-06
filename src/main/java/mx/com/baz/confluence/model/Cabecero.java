package mx.com.baz.confluence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class Cabecero {
	
	
	@SerializedName("FCID_TRANSACCION")
	private String fcIdTransaccion;
	@SerializedName("FCIDFLUJO")
	private String fcIdFlujo;
	
	@SerializedName("FIFECHAOPERACION")
	private String fiFechaOperacion;
	@SerializedName("FCINSTITUCION")
	private String fcInstitucion;
	@SerializedName("FCRASTREO")
	private String fcRastreo;
	@SerializedName("FCSTATUS")
	private String fcStatus;
	@SerializedName("FITIPOPAGO")
	private String fiTipoPago;
	@SerializedName("FCNOM_ORD")
	private String fcNomOrd;
	@SerializedName("FCCUENTA_ORD")
	private String fcCuentaOrd;
	@SerializedName("FIFOLIO")
	private String fiFolio;
	@SerializedName("FCNOM_BEN")
	private String fcNomBen;
	@SerializedName("FCCUENTA_BEN")
	private String fcCuentaBen;
	@SerializedName("FIMONTO")
	private String fiMonto;
	@SerializedName("FCCONCEPTOPAGO")
	private String fcConceptoPago; 
	
	private Integer partitionKafka;
	private Integer fkIdConciliacion;


}
