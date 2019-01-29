package library.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DatepublishConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String theId) {
		System.out.println("Podejscie coverters pierwsze localDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if ((theId == null || theId.isEmpty())) {
			return null;
		} else {
			try {
				return LocalDate.parse(theId, formatter);
			} catch (ConversionFailedException exc) {
				return null;
			}
		}
	}

}
