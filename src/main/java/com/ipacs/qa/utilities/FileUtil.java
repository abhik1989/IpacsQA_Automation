package com.ipacs.qa.utilities;

import java.io.File;

public class FileUtil {

    public static void clearDownloadDirectory(String downloadPath) {
        File downloadDir = new File(downloadPath);

        if (downloadDir.exists() && downloadDir.isDirectory()) {
            File[] files = downloadDir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        boolean deleted = file.delete();
                        if (deleted) {
                            System.out.println("Deleted: " + file.getName());
                        } else {
                            System.out.println("Failed to delete: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Download path does not exist or is not a directory: " + downloadPath);
        }
    }
    
   
        /**
         * Counts how many files in the given directory contain the specified keyword in their filename.
         *
         * @param downloadPath The directory where files are downloaded
         * @param fileNameKeyword The keyword to match in filenames
         * @return Number of matching files
         */
        public static int countFilesWithKeyword(String downloadPath, String fileNameKeyword) {
            File dir = new File(downloadPath);
            File[] dirContents = dir.listFiles();
            int count = 0;

            if (dirContents != null) {
                for (File file : dirContents) {
                    if (file.getName().contains(fileNameKeyword)) {
                        count++;
                    }
                }
            }

            return count;
        }

        /**
         * Checks if a new file has been downloaded by comparing current file count against previous count.
         *
         * @param downloadPath The directory to check
         * @param fileNameKeyword The keyword that downloaded file should contain
         * @param oldCount The number of matching files before download
         * @return True if a new file with the keyword has been downloaded, false otherwise
         */
        public static boolean isNewFileDownloaded(String downloadPath, String fileNameKeyword, int oldCount) {
            int newCount = countFilesWithKeyword(downloadPath, fileNameKeyword);
            return newCount > oldCount;
        }
    }



