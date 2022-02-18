// Autor: Iván Ornelas
// Fecha: 14 de febrero de 2021
// Descripción: Conexión a mongo usando "Mongo 2.9.3" jar
// Descarga del jar: 
// https://jar-download.com/artifacts/org.mongodb/mongo-java-driver/2.9.3/source-code
package conexion_java_mongodb;
public class Conexion_JAVA_MongoDB {

    public static void main(String[] args) {
        Conexion conec = new Conexion();
        // Insertar
        // conec.insert("titulo","El principito");
        // Actualizar
        // conec.update("titulo", "El principito", "La odisea");
        // Borrar
        conec.delete("titulo","La odisea");
        // Mostrar toda la colección
        conec.read();
    }
}
