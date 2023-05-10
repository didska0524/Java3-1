package jdbc_study;

public class Student {
    private String id;
    private String name;
    private String dept;

    public Student(String id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public Student(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDept() {
        return this.dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String toString() {
        return this.id + "\t" + this.name + "\t" + this.dept + "\n";
    }

    public static void main(String[] args) {
    }
}