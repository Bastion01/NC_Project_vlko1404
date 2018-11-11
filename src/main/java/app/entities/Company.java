package app.entities;

public class Company {
    private int id;
    private String name;
    private int workers_number;
    private int rating;


    public Company() {
    }

    public Company(int id,String name, int workers_number, int rating) {
        this.id = id;
        this.name = name;
        this.workers_number = workers_number;
        this.rating  = rating;
    }
//this comment
    public Company(String name, int workers_number, int rating) {
        this.name = name;
        this.workers_number = workers_number;
        this.rating  = rating;
    }
    public void setJobId(int id){this.id = id;}

    public int getJobId(){return this.id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkers() {
        return workers_number;
    }

    public void setWorkers(int workers_number) {
        this.workers_number = workers_number;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }



    @Override
    public String toString() {
        return "Company{" + "id= "+id +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (name != null ? !name.equals(company .name) : company.name != null) return false;
        return (rating == company.rating && workers_number == company.workers_number);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result;
        return result;
    }
}