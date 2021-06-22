package com.example.item.method.sendMail;

import com.example.item.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
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
public class SendMail {

    public static void main(String[] args) {
        SendMail sendMail = new SendMail();
        try {
            // 抄送人
            String[] copy = {""};
            //发邮件的测试方法
            if (sendEmail("test", "test#", "四单数据.xlsx", "test", sendMail.getMailList(copy), sendMail.creatExcel())) {
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
        list.add("工单编码");
        list.add("工单内容");
        list.add("分公司");
        list.add("员工工号");
        list.add("员工");
        list.add("业务号码");
        list.add("联系人");
        list.add("联系电话");
        list.add("要求回复时间");
        list.add("工单状态");
        list.add("工单完成时间");
        list.add("类型");
        list.add("创建时间");
        String[] str = new String[3];
        str[0] = "测试1";
        str[1] = "测试数据2";
        str[2] = "测试数据3";
        dataList.add(str);
        //创建一个表格
        Workbook workbook = this.handleExcel(list.toArray(new String[0]), dataList);
        ByteArrayInputStream workbooks;
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        OPCPackage opc;
        OutputStream os;
        POIFSFileSystem fs;
        try {
            workbook.write(baos);
            baos.close();
            workbooks = new ByteArrayInputStream(baos.toByteArray());
            // 读取临时文件进行加密
            fs = new POIFSFileSystem();
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.standard);
            Encryptor enc = info.getEncryptor();
            enc.confirmPassword("qywx,.2020");//打开excel 密码
            // 然后把字节输入到输入流，然后输入到OPC包里面
            opc = OPCPackage.open(workbooks);
            os = enc.getDataStream(fs);
            opc.save(os);
            opc.close();
            fs.writeFilesystem(byteOut);
        } catch (IOException | GeneralSecurityException | InvalidFormatException e) {
            e.printStackTrace();
        }
        System.out.println("创建成功 office excel");
        return byteOut;
    }

    public static boolean sendEmail(String from, String fromKey, String fileName, String to, String cc, ByteArrayOutputStream baos) {
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器 ->QQ 邮件服务器
        properties.setProperty("mail.smtp.host", "smtp.189.cn");
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

    private Workbook handleExcel(String[] rowName, List<Object[]> dataList) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(); // 创建工作表
//        sheet.setRandomAccessWindowSize(-1);
        // 定义所需列数
        int columnNum = rowName.length;
        Row rowRowName = sheet.createRow(0);
        // 将列头设置到sheet的单元格中
        for (int n = 0; n < columnNum; n++) {
            Cell cellRowName = rowRowName.createCell(n); // 创建列头对应个数的单元格
            cellRowName.setCellType(CellType.STRING); // 设置列头单元格的数据类型
            cellRowName.setCellValue(new XSSFRichTextString(rowName[n])); // 设置列头单元格的值
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

}
