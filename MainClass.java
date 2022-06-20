import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        long tstart = System.currentTimeMillis();
        CsvOkuma reader = new CsvOkuma();
        try {
            Map<Integer, List<Employees>> employeeGroups;
            PriorityQueue<Couple> couplePriorityQueue = new PriorityQueue<>(Comparator.comparingInt(Couple::getCount).reversed());
            List<Employees> entries = reader.read("/Users/fatihcloud/IdeaProjects/cvs/src/data.csv");
            System.out.println("Employees");
            entries.stream().forEach(System.out::println);

            employeeGroups = entries.stream().collect(Collectors.groupingBy(Employees::getProjectId));

            List<Couple> couples = new ArrayList<>();
            employeeGroups.forEach((k, v) -> {

                for (int i = 0; i < v.size(); i++)
                    for (int j = i + 1; j < v.size(); j++){
                        Employees e1 = v.get(i);
                        Employees e2 = v.get(j);

                        if (e1.getEmpId() != e2.getEmpId()){
                            LocalDate start =
                                    e1.getDateFrom().compareTo(e2.getDateFrom()) > 0 ? e1.getDateFrom() : e2.getDateFrom();
                            LocalDate end =
                                    e1.getDateTo().compareTo(e2.getDateTo()) < 0 ? e1.getDateTo() : e2.getDateTo();
                            int count = (int) ChronoUnit.DAYS.between(start,end);
                            Couple couple = new Couple(
                                    e1.getEmpId(),e2.getEmpId(), k,
                                    Math.max(count, 0)
                            );
                            int find = couples.indexOf(couple);
                            if (find > -1){
                                Couple c2 = couples.get(find);
                                c2.setCount(c2.getCount() + couple.getCount());
                            }
                            else
                                couples.add(couple);
                        }
                    }
            });

            for (int i = 0; i < couples.size(); i++){

                Couple couple1 = couples.get(i);

                for (int j = i + 1; j < couples.size(); j++){
                    Couple couple2 = couples.get(j);
                    if (couple1.equals(couple2)){
                        couple1.setCount( couple1.getCount() + couple2.getCount());
                    }
                }
                couplePriorityQueue.add(couple1);
            }

            System.out.println(couplePriorityQueue.poll());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        long tstop = System.currentTimeMillis();
        System.out.printf("Duration: %dms",tstop - tstart);
    }
}
