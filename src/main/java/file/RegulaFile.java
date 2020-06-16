package file;



import java.io.File;
import java.io.IOException;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegulaFile {


    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println(org.apache.http.client.utils.DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -1), "yyMMdd"));
        File file = new File("C:\\Users\\hasee\\Desktop");
        Path path = file.toPath();
        System.out.println(path);
        Pattern pattern = Pattern.compile("^INN"+org.apache.http.client.utils.DateUtils.formatDate(org.apache.commons.lang3.time.DateUtils.addDays(new Date(), -1), "yyMMdd")+"+.*410350248160046$");
        List<Path> paths = Files.walk(path).filter(p -> {
            //如果不是普通的文件，则过滤掉
            if(!Files.isRegularFile(p)) {
                return false;
            }
            File file1 = p.toFile();
            Matcher matcher = pattern.matcher(file1.getName());
            return matcher.matches();
        }).collect(Collectors.toList());
        System.out.println(paths);
    }
}
