package se.sakilagui.Model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RatingAttributeConverter implements AttributeConverter<RatingEnum, String> {
    @Override
    public String convertToDatabaseColumn(RatingEnum attribute) {
        if (attribute == null)
            return null;

        switch (attribute) {
            case G:
                return "G";

            case R:
                return "R";

            case PG:
                return "PG";

            case PG13:
                return "PG-13";

            case NC17:
                return "NC-17";

            default:
                throw new IllegalArgumentException(attribute + " not supported.");
        }
    }

    @Override
    public RatingEnum convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        switch (dbData) {
            case "G":
                return RatingEnum.G;

            case "R":
                return RatingEnum.R;

            case "PG":
                return RatingEnum.PG;

            case "PG-13":
                return RatingEnum.PG13;

            case "NC-17":
                return RatingEnum.NC17;

            default:
                throw new IllegalArgumentException(dbData + " not supported.");
        }
    }

}



