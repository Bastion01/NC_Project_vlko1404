package app.entities;

public class User {
    private int user_id;
    private String name;
    private String password;
    private int company_id;
    private Company company = new Company();

    public Company getCompany(){return this.company;}
    public User() {
    }

    public User(int user_id,String name, String password, int company_id) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.company_id = company_id;
    }
//
    public User(String name, String password, int company_id) {
       // this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.company_id = company_id;
    }
    public void setCompany_id(int company_id){this.company_id = company_id;}
    public int getCompany_id(){return this.company_id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int user_id) {
        this.user_id = user_id ;
    }

    public int getId() {
        return user_id;
    }

    public void setPassword(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" + "id= "+user_id +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}