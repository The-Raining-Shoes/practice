package com.example.item.method.imgMosaic;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 根据文本生成二维码
 *
 * @author HXM
 * @date 2021年01月22日 14:42
 */
public class QRCodeUtil {

    public static void main(String[] args) {
        String url = "https://www.baidu.com/";//需要转化二维码的地址链接
        String path = "D:\\imgTest"; //图片保存的位置
        String fileName = "XXX.jpg"; //图片名称
        createQrCode(url, path, fileName, 300);
    }

    public static void createQrCode(String url, String path, String fileName, Integer size) {
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, size, size, hints);
            File file = new File(path, fileName);
            if (file.exists() || ((file.getParentFile().exists() || file.getParentFile().mkdirs()) && file.createNewFile())) {
                writeToFile(bitMatrix, file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeToFile(BitMatrix matrix, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, "jpg", file)) {
            throw new IOException("Could not write an image of format " + "jpg" + " to " + file);
        }
    }

    private static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

}
