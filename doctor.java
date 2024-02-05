public class doctor {
    private String id;
    private String name;
    private String degree;
    private String passoutyear;
    private String status;



    public doctor(String id, String name, String degree, String passoutyear, String status)//parametarized constructor
    {
        this.id = id;
        this.name = name;
        this.degree = degree;
        this.passoutyear = passoutyear;
        this.status = status;
    }
//encapsulation part
    public String getId() {
        return id;
    }//it returns the value of variable ID

    public void setId(String id) {
        this.id = id;
    }//it takes parameters and assign it to variable

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name= name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPassoutyear() {
        return passoutyear;
    }

    public void setPassoutyear(String passoutyear) {
        this.passoutyear = passoutyear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String toString()//for string representation of data
    {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Degree='" + degree+ '\'' +
                ", In Service From='" + passoutyear + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

