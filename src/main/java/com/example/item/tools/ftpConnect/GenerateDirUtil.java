package com.example.item.tools.ftpConnect;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;

/**
 * @author HXM
 * @date 2020年05月15日 11:11
 */
public class GenerateDirUtil {

    public enum Type {
        DEFAULT,
        FILETYPE
    }

    public static String fileDirectory(File file, Type type) {
        if (Type.FILETYPE.equals(type)) {
            String resDir = "/";
            resDir = new MimetypesFileTypeMap().getContentType(file);
            resDir.replace('\\', '/');
            return "/" + resDir;
        } else {
            String resDir = "/";
            resDir = file.getParent();
            return resDir;
        }
    }
}

