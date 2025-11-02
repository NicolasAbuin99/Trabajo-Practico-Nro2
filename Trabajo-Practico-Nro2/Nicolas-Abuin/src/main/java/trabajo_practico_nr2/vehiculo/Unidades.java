package trabajo_practico_nr2.vehiculo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
//Es la única encargada de tomar un número crudo (double) y convertirlo en el texto
public class Unidades {
    public static String formatearPrecio(double precio) {
        // Configura el formato para usar la coma decimal y el punto de miles (Locale "es", "AR")
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("es", "AR"));
        symbols.setCurrencySymbol("$");

        DecimalFormat df = new DecimalFormat("¤#,##0.00", symbols);
        
        // Retorna el formato EXACTO
        return df.format(precio).replace(df.getCurrency().getSymbol(), "$");
    }
}
