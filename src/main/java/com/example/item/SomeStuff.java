package com.example.item;

import com.example.item.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 测试数据
 *
 * @author HXM
 * @date 2020年04月13日 9:18
 */
@Slf4j
public class SomeStuff {

    public static void main(String[] args) {
        SomeStuff someStuff = new SomeStuff();
        try {
            String[] copy = {""};
            //发邮件的测试方法
            if (sendEmail("625430265@qq.com", "shryslexyeyqbeci", "四单数据.xlsx", "1979274692@qq.com", someStuff.getMailList(copy), someStuff.creatExcel())) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ByteArrayOutputStream creatExcel() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        List<String> list = new ArrayList<>();
        List<Object[]> dataList = new ArrayList<>();
        list.add("标题1");
        list.add("标题2");
        String[] str = new String[2];
        str[0] = "测试";
        str[1] = "测试数据啊啊啊";
        dataList.add(str);
        //创建一个表格
        Workbook workbook = this.handleExcle(list.toArray(new String[0]), dataList);
        try {
            workbook.write(baos);
            baos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建成功 office excel");
        return baos;
    }

    public static boolean sendEmail(String from, String fromKey, String fileName, String to, String cc, ByteArrayOutputStream baos) {
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器 ->QQ 邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.qq.com");
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, fromKey); //发件人邮件用户名、授权码
            }
        });

        try {
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);
            // 邮件发送人
            message.setFrom(new InternetAddress(from));
            // 邮件接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 邮件抄送人
            if (cc.length() > 0) {
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            // Set Subject: 头部头字段
            message.setSubject("每日文件提取数据");
            /*添加附件*/
            Multipart multipart = new MimeMultipart();
            if (baos != null) {
                MimeBodyPart fileBody = new MimeBodyPart();
                DataSource source = new ByteArrayDataSource(baos.toByteArray(), "application/msexcel");
                fileBody.setContent("设置邮箱内容", "text/html;charset=UTF-8");
                fileBody.setDataHandler(new DataHandler(source));
                // 中文乱码问题
                fileBody.setFileName(MimeUtility.encodeText(fileName));
                multipart.addBodyPart(fileBody);
            }
            message.setContent(multipart);
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....from runoob.com");
            return true;
        }  // TODO Auto-generated catch block
        catch (IOException | javax.mail.MessagingException mex) {
            mex.printStackTrace();
        }
        return false;
    }

    public String getMailList(String[] mailArray) {
        StringBuilder toList = new StringBuilder();
        int length = mailArray.length;
        if (length < 2) {
            toList.append(mailArray[0]);
        } else {
            for (int i = 0; i < length; i++) {
                toList.append(mailArray[i]);
                if (i != (length - 1)) {
                    toList.append(",");
                }

            }
        }
        return toList.toString();
    }

    private Workbook handleExcle(String[] rowName, List<Object[]> dataList) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        workbook.writeProtectWorkbook("qywx,.2020", "qywx");
        Sheet sheet = workbook.createSheet("四单使用情况加密数据"); // 创建工作表
//        sheet.setRandomAccessWindowSize(-1);
        // 定义所需列数
        int columnNum = rowName.length;
        Row rowRowName = sheet.createRow(0);
        // 将列头设置到sheet的单元格中
        for (int n = 0; n < columnNum; n++) {
            Cell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
            cellRowName.setCellType(CellType.STRING); // 设置列头单元格的数据类型
            cellRowName.setCellValue(new HSSFRichTextString(rowName[n])); // 设置列头单元格的值
        }
        // 将查询出的数据设置到sheet对应的单元格中
        for (int i = 0; i < dataList.size(); i++) {
            Object[] obj = dataList.get(i);// 遍历每个对象
            Row row = sheet.createRow(i + 1);// 创建所需的行数
            for (int j = 0; j < obj.length; j++) {
                Cell cell = row.createCell(j, CellType.STRING);
                if (CheckUtil.isNotBlank(obj)) {
                    cell.setCellValue(obj[j].toString()); // 设置单元格的值
                } else {
                    cell.setCellValue(""); // 设置单元格的值
                }
            }
        }
        // 让列宽随着导出的列长自动适应
        for (int colNum = 0; colNum < columnNum; colNum++) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                Row currentRow;
                // 当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    Cell currentCell = currentRow.getCell(colNum);
                    if (currentCell != null && currentCell.getCellTypeEnum() == CellType.STRING) {
                        if (null != currentCell.getRichStringCellValue()) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
            }
            if (colNum == 0) {
                sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
            } else {
                sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
            }
        }
        return workbook;
    }

//    public static void main(String[] args) {
//        String str = "aaabbcccccdd";
//        int length = str.length();
//        StringBuilder result = new StringBuilder();
//        char firstWord = str.charAt(0);
//        int sum = 1;
//        for (int i = 1; i < length; i++) {
//            if (firstWord == str.charAt(i)) {
//                sum += 1;
//                continue;
//            }
//            result.append(sum).append(firstWord);
//            firstWord = str.charAt(i);
//            sum = 1;
//        }
//        // 加上最后一个字符及个数，并打印输出
//        System.out.println(result.append(sum).append(firstWord));
//        while (true) {
//            log.info("1233211231321341241");
//        }
//    }

//    public static void main(String[] args) throws InterruptedException {
//        // 多线程的使用
//        ExecutorService exec = Executors.newFixedThreadPool(300);
//        AtomicInteger i = new AtomicInteger();
//        exec.execute(() -> {
//            if (i.get() < 1000000000) {
//                i.getAndIncrement();
//                System.out.println(i);
//            }
//        });
//        exec.shutdown();
//        while (!exec.awaitTermination(1, TimeUnit.MINUTES)) {
//            System.out.println("其他线程池没有关闭");
//        }
//    }
}