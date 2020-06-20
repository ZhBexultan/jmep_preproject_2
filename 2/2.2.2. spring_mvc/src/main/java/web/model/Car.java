package web.model;

public class Car {

    private Long id;
    private String name;
    private int series;
    private int year;

    public Car() {
    }

    public Car(Long id, String name, int series, int year) {
        this.id = id;
        this.name = name;
        this.series = series;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
