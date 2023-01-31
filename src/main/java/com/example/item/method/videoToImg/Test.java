package com.example.item.method.videoToImg;

import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 视频抓帧数
 */
public class Test {

    public static void main(String[] args) throws FrameGrabber.Exception {
        List<File> files = videoIntercept("D:\\test.mp4", "D:\\", 300, 300);
        System.out.println(files);
    }

    /**
     * 视频文件指定时间段的帧截取
     *
     * @param filePath 文件地址
     * @param start    开始帧
     * @param end      结束帧
     */
    public static List<File> videoIntercept(String filePath, String targetFie, Integer start, Integer end) throws FrameGrabber.Exception {
        List<File> files = new ArrayList<>();
        FFmpegFrameGrabber ff = FFmpegFrameGrabber.createDefault(filePath);
        ff.start();
        int length = ff.getLengthInFrames();
        System.out.println(length);
        System.out.println("开始视频提取帧");
        Frame frame;
        try {
            for (int i = 0; i < length; i++) {
                frame = ff.grabImage();
                if (i >= start && i <= end) {
                    doExecuteFrame(frame, targetFie, "movie", i, files);
                }
            }
            System.out.println("============运行结束============");
            ff.stop();
        } catch (FrameGrabber.Exception ignore) {
        }
        return files;
    }

    public static void doExecuteFrame(Frame frame, String targetFilePath, String targetFileName, int index, List<File> files) {
        if (frame == null || frame.image == null) {
            System.out.println("图片为空");
            return;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        String imageMat = "jpg";
        String fileName = targetFilePath + targetFileName + "_" + index + "." + imageMat;
        BufferedImage bi = converter.getBufferedImage(frame);
        File output = new File(fileName);
        files.add(output);
        try {
            ImageIO.write(bi, imageMat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
