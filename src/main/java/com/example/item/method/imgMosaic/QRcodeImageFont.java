package com.example.item.method.imgMosaic;

import cn.hutool.extra.qrcode.QrCodeUtil;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 将指定文本绘在指定图片指定坐标上
 *
 * @author HXM
 * @date 2021年01月22日 15:27
 */
public class QRcodeImageFont {

    public static void main(String[] args) {
        try {
            drawString("https://www.baidu.com/", "D:\\imgTest", "test", "teststst");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 在一张背景图上添加二维码
     */
    public static void drawString(String content, String path, String r, String targetFile) throws Exception {
        // 读取原图片信息
        // 得到文件
        File file = new File(path + "\\" + r);
        BufferedImage image = addWater(content, file);
        // 输出图片
        OutputStream outputStream = new FileOutputStream(path + "\\" + targetFile);
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }

    /***
     * 在一张背景图上添加二维码
     */
    public static BufferedImage addWater(String content, File file) throws Exception {
        //文件转化为图片
        Image srcImg = ImageIO.read(file);
        //获取图片的宽
        int srcImgWidth = srcImg.getWidth(null);
        //获取图片的高
        int srcImgHeight = srcImg.getHeight(null);
        // 加水印
        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bufImg.createGraphics();
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
        //使用工具类生成二维码
        Image image = createQrCode(content, 200, 200);
        //将小图片绘到大图片上,500,300 .表示你的小图片在大图片上的位置。
        g.drawImage(image, 70, 300, null);
        //设置颜色。
        g.setColor(Color.WHITE);
        g.dispose();
        return bufImg;
    }

    private static BufferedImage createQrCode(String content, int width, int height) {
        return QrCodeUtil.generate(content, width, height);
    }

}
