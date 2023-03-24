package funcoes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConverterData {
	public Date converterData(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataConvertida = null;
		try {
			dataConvertida = formato.parse(data);
			return dataConvertida;
		} catch (ParseException  e) {			
			return null;
		}
	}
	
	public String converterString(Date data) {
		DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		String stringConvertida = null;
		try {
			stringConvertida = formato.format(data);
			return stringConvertida;
		} catch (Exception e) {
			return null;
		}
	}
}
