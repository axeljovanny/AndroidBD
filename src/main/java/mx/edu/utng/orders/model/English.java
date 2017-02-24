package mx.edu.utng.orders.model;

/**
 * Created by axeljovanny on 23/02/17.
 */

public class English {

        private  String idEnglish;
        private String value;
        private String abbreviation;
        private String spelling;

    public English(String idEnglish, String value, String abbreviation, String spelling) {
        this.idEnglish = idEnglish;
        this.value = value;
        this.abbreviation = abbreviation;
        this.spelling = spelling;
    }
    public English(){
        this("","","","");
    }


    public String getIdEnglish() {
        return idEnglish;
    }

    public void setIdEnglish(String idEnglish) {
        this.idEnglish = idEnglish;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling;
    }

    @Override
    public String toString() {
        return "English{" +
                "idEnglish='" + idEnglish + '\'' +
                ", value='" + value + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", spelling='" + spelling + '\'' +
                '}';
    }
}
