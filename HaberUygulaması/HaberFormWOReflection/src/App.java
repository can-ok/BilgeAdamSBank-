import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

public class App {


    public static void main(String[] args) throws FileNotFoundException {

        List<String> className=new ArrayList<>();

        ZipInputStream zip=new ZipInputStream(
                new FileInputStream("C:\\Users\\canok\\BilgeAdamCalisma\\HaberUygulaması\\HaberFormWOReflection\\RssScraper\\"));

    }
}
