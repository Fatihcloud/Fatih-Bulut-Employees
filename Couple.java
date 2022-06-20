import java.util.Objects;

public class Couple {
    private int emp1;
    private int emp2;
    private int pid;
    private int count;

    public Couple(int emp1, int emp2, int pid, int count) {
        this.emp1 = emp1;
        this.emp2 = emp2;
        this.pid = pid;
        this.count = count;
    }

    public int getEmp1() {
        return emp1;
    }

    public void setEmp1(int emp1) {
        this.emp1 = emp1;
    }

    public int getEmp2() {
        return emp2;
    }

    public void setEmp2(int emp2) {
        this.emp2 = emp2;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return  emp1 +
                "," + emp2 +
                "," + count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couple couple = (Couple) o;
        return (emp1 == couple.emp1 && emp2 == couple.emp2) || (emp1 == couple.emp2 && emp2 == couple.emp1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emp1, emp2, pid, count);
    }

}
