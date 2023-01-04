package core;

public class Contract {
    private String number;
    private String date;

    public Contract(String number, String date) {
        if (number == null || number.isEmpty()) {
            throw new IllegalArgumentException("Contract number cannot be null or empty");
        }
        if (date == null || date.trim().length() != 8) {
            throw new IllegalArgumentException("Date must be in YYYYMMDD format");
        }
        this.number = number;
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }
}
