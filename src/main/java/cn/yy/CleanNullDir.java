package cn.yy;

import java.io.File;

public class CleanNullDir {
    private boolean needClean = false;
    private int cleanNumber = 0;

    public static void main(String[] args) {
        // C盘可能清理不完全。
//        String needCleanDir = "C:/";
//        String needCleanDir = "D:/";
//        String needCleanDir = "E:/";
        String needCleanDir = "F:/";
        CleanNullDir cleanNullDir = new CleanNullDir();

        do {
            cleanNullDir.needClean = false;
            cleanNullDir.cleanNumber = 0;
            cleanNullDir.cleanNullDir(new File(needCleanDir));
            System.out.println("cleanNumber: " + cleanNullDir.cleanNumber);
        } while (cleanNullDir.needClean);

        System.out.println("clean success!");
    }

    private void cleanNullDir(File dir) {
        if (dir.isFile()) {
            return;
        }
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            boolean nullDir = files == null || files.length == 0;
            if (nullDir) {
                boolean deleted = dir.delete();
                if (deleted) {
                    needClean = true;
                    cleanNumber += 1;
                    System.out.println(true + " deleted " + dir);
                }
                return;
            }

            for (File file : files) {
                cleanNullDir(file);
            }
        }
    }
}
