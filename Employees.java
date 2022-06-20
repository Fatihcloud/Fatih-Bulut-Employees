import java.time.LocalDate;

public class Employees {
    private int empId;
    private int projectId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Employees(int empId, int projectId, LocalDate dateFrom, LocalDate dateTo) {
        this.empId = empId;
        this.projectId = projectId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public void setEmpId(int id)
    {
        this.empId = id;
    }

    public int getEmpId(){
        return this.empId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return String.format(
                "EmpID: %d, ProjectID: %d, DateFrom: %s, DateTo: %s",
                this.empId,
                this.projectId,
                dateFrom != null ? dateFrom.toString() : "NaN",
                dateTo != null ? dateTo.toString() : "NaN"
        );
    }
}
