package com.ksiegarnia.tools;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import jakarta.servlet.http.Part;

/** Klasa związana z uploadem plików */
public class FileUpload {

    /** Funkcja przerzuca wybrany plik na server.
     * @param file wgrywany plik
     * @param path ścieżka dla wrzucanych plików
     * @return Funkcja zwraca ścieżkę pliku na serverze
     * */
    public static String uploadImage(Part file, String path) {
        try {
            if (!isImage(file)) {
                throw new RuntimeException("To nie jest zdjęcie");
            }
            path += "/upload/";
            String fileName = getFileName(file);
            file.write(path + fileName);
            return "upload/" + fileName;
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
    /** Funkcja zwracająca nazwę pliku na serverze.
     * @param part wybrany plik
     * @return Funkcja zwraca nazwę pliku lub <b>null</b>
     * */
    private static String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return new Date().getTime() + content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    /** Funkcja sprawdzająca czy podany plik jest obrazkiem.
     * @param part wybrany plik
     * @return Funkcja zwraca <b>true</b> jeśli jest to obrazek, w przeciwnym razie zwraca <b>false</b>.
     * */
    private static boolean isImage(final Part part) {
        String type = part.getContentType();
        return type.contains("image");
    }
    /** Funkcja usuwająca wskazany plik.
     * @param photo nazwa usuwanego pliku
     * @param path ścieżka do plików
     * @return Funkcja zwraca <b>true</b> jeśli udało się usunąć plik, w przeciwnym razie zwraca <b>false</b>.
     * */
    public static boolean deleteFile(String photo,String path) {
        String p = path+photo;
        File file = new File(p);
        if (file.exists()) {
            boolean delete = file.delete();
            return true;
        }
        return false;
    }
}
