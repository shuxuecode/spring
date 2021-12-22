import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;


public class WordTest {

    public static void getFiles() throws IOException {

        File file = new File("C:\\Soft\\caddy\\file");
        File[] files = file.listFiles();
        String str = "";
        for (File ff : files){
            str += readFileByLines(ff.getAbsolutePath());
//            String s = readFileByLines(ff.getAbsolutePath());
//            System.out.println(ff.getName());
//            System.out.println(s);
//            System.out.println();
//            System.out.println();
//            System.out.println();
        }

        toword(str);
    }

    static String lineBreak = "\r\n"; // System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {

        getFiles();



    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(String fileName) {

        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            StringBuffer sb = new StringBuffer();
            sb.append(lineBreak);
            sb.append(file.getName() + "" + lineBreak);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                sb.append(line + "   " + tempString + "" + lineBreak);
                line++;
            }
            reader.close();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(sb.toString());
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return "";
    }



    /**
     * 基本的写操作
     *
     * @throws Exception
     */
    public static void toword(String text) throws IOException {
        //新建一个文档
        XWPFDocument doc = new XWPFDocument();

        String[] split = text.split(lineBreak);
        for(String str : split){
            doc.createParagraph().createRun().setText(str);
        }


        //创建一个段落
//        XWPFParagraph para = doc.createParagraph();

        //一个XWPFRun代表具有相同属性的一个区域。
//        XWPFRun run = para.createRun();
//        run.setText(text);
//        run.setBold(true); //加粗
//        run.setText("加粗的内容");
//        run = para.createRun();
//        run.setColor("FF0000");
//        run.setText("红色的字。");
        OutputStream os = new FileOutputStream("D:\\code.docx");
        //把doc输出到输出流
        doc.write(os);

        os.close();
    }
}
