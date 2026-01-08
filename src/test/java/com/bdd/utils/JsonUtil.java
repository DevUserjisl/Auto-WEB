package com.bdd.utils;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtil {


    private static final String BASE_PATH = "src/test/resources/data/";

    public static void guardarValor(String clave, String nombreArchivo, String valor) {
        String rutaCompleta = BASE_PATH + nombreArchivo;
        try {
            JsonObject jsonObject = cargarJsonExistente(rutaCompleta);
            jsonObject.addProperty(clave, valor);
            guardarJson(rutaCompleta, jsonObject);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar valor String en JSON", e);
        }
    }

    public static void guardarValor(String clave, String nombreArchivo, int valor) {
        String rutaCompleta = BASE_PATH + nombreArchivo;
        try {
            JsonObject jsonObject = cargarJsonExistente(rutaCompleta);
            jsonObject.addProperty(clave, valor);
            guardarJson(rutaCompleta, jsonObject);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar valor int en JSON", e);
        }
    }

    public static String leerValor(String clave, String nombreArchivo) {
        String rutaCompleta = BASE_PATH + nombreArchivo;
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(rutaCompleta)));
            JsonObject jsonObject = new Gson().fromJson(contenido, JsonObject.class);
            return jsonObject.get(clave).getAsString();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer valor del archivo JSON", e);
        }
    }


    private static JsonObject cargarJsonExistente(String rutaArchivo) throws IOException {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            return new Gson().fromJson(contenido, JsonObject.class);
        } else {
            archivo.getParentFile().mkdirs();
            archivo.createNewFile();
            return new JsonObject();
        }
    }

    private static void guardarJson(String rutaArchivo, JsonObject jsonObject) throws IOException {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            new Gson().toJson(jsonObject, writer);
        }
    }
}
