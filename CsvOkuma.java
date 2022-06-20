import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvOkuma
{
    public List<Employees> read(String args) throws FileNotFoundException
    {
        File dosya = new File(args);
        List<Employees> rows = new ArrayList<>();

        Scanner s = new Scanner(dosya);
        while(s.hasNextLine()) {
            String[] girdi = s.nextLine().split(",");
            rows.add(new Employees(
                    Integer.parseInt(girdi[0].trim()),
                    Integer.parseInt(girdi[1].trim()),
                    !girdi[2].trim().equals("NULL") ? LocalDate.parse(girdi[2].trim()) : LocalDate.now(),
                    !girdi[3].trim().equals("NULL") ? LocalDate.parse(girdi[3].trim()) : LocalDate.now()
            ));
        }
        s.close();
        return rows;
    }
}

