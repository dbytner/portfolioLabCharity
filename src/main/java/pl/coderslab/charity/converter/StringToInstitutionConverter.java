package pl.coderslab.charity.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.institution.Institution;
@Component
public class StringToInstitutionConverter implements Converter<String, Institution> {
    @Override
    public Institution convert(String source) {
        Institution institution = new Institution();
        institution.setId(Long.parseLong(source));
        return institution;
    }
}
