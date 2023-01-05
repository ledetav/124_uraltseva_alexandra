package core;

public class Contract {
    private String number;
    private String date;

    public Contract(String number, String date) {
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