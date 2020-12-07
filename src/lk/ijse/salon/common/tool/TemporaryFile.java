package lk.ijse.salon.common.tool;


import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static com.sun.deploy.cache.Cache.copyFile;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 7/12/2018
 * Time: 6:12 PM
 */
public final class TemporaryFile {
    private File tempFile;
    private Charset charset = StandardCharsets.UTF_8;

    public TemporaryFile(File originalFile, String prefix, String suffix) throws Exception {
        tempFile = File.createTempFile(prefix, suffix);
        copyFile(originalFile, tempFile);
    }

    public TemporaryFile(File originalFile, String suffix) throws Exception {
        tempFile = File.createTempFile("Temp", suffix);
        copyFile(originalFile, tempFile);
        System.out.println(tempFile.getAbsolutePath());
        System.out.println(tempFile.getCanonicalPath());
        System.out.println(tempFile.getPath());
    }

    public TemporaryFile(InputStream originalAsStream, String prefix, String suffix) throws Exception {
//        FileUtils.copyInputStreamToFile(originalAsStream, tempFile = File.createTempFile(prefix, suffix));
//    }

//    public TemporaryFile(String filePath, String prefix, String suffix) throws Exception {
////        this(new File(filePath), prefix, suffix);
//    }
//
//    public void renameFile(String name) {
//
//    }
//
//    private void copyFile(File sourceFile, File destFile) throws Exception {
////        Files.copy( sourceFile.toPath(), destFile.toPath());
//        try (FileChannel source = new FileInputStream(sourceFile.getAbsolutePath()).getChannel();
//             FileChannel destination = new FileOutputStream(destFile).getChannel()) {
//            destination.transferFrom(source, 0, source.size());
//        }
//
//    }
//
//    public void readFile(File file) throws Exception {
//        BufferedReader br = new BufferedReader(new FileReader(file));
//        try {
//            StringBuilder sb = new StringBuilder();
//            String line = "";
//            do {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                System.out.println(line);
//                line = br.readLine();
//            } while (line != null);
//            String everything = sb.toString();
//        } finally {
//            br.close();
//        }
//    }
//
//    public void putParameter(String parameter, String value) throws Exception {
//        Path path = Paths.get(tempFile.toURI());
//
//        String content = new String(Files.readAllBytes(path), charset);
//        content = content.replaceAll(parameter, value);
//        Files.write(path, content.getBytes(charset));
//    }
//
//    public boolean over() {
//        return tempFile.delete();
//    }
//
//    public File getTempFile() {
//        return tempFile;
//    }
    }

}
